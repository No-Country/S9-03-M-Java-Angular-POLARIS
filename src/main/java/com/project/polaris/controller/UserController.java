package com.project.polaris.controller;

import com.project.polaris.domain.Iservice.IUserService;
import com.project.polaris.domain.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final IUserService iUserService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll(){
        return ResponseEntity.ok(iUserService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Long idUser){
        return ResponseEntity.of(iUserService.getUser(idUser));
    }

    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody UserDto newUserDto){
        return ResponseEntity.ok(iUserService.save(newUserDto));
    }

    @PatchMapping
    public ResponseEntity<UserDto> update(@RequestBody UserDto editUserDto){
        return ResponseEntity.ok(iUserService.save(editUserDto));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long idUser){
        return ResponseEntity.ok(iUserService.delete(idUser));
    }
}
