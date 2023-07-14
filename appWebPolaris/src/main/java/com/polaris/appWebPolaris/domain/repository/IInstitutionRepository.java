package com.polaris.appWebPolaris.domain.repository;

import com.polaris.appWebPolaris.domain.dto.InstitutionDto;
import com.polaris.appWebPolaris.domain.dto.VolunteerDto;

import java.util.List;
import java.util.Optional;

public interface IInstitutionRepository {

    List<InstitutionDto> getAll();

    Optional<InstitutionDto> getInstitutionById(Long id);

    Optional<InstitutionDto> getInstitutionByEmail(String email);

    Optional<InstitutionDto> getInstitutionByName(String name);

    InstitutionDto save(InstitutionDto newInstitutionDto);

    void delete(Long id);
}
