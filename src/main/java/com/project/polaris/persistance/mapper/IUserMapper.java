package com.project.polaris.persistance.mapper;

import com.project.polaris.domain.dto.UserDto;
import com.project.polaris.persistance.entity.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface IUserMapper {

    UserDto toUserDto(UserEntity userEntity);

    @InheritInverseConfiguration
    @Mapping(target = "password", ignore = true)
    UserEntity toUserEntity(UserDto userDto);
    List<UserDto> toUserDtoList(List<UserEntity>userEntities);

}
