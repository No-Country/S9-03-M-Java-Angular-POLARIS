package com.project.polaris.domain.service;

import com.project.polaris.domain.Iservice.IUserService;
import com.project.polaris.domain.dto.UserDto;
import com.project.polaris.domain.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService implements IUserService {

    private final IUserRepository iUserRepository;

    @Override
    public List<UserDto> getAll() {
        return iUserRepository.getAll();
    }

    @Override
    public Optional<UserDto> getUser(Long idUser) {
        return iUserRepository.getUser(idUser);
    }

    @Override
    public UserDto save(UserDto newUserDto) {
        return iUserRepository.save(newUserDto);
    }

    @Override
    public boolean delete(Long idUser) {
        if(iUserRepository.getUser(idUser).isEmpty()){
            return false;
        }
        iUserRepository.delete(idUser);
        return true;
    }

}
