package com.polaris.appWebPolaris.mapper;

import com.polaris.appWebPolaris.dto.UserLoginDto;
import com.polaris.appWebPolaris.model.UserLogin;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "profileId", source = "profile.id")
    @Mapping(target = "workId", source = "work.id")
    UserLoginDto toUserLoginDto(UserLogin userLogin);
    @InheritInverseConfiguration
    UserLogin toUserLogin(UserLoginDto userLoginDto);
    List<UserLoginDto> toUserLoginDto(List<UserLogin> userLoginList);
}
