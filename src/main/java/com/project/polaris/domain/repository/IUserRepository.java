package com.project.polaris.domain.repository;

import com.project.polaris.domain.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {

    List<UserDto> getAll();
    Optional<UserDto> getUser(Long idUser);
    UserDto save(UserDto newUserDto);
    void delete(Long idUser);
}
