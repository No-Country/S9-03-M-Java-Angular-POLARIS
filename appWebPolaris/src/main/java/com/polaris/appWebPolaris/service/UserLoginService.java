package com.polaris.appWebPolaris.service;

import com.polaris.appWebPolaris.dto.UserLoginDto;
import com.polaris.appWebPolaris.model.UserLogin;

import java.util.List;
import java.util.Optional;

public interface UserLoginService {

    List<UserLogin> findAll();
    Optional<UserLogin> findById(Long id);
    UserLogin save(UserLoginDto userLoginDto);
    //    UserLogin update(Long id, UserLogin userLogin);
    boolean delete(Long id);


}
