package com.polaris.appWebPolaris.domain.useCase;

import com.polaris.appWebPolaris.domain.dto.ResponseMessageDto;
import com.polaris.appWebPolaris.domain.dto.VolunteerDto;
import com.polaris.appWebPolaris.enums.SkillsEnum;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IVolunteerUseCase {

    List<VolunteerDto> getAll();
    List<VolunteerDto> getAllBySkillList(SkillsEnum skillsEnum);

    ResponseEntity<?> getVolunteerById(Long id);

    Optional<VolunteerDto> getVolunteerByEmail(String email);

    ResponseMessageDto saveVolunteer(VolunteerDto newVolunteer);

    Optional<VolunteerDto> update(VolunteerDto modifyVolunteer);

    ResponseEntity<?> delete(Long id);

}
