package com.polaris.appWebPolaris.service.impl;

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
//    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserLoginRepository userLoginRepository) {
        this.userLoginRepository = userLoginRepository;
//        this.userMapper = userMapper;
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
    public UserLogin save(UserLogin userLogin) {
        return userLoginRepository.save(userLogin);
    }

    @Override
    public boolean delete(Long id) {
        return findById(id).map(userLoginDto -> {
            userLoginRepository.deleteById(id);
            return true;
        }).orElse(false);
    }
}
