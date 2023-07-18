package com.polaris.appWebPolaris.domain.service;

import com.polaris.appWebPolaris.domain.dto.*;
import com.polaris.appWebPolaris.domain.repository.IAuthUseCase;
import com.polaris.appWebPolaris.domain.repository.ICustomerRepository;
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

    private final ICustomerRepository iCustomerRepository;
    private final JwtAuthenticationProvider jwtAuthenticationProvider;

    private final PasswordEncoder passwordEncoder;

    /**
     * Devuelve un dto con el jwt del usuario dadas unas credenciales
     *
     * @param authCustomerDto Credenciales de acceso
     * @return Dto con el jwt del usuario si las credenciales son validas
     */
    public JwtResponseDto signIn(AuthCustomerDto authCustomerDto) {

        Optional<CustomerDto> customer = iCustomerRepository.getCustomerByEmail(authCustomerDto.getEmail());

        if (customer.isEmpty()) {
            throw new CustomerNotExistException();
        }

        if (!passwordEncoder.matches(authCustomerDto.getPassword(), customer.get().getPassword())) {
            throw new PasswordIncorrectException();
        }


        return new JwtResponseDto(jwtAuthenticationProvider.createToken(customer.get()));
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
