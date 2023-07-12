package com.project.polaris.domain.Iservice;

import com.project.polaris.domain.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    List<UserDto> getAll();
    Optional<UserDto> getUser(Long idUser);
    UserDto save(UserDto newUserDto);
    boolean delete(Long idUser);
}
