package com.polaris.appWebPolaris.mapper;

import com.polaris.appWebPolaris.dto.UserLoginDto;
import com.polaris.appWebPolaris.model.UserLogin;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import java.util.List;

public interface UserMapper {
    UserLoginDto toUserLoginDto(UserLogin userLogin);
    //@InheritInverseConfiguration
    UserLogin toUserLogin(UserLoginDto userLoginDto);
    List<UserLoginDto> toUserLoginDto(List<UserLogin> userLoginList);
}
