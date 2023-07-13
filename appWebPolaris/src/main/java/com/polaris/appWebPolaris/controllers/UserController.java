package com.polaris.appWebPolaris.controllers;

import com.polaris.appWebPolaris.model.UserLogin;
import com.polaris.appWebPolaris.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/user")
public class UserController {

    private final UserLoginService userLoginService;

    @Autowired
    public UserController(UserLoginService userLoginService) {
        this.userLoginService = userLoginService;
    }


    @GetMapping
    public ResponseEntity<List<UserLogin>> findAll() {
        return ResponseEntity.ok(userLoginService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserLogin>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(userLoginService.findById(id));
    }

    @PostMapping
    public ResponseEntity<UserLogin> save(@RequestBody UserLogin userLogin){
        return ResponseEntity.ok(userLoginService.save(userLogin));
    }

    @PutMapping
    public ResponseEntity<UserLogin> update(@RequestBody UserLogin userLogin){
        return ResponseEntity.ok(userLoginService.save(userLogin));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userLoginService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
