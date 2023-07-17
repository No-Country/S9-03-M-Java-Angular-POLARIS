package com.polaris.appWebPolaris.controller;


import com.polaris.appWebPolaris.domain.dto.*;
import com.polaris.appWebPolaris.domain.repository.IAuthUseCase;
import com.polaris.appWebPolaris.domain.useCase.IInstitutionUseCase;
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
    private final IInstitutionUseCase iInstitutionUseCase;


    @PostMapping(path = "/registerVolunteer")
    public ResponseEntity<ResponseMessageDto> saveVolunteer(@RequestBody VolunteerDto volunteerDtoNew) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(iVolunteerUseCase.saveVolunteer(volunteerDtoNew));
    }

    @PostMapping(path = "/registerInstitution")
    public ResponseEntity<ResponseMessageDto> saveInstitute(@RequestBody InstitutionDto institutionDtoDtoNew) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(iInstitutionUseCase.saveInstitution(institutionDtoDtoNew));
    }

    @PostMapping(path = "/sign-in-volunteer")
    public ResponseEntity<JwtResponseDto> signInVolunteer(@RequestBody AuthCustomerDto authCustomerDto) {
        return ResponseEntity.ok(iAuthUseCase.signIn(authCustomerDto));
    }

    @PostMapping(path = "/sign-in-institute")
    public ResponseEntity<JwtResponseDto> signInInstitute(@RequestBody AuthCustomerDto authCustomerDto) {
        return ResponseEntity.ok(iAuthUseCase.signInInstitution(authCustomerDto));
    }

/*    @PostMapping(path = "/sign-out")
    public ResponseEntity<JwtResponseDto> signOut(@RequestHeader(name = HttpHeaders.AUTHORIZATION) String jwt) {
        return ResponseEntity.ok(iAuthUseCase.signOut(jwt));
    }*/
}
