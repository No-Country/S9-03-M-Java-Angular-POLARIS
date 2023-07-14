package com.polaris.appWebPolaris.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.polaris.appWebPolaris.domain.dto.VolunteerDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Clase encargada de la creacion y validacion de jwt para el inicio de sesion de un Usuario
 */
@Component
public class JwtAuthenticationProvider {

    /**
     * Llave para cifrar el jwt
     */
    @Value("${jwt.secret.key}")
    private String secretKey;

    /**
     * Lista blanca con los jwt creados
     */
    private HashMap<String, VolunteerDto> listToken = new HashMap<>();

    /**
     * Crea un nuevo jwt en base al cliente recibido por parametro y lo agrega a la lista blanca
     *
     * @param volunteerJwt Cliente a utilizar en la creacion del jwt
     * @return Jwt creado
     */
    public String createToken(VolunteerDto volunteerJwt) {

        Date now = new Date();
        Date validity = new Date(now.getTime() + 3600000); // 1 hora en milisegundos

        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        String tokenCreated = JWT.create()
                .withClaim("ID", volunteerJwt.getId())
                .withClaim("email", volunteerJwt.getEmail())
                .withClaim("rol", volunteerJwt.getRol())
                .withIssuedAt(now)
                .withExpiresAt(validity)
                .sign(algorithm);

        listToken.put(tokenCreated, volunteerJwt);
        return tokenCreated;
    }

    /**
     * Valida si el token es valido y retorna una sesión del usuario
     *
     * @param token Token a validar
     * @return Sesion del usuario
     * @throws CredentialsExpiredException Si el token ya expiró
     * @throws BadCredentialsException     Si el token no existe en la lista blanca
     */
    public Authentication validateToken(String token) throws AuthenticationException {

        System.out.println("entre tambien aqui");
        System.out.println(token);

        //verifica el token como su firma y expiración, lanza una excepcion si algo falla
        JWT.require(Algorithm.HMAC256(secretKey)).build().verify(token);


        VolunteerDto exists = listToken.get(token);
        if (exists == null) {
            throw new BadCredentialsException("Usuario no registrado.");
        }

        HashSet<SimpleGrantedAuthority> rolesAndAuthorities = new HashSet<>();
        rolesAndAuthorities.add(new SimpleGrantedAuthority("ROLE_" + exists.getRol())); //rol

        return new UsernamePasswordAuthenticationToken(exists, token, rolesAndAuthorities);
    }

    public String deleteToken(String jwt) {

        if (!listToken.containsKey(jwt)) {
            return "No existe token";
        }

        listToken.remove(jwt);
        return "Sesión cerrada exitosamente";
    }

}
