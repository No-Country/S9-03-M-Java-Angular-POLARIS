package com.polaris.appWebPolaris.service.impl;

import com.polaris.appWebPolaris.dto.UserLoginDto;
import com.polaris.appWebPolaris.mapper.UserMapper;
import com.polaris.appWebPolaris.mapper.impl.UserMapperImpl;
import com.polaris.appWebPolaris.model.UserLogin;
import com.polaris.appWebPolaris.repository.UserLoginRepository;
import com.polaris.appWebPolaris.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserLoginService {

    private final UserLoginRepository userLoginRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserLoginRepository userLoginRepository, UserMapperImpl userMapper) {
        this.userLoginRepository = userLoginRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserLogin> findAll() {
        return userLoginRepository.findAll();
    }

    @Override
    public Optional<UserLogin> findById(Long id) {
        return userLoginRepository.findById(id);
    }

    @Override
    public UserLogin save(UserLoginDto userLoginDto) {
        return userLoginRepository.save(userMapper.toUserLogin(userLoginDto));

    }

    @Override
    public boolean delete(Long id) {
        return findById(id).map(userLoginDto -> {
            userLoginRepository.deleteById(id);
            return true;
        }).orElse(false);
    }
}
