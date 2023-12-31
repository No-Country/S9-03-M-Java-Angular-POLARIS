package com.polaris.appWebPolaris.controller;

import com.polaris.appWebPolaris.domain.dto.VolunteerDto;
import com.polaris.appWebPolaris.domain.useCase.IVolunteerUseCase;
import com.polaris.appWebPolaris.enums.SkillsEnum;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/volunteers")
@SecurityRequirement(name = "jwt")
public class VolunteerController {

    private final IVolunteerUseCase iVolunteerUseCase;


    @GetMapping(path = "/getAll")
    @PreAuthorize("hasRole('VOLUNTEER')")
    public ResponseEntity<List<VolunteerDto>> getAll() {
        return ResponseEntity.ok(iVolunteerUseCase.getAll());
    }

    @GetMapping(path = "/getAllBySkillList/{skillsEnum}")
    @PreAuthorize("hasRole('VOLUNTEER')")
    public ResponseEntity<List<VolunteerDto>>  getAllBySkillList(@PathVariable SkillsEnum skillsEnum){
        return ResponseEntity.ok(iVolunteerUseCase.getAllBySkillList(skillsEnum));
    }
    @GetMapping(path = "/getById/{id}")
    @PreAuthorize("hasRole('VOLUNTEER')")
    public ResponseEntity<?> getVolunteerById(@PathVariable Long id) {
        return iVolunteerUseCase.getVolunteerById(id);
    }

    @GetMapping(path = "/email/{email}")
    @PreAuthorize("hasRole('VOLUNTEER')")
    public ResponseEntity<VolunteerDto> getVolunteerByEmail(@PathVariable String email) {
        return ResponseEntity.of(iVolunteerUseCase.getVolunteerByEmail(email));
    }

    @PatchMapping(path = "/update")
    @PreAuthorize("hasRole('VOLUNTEER')")
    public ResponseEntity<VolunteerDto> update(@RequestBody VolunteerDto volunteerDtoUpdate) {
        return ResponseEntity.of(iVolunteerUseCase.update(volunteerDtoUpdate));
    }

    @DeleteMapping(path = "/deleteId/{id}")
    @PreAuthorize("hasRole('VOLUNTEER')")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return iVolunteerUseCase.delete(id);
    }


}
