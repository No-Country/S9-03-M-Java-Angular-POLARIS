package com.polaris.appWebPolaris.controller;

import com.polaris.appWebPolaris.domain.dto.InstituteDto;
import com.polaris.appWebPolaris.domain.useCase.IInstitutionUseCase;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/institutions")
@SecurityRequirement(name = "jwt")
public class InstitutionController {

    private final IInstitutionUseCase iInstitutionUseCase;


    @GetMapping(path = "/getAll")
    @PreAuthorize("hasRole('INSTITUTION')")
    public ResponseEntity<List<InstituteDto>> getAll() {
        return ResponseEntity.ok(iInstitutionUseCase.getAll());
    }

    @GetMapping(path = "/getById/{id}")
    @PreAuthorize("hasRole('INSTITUTION')")
    public ResponseEntity<?> getInstitutionById(@PathVariable Long id) {
        return iInstitutionUseCase.getInstitutionById(id);
    }

    @GetMapping(path = "/email/{email}")
    @PreAuthorize("hasRole('INSTITUTION')")
    public ResponseEntity<InstituteDto> getInstitutionByEmail(@PathVariable String email) {
        return ResponseEntity.of(iInstitutionUseCase.getInstitutionByEmail(email));
    }

    @GetMapping(path = "/name/{name}")
    @PreAuthorize("hasRole('INSTITUTION')")
    public ResponseEntity<InstituteDto> getInstitutionByName(@PathVariable String name) {
        return ResponseEntity.of(iInstitutionUseCase.getInstitutionByName(name));
    }

    @PatchMapping(path = "/update")
    @PreAuthorize("hasRole('INSTITUTION')")
    public ResponseEntity<InstituteDto> update(@RequestBody InstituteDto institutionDtoUpdate) {
        return ResponseEntity.of(iInstitutionUseCase.update(institutionDtoUpdate));
    }

    @DeleteMapping(path = "/deleteId/{id}")
    @PreAuthorize("hasRole('INSTITUTION')")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return iInstitutionUseCase.delete(id);
    }
}
