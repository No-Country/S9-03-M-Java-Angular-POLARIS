package com.polaris.appWebPolaris.domain.repository;

import com.polaris.appWebPolaris.domain.dto.VolunteerDto;
import com.polaris.appWebPolaris.enums.SkillsEnum;

import java.util.List;
import java.util.Optional;

public interface IVolunteerRepository {

    List<VolunteerDto> getAll();
    List<VolunteerDto> getAllBySkillList(SkillsEnum skillsEnum);

    Optional<VolunteerDto> getVolunteerById(Long id);

    Optional<VolunteerDto> getVolunteerByEmail(String email);

    VolunteerDto save(VolunteerDto newVolunteer);

    void delete(Long id);
}
