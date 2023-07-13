package com.polaris.appWebPolaris.controller;


import com.polaris.appWebPolaris.domain.dto.AuthCustomerDto;
import com.polaris.appWebPolaris.domain.dto.JwtResponseDto;
import com.polaris.appWebPolaris.domain.dto.ResponseVolunteerDto;
import com.polaris.appWebPolaris.domain.dto.VolunteerDto;
import com.polaris.appWebPolaris.domain.repository.IAuthUseCase;
import com.polaris.appWebPolaris.domain.useCase.IVolunteerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/auth")
public class AuthController {

    private final IAuthUseCase iAuthUseCase;
    private final IVolunteerUseCase iVolunteerUseCase;


    @PostMapping(path = "/registerVolunteer")
    public ResponseEntity<ResponseVolunteerDto> saveVolunteer(@RequestBody VolunteerDto volunteerDtoNew) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(iVolunteerUseCase.saveVolunteer(volunteerDtoNew));
    }

    @PostMapping(path = "/sign-in")
    public ResponseEntity<JwtResponseDto> signIn(@RequestBody AuthCustomerDto authCustomerDto) {
        return ResponseEntity.ok(iAuthUseCase.signIn(authCustomerDto));
    }

    @PostMapping(path = "/sign-out")
    public ResponseEntity<JwtResponseDto> signOut(@RequestHeader(name = HttpHeaders.AUTHORIZATION) String jwt) {
        return ResponseEntity.ok(iAuthUseCase.signOut(jwt));
    }
}
