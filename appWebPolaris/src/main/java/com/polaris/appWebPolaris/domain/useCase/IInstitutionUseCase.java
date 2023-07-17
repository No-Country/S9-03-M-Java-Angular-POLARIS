package com.polaris.appWebPolaris.domain.useCase;


import com.polaris.appWebPolaris.domain.dto.InstitutionDto;
import com.polaris.appWebPolaris.domain.dto.ResponseMessageDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IInstitutionUseCase {

    List<InstitutionDto> getAll();

    ResponseEntity<?> getInstitutionById(Long id);

    Optional<InstitutionDto> getInstitutionByEmail(String email);

    Optional<InstitutionDto> getInstitutionByName(String name);

    ResponseMessageDto saveInstitution(InstitutionDto newInstitution);

    Optional<InstitutionDto> update(InstitutionDto modifyInstitution);

    ResponseEntity<?> delete(Long id);
}
