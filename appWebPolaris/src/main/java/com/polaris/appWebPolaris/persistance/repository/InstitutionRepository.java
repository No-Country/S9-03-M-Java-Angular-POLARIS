package com.polaris.appWebPolaris.persistance.repository;

import com.polaris.appWebPolaris.domain.dto.InstitutionDto;
import com.polaris.appWebPolaris.domain.repository.IInstitutionRepository;
import com.polaris.appWebPolaris.persistance.crud.IInstitutionCrudRepository;
import com.polaris.appWebPolaris.persistance.entity.InstitutionEntity;
import com.polaris.appWebPolaris.persistance.mapper.IInstitutionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class InstitutionRepository implements IInstitutionRepository {

    private final IInstitutionCrudRepository institutionCrudRepository;

    private final IInstitutionMapper institutionMapper;

    @Override
    public List<InstitutionDto> getAll() {
        return institutionMapper.toInstitutionDto(institutionCrudRepository.findAll());
    }

    @Override
    public Optional<InstitutionDto> getInstitutionById(Long id) {
        return institutionCrudRepository.findById(id).map(institutionMapper::toInstitutionDto);
    }

    @Override
    public Optional<InstitutionDto> getInstitutionByEmail(String email) {
        return institutionCrudRepository.findByEmail(email).map(institutionMapper::toInstitutionDto);
    }

    @Override
    public Optional<InstitutionDto> getInstitutionByName(String name) {
        return institutionCrudRepository.findByName(name).map(institutionMapper::toInstitutionDto);
    }

    @Override
    public InstitutionDto save(InstitutionDto newInstitutionDto) {
        InstitutionEntity institutionEntity = institutionMapper.toInstitutionEntity(newInstitutionDto);
        return institutionMapper.toInstitutionDto(institutionCrudRepository.save(institutionEntity));
    }

    @Override
    public void delete(Long id) {
        institutionCrudRepository.deleteById(id);
    }
}
