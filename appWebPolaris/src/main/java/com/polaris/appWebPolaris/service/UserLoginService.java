package com.polaris.appWebPolaris.service;

import com.polaris.appWebPolaris.dto.UserLoginDto;
import com.polaris.appWebPolaris.model.UserLogin;

import java.util.List;
import java.util.Optional;

public interface UserLoginService {

    List<UserLoginDto> findAll();
    Optional<UserLoginDto> findById(Long id);
    UserLogin save(UserLoginDto userLoginDto);
    boolean delete(Long id);


}
