package com.polaris.appWebPolaris.domain.useCase;

import com.polaris.appWebPolaris.domain.dto.ResponseVolunteerDto;
import com.polaris.appWebPolaris.domain.dto.VolunteerDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IVolunteerUseCase {

    List<VolunteerDto> getAll();

    ResponseEntity<?> getVolunteerById(Long id);

    Optional<VolunteerDto> getVolunteerByEmail(String email);

    ResponseVolunteerDto saveVolunteer(VolunteerDto newVolunteer);

    Optional<VolunteerDto> update(VolunteerDto modifyVolunteer);

    ResponseEntity<?> delete(Long id);

}
