package com.polaris.appWebPolaris.domain.service;

import com.polaris.appWebPolaris.domain.dto.AuthCustomerDto;
import com.polaris.appWebPolaris.domain.dto.InstitutionDto;
import com.polaris.appWebPolaris.domain.dto.JwtResponseDto;
import com.polaris.appWebPolaris.domain.dto.VolunteerDto;
import com.polaris.appWebPolaris.domain.repository.IAuthUseCase;
import com.polaris.appWebPolaris.domain.repository.IInstitutionRepository;
import com.polaris.appWebPolaris.domain.repository.IVolunteerRepository;
import com.polaris.appWebPolaris.exception.CustomerNotExistException;
import com.polaris.appWebPolaris.exception.PasswordIncorrectException;
import com.polaris.appWebPolaris.security.JwtAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Servicio encargado del logueo de un usuario
 */
@RequiredArgsConstructor
@Service
public class AuthService implements IAuthUseCase {

    private final IVolunteerRepository iCustomerRepository;
    private final IInstitutionRepository iInstitutionRepository;
    private final JwtAuthenticationProvider jwtAuthenticationProvider;


    private final PasswordEncoder passwordEncoder;

    /**
     * Devuelve un dto con el jwt del usuario dadas unas credenciales
     *
     * @param authCustomerDto Credenciales de acceso
     * @return Dto con el jwt del usuario si las credenciales son validas
     */
    public JwtResponseDto signIn(AuthCustomerDto authCustomerDto) {

        Optional<VolunteerDto> volunter = iCustomerRepository.getVolunteerByEmail(authCustomerDto.getEmail());

        if (volunter.isEmpty()) {
            throw new CustomerNotExistException();
        }

        if (!passwordEncoder.matches(authCustomerDto.getPassword(), volunter.get().getPassword())) {
            throw new PasswordIncorrectException();
        }


        return new JwtResponseDto(jwtAuthenticationProvider.createToken(volunter.get()));
    }

    public JwtResponseDto signInInstitution(AuthCustomerDto authCustomerDto) {

        Optional<InstitutionDto> institution = iInstitutionRepository.getInstitutionByEmail(authCustomerDto.getEmail());

        if (institution.isEmpty()) {
            throw new CustomerNotExistException();
        }

        if (!passwordEncoder.matches(authCustomerDto.getPassword(), institution.get().getPassword())) {
            throw new PasswordIncorrectException();
        }

        return new JwtResponseDto(jwtAuthenticationProvider.createTokenInstitution(institution.get()));
    }

    /**
     * Cierra la sesión eliminando de la lista blanca el token ingresado
     *
     * @param token Token a eliminar
     * @return
     */
    public JwtResponseDto signOut(String token) {

        String[] authElements = token.split(" ");
        return new JwtResponseDto(jwtAuthenticationProvider.deleteToken(authElements[1]));
    }
}
