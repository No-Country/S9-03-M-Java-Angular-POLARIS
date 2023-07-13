//package com.polaris.appWebPolaris.mapper;
//
//import com.polaris.appWebPolaris.dto.UserLoginDto;
//import com.polaris.appWebPolaris.model.UserLogin;
//import org.mapstruct.InheritInverseConfiguration;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.Mappings;
//
//import java.util.List;
//
//@Mapper(componentModel = "spring")
//public interface UserMapper {
//    @Mappings({
//            @Mapping(target = "email", source = "email"),
//            @Mapping(target = "password", source = "password"),
//            @Mapping(target = "role", source = "role"),
//            @Mapping(target = "profileId", source = "userProfile.id"),
//            @Mapping(target = "workId", source = "works.id")})
//    UserLoginDto toUserLoginDto(UserLogin userLogin);
//    @InheritInverseConfiguration
//    UserLogin toUserLogin(UserLoginDto userLoginDto);
//    List<UserLoginDto> toUserLoginDto(List<UserLogin> userLoginList);
//}
