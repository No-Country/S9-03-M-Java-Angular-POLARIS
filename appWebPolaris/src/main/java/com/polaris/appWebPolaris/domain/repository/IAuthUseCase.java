package com.polaris.appWebPolaris.domain.repository;


import com.polaris.appWebPolaris.domain.dto.AuthCustomerDto;
import com.polaris.appWebPolaris.domain.dto.JwtResponseDto;

public interface IAuthUseCase {

    JwtResponseDto signIn(AuthCustomerDto authCustomerDto);

    JwtResponseDto signOut(String jwt);
}
