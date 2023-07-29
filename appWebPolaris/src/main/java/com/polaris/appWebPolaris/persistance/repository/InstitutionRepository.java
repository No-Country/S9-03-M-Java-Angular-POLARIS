package com.polaris.appWebPolaris.persistance.repository;

import com.polaris.appWebPolaris.domain.dto.InstituteDto;
import com.polaris.appWebPolaris.domain.repository.IInstitutionRepository;
import com.polaris.appWebPolaris.persistance.crud.IInstitutionCrudRepository;
import com.polaris.appWebPolaris.persistance.mapper.IInstitutionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class InstitutionRepository implements IInstitutionRepository {

    private final IInstitutionCrudRepository iInstitutionCrudRepository;
    private final IInstitutionMapper iInstitutionMapper;

    @Override
    public List<InstituteDto> getAll() {
        return iInstitutionMapper.toInstitutionsDto(iInstitutionCrudRepository.findAll());
    }

    @Override
    public Optional<InstituteDto> getInstitutionById(Long id) {
        return iInstitutionCrudRepository.findById(id)
                .map(iInstitutionMapper::toInstitutionDto);
    }

    @Override
    public Optional<InstituteDto> getInstitutionByEmail(String email) {
        return iInstitutionCrudRepository.findByEmail(email)
                .map(iInstitutionMapper::toInstitutionDto);
    }

    @Override
    public Optional<InstituteDto> getInstitutionByName(String name) {
        return iInstitutionCrudRepository.findByName(name)
                .map(iInstitutionMapper::toInstitutionDto);
    }

    @Override
    public InstituteDto save(InstituteDto newInstitution) {
        return iInstitutionMapper
                .toInstitutionDto(iInstitutionCrudRepository
                        .save(iInstitutionMapper
                                .toInstitutionEntity(newInstitution)));
    }

    @Override
    public void delete(Long id) {
        iInstitutionCrudRepository.deleteById(id);
    }
}
