package com.polaris.appWebPolaris.mapper.impl;

import com.polaris.appWebPolaris.dto.UserLoginDto;
import com.polaris.appWebPolaris.mapper.UserMapper;
import com.polaris.appWebPolaris.model.UserLogin;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class UserMapperImpl implements UserMapper {
    @Override
    public UserLoginDto toUserLoginDto(UserLogin userLogin) {
        return null;
    }

    @Override
    public UserLogin toUserLogin(UserLoginDto userLoginDto) {
        UserLogin userLogin = new UserLogin();
        userLogin.setEmail(userLoginDto.getEmail());
        userLogin.setPassword(userLoginDto.getPassword());
        userLogin.setRole(userLoginDto.getRole());
        userLogin.setProfile(userLoginDto.getProfile());

        return userLogin;
    }

    @Override
    public List<UserLoginDto> toUserLoginDto(List<UserLogin> userLoginList) {
        return null;
    }
}
