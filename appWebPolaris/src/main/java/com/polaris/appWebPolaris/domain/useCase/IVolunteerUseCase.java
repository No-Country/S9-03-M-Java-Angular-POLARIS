package com.polaris.appWebPolaris.domain.useCase;

import com.polaris.appWebPolaris.domain.dto.ResponseMessageDto;
import com.polaris.appWebPolaris.domain.dto.VolunteerDto;

import java.util.List;
import java.util.Optional;

public interface IVolunteerUseCase {

    List<VolunteerDto> getAll();

    Optional<VolunteerDto> getVolunteerById(Long id);

    Optional<VolunteerDto> getVolunteerByEmail(String email);

    ResponseMessageDto saveVolunteer(VolunteerDto newVolunteer);

    Optional<VolunteerDto> update(VolunteerDto modifyVolunteer);

    boolean delete(Long id);

}
