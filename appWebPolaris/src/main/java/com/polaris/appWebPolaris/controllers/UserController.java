package com.polaris.appWebPolaris.controllers;

import com.polaris.appWebPolaris.dto.UserLoginDto;
import com.polaris.appWebPolaris.model.UserLogin;
import com.polaris.appWebPolaris.service.UserLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserLoginService userLoginService;


    @PostMapping
    public ResponseEntity<UserLogin> save(@RequestBody UserLoginDto userLoginDto){
        return ResponseEntity.ok(userLoginService.save(userLoginDto));
    }
}
