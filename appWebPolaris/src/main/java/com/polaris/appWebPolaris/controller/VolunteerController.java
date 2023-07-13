package com.polaris.appWebPolaris.controller;

import com.polaris.appWebPolaris.domain.dto.VolunteerDto;
import com.polaris.appWebPolaris.domain.useCase.IVolunteerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/volunteers")
public class VolunteerController {

    private final IVolunteerUseCase iVolunteerUseCase;


    @GetMapping()
    public ResponseEntity<List<VolunteerDto>> getAll() {
        return ResponseEntity.ok(iVolunteerUseCase.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<VolunteerDto> getVolunteerById(@PathVariable Long id) {
        return ResponseEntity.of(iVolunteerUseCase.getVolunteerById(id));
    }

    @GetMapping(path = "/email/{email}")
    public ResponseEntity<VolunteerDto> getVolunteerByEmail(@PathVariable String email) {
        return ResponseEntity.of(iVolunteerUseCase.getVolunteerByEmail(email));
    }

    @PatchMapping
    public ResponseEntity<VolunteerDto> update(@RequestBody VolunteerDto volunteerDtoUpdate) {
        return ResponseEntity.of(iVolunteerUseCase.update(volunteerDtoUpdate));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return new ResponseEntity<>(this.iVolunteerUseCase.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }


}
