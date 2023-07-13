package com.polaris.appWebPolaris.persistance.repository;

import com.polaris.appWebPolaris.domain.dto.VolunteerDto;
import com.polaris.appWebPolaris.domain.repository.IVolunteerRepository;
import com.polaris.appWebPolaris.persistance.crud.IVolunteerCrudRepository;
import com.polaris.appWebPolaris.persistance.mapper.IVolunteerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class VolunteerRepository implements IVolunteerRepository {

    private final IVolunteerCrudRepository iVolunteerCrudRepository;
    private final IVolunteerMapper iVolunteerMapper;
    @Override
    public List<VolunteerDto> getAll() {
        return iVolunteerMapper.toVolunteersDto(iVolunteerCrudRepository.findAll());
    }

    @Override
    public Optional<VolunteerDto> getVolunteerById(Long id) {
        return iVolunteerCrudRepository.findById(id)
                .map(iVolunteerMapper::toVolunteerDto);
    }

    @Override
    public Optional<VolunteerDto> getVolunteerByEmail(String email) {
        return iVolunteerCrudRepository.findByEmail(email)
                .map(iVolunteerMapper::toVolunteerDto);
    }

    @Override
    public VolunteerDto save(VolunteerDto newVolunteer) {
        return iVolunteerMapper
                .toVolunteerDto(iVolunteerCrudRepository
                        .save(iVolunteerMapper
                                .toVolunteerEntity(newVolunteer)));
    }

    @Override
    public void delete(Long id) {
        iVolunteerCrudRepository.deleteById(id);
    }
}
