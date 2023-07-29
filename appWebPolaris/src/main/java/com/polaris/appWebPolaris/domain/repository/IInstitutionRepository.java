package com.polaris.appWebPolaris.domain.repository;

import com.polaris.appWebPolaris.domain.dto.InstituteDto;

import java.util.List;
import java.util.Optional;

public interface IInstitutionRepository {

    List<InstituteDto> getAll();

    Optional<InstituteDto> getInstitutionById(Long id);

    Optional<InstituteDto> getInstitutionByEmail(String email);

    Optional<InstituteDto> getInstitutionByName(String name);

    InstituteDto save(InstituteDto newInstitutionDto);

    void delete(Long id);
}
