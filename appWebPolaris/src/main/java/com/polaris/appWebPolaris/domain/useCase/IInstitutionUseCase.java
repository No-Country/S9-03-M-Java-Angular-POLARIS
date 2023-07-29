package com.polaris.appWebPolaris.domain.useCase;


import com.polaris.appWebPolaris.domain.dto.InstituteDto;
import com.polaris.appWebPolaris.domain.dto.ResponseMessageDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IInstitutionUseCase {

    List<InstituteDto> getAll();

    ResponseEntity<?> getInstitutionById(Long id);

    Optional<InstituteDto> getInstitutionByEmail(String email);

    Optional<InstituteDto> getInstitutionByName(String name);

    ResponseMessageDto saveInstitution(InstituteDto newInstitution);

    Optional<InstituteDto> update(InstituteDto modifyInstitution);

    ResponseEntity<?> delete(Long id);
}
