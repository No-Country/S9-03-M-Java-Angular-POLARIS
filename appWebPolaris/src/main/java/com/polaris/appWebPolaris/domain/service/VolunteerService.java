package com.polaris.appWebPolaris.domain.service;

import com.polaris.appWebPolaris.domain.dto.ResponseMessageDto;
import com.polaris.appWebPolaris.domain.dto.VolunteerDto;
import com.polaris.appWebPolaris.domain.repository.IVolunteerRepository;
import com.polaris.appWebPolaris.domain.useCase.IVolunteerUseCase;
import com.polaris.appWebPolaris.exception.CustomerExistsException;
import com.polaris.appWebPolaris.exception.EmailValidationException;
import com.polaris.appWebPolaris.security.Roles;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class VolunteerService implements IVolunteerUseCase {

    private final IVolunteerRepository iVolunteerRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public List<VolunteerDto> getAll() {
        return iVolunteerRepository.getAll();
    }

    @Override
    public Optional<VolunteerDto> getVolunteerById(Long id) {
        return iVolunteerRepository.getVolunteerById(id);
    }

    @Override
    public Optional<VolunteerDto> getVolunteerByEmail(String email) {
        return iVolunteerRepository.getVolunteerByEmail(email);
    }

    @Override
    public ResponseMessageDto saveVolunteer(VolunteerDto newVolunteer) {

        if (!newVolunteer.getEmail().matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
            throw new EmailValidationException();
        }

        if (getVolunteerByEmail(newVolunteer.getEmail()).isPresent()) {
            throw new CustomerExistsException();
        }

//        String passwordGenerated = generateRandomPassword(10);
        newVolunteer.setPassword(passwordEncoder.encode(newVolunteer.getPassword()));
//        newCustomer.setRol(newCustomer.getRol());
        newVolunteer.setRol(Roles.VOLUNTEER);
        iVolunteerRepository.save(newVolunteer);

        return new ResponseMessageDto("Voluntario registrado Correctamente");

    }

    @Override
    public Optional<VolunteerDto> update(VolunteerDto modifyVolunteer) {
        if (iVolunteerRepository.getVolunteerById(modifyVolunteer.getId()).isEmpty()){
            return Optional.empty();
        }
        modifyVolunteer.setPassword(passwordEncoder.encode(modifyVolunteer.getPassword()));
        modifyVolunteer.setRol(Roles.VOLUNTEER);
        return Optional.of(iVolunteerRepository.save(modifyVolunteer));
    }

    @Override
    public boolean delete(Long id) {
        if (iVolunteerRepository.getVolunteerById(id).isEmpty()){
            return false;
        }
        iVolunteerRepository.delete(id);
        return true;
    }
}
