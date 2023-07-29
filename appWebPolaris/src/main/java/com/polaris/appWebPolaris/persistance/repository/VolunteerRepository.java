package com.polaris.appWebPolaris.persistance.repository;

import com.polaris.appWebPolaris.domain.dto.VolunteerDto;
import com.polaris.appWebPolaris.domain.repository.IVolunteerRepository;
import com.polaris.appWebPolaris.enums.SkillsEnum;
import com.polaris.appWebPolaris.persistance.crud.IVolunteerCrudRepository;
import com.polaris.appWebPolaris.persistance.mapper.IVolunteerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<VolunteerDto> getAllBySkillList(SkillsEnum skillsEnum) {
        List<VolunteerDto> volunteerDtoList = getAll();
        List<VolunteerDto> volunteerDtoListFilter = volunteerDtoList.stream()
                .filter(volunteer -> volunteer.getSkillList().contains(skillsEnum))
                .collect(Collectors.toList());
        return volunteerDtoListFilter;
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
