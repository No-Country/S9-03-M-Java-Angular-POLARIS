package com.polaris.appWebPolaris.domain.service;

import com.polaris.appWebPolaris.domain.dto.ResponseMessageDto;
import com.polaris.appWebPolaris.domain.dto.VolunteerDto;
import com.polaris.appWebPolaris.domain.repository.IVolunteerRepository;
import com.polaris.appWebPolaris.domain.useCase.IVolunteerUseCase;
import com.polaris.appWebPolaris.enums.SkillsEnum;
import com.polaris.appWebPolaris.exception.CustomerExistsException;
import com.polaris.appWebPolaris.exception.EmailValidationException;
import com.polaris.appWebPolaris.security.Roles;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
    public ResponseEntity<?> getVolunteerById(Long id) {
        Optional<VolunteerDto> result = iVolunteerRepository.getVolunteerById(id);
        if(result.isEmpty()){
            return ResponseEntity.badRequest().body("No existe un voluntario con ese id");
        }
        return ResponseEntity.ok(result);
    }

    @Override
    public Optional<VolunteerDto> getVolunteerByEmail(String email) {
        return iVolunteerRepository.getVolunteerByEmail(email);
    }

    @Override
    public List<VolunteerDto> getAllBySkillList(SkillsEnum skillsEnum){
        return iVolunteerRepository.getAllBySkillList(skillsEnum);
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

        newVolunteer.setPassword(passwordEncoder.encode(newVolunteer.getPassword()));
        newVolunteer.setRol(String.valueOf(Roles.VOLUNTEER));
        iVolunteerRepository.save(newVolunteer);

        return new ResponseMessageDto("Voluntario registrado Correctamente");

    }

    @Override
    public Optional<VolunteerDto> update(VolunteerDto modifyVolunteer) {

        Optional<VolunteerDto> volunteerBD = iVolunteerRepository.getVolunteerById(modifyVolunteer.getId());

        if (volunteerBD.isEmpty()){
            return Optional.empty();
        }
        if (modifyVolunteer.getFirstName()!= null){
            volunteerBD.get().setFirstName(modifyVolunteer.getFirstName());
        }
        if (modifyVolunteer.getLastName()!= null){
            volunteerBD.get().setLastName(modifyVolunteer.getLastName());
        }
        if (modifyVolunteer.getEmail()!= null){
            volunteerBD.get().setEmail(modifyVolunteer.getEmail());
        }
        if (modifyVolunteer.getPassword()!= null){
            volunteerBD.get().setPassword(passwordEncoder.encode(modifyVolunteer.getPassword()));
        }
        if (modifyVolunteer.getDni()!= null){
            volunteerBD.get().setDni(modifyVolunteer.getDni());
        }
        if (modifyVolunteer.getDateOfBirth()!= null){
            volunteerBD.get().setDateOfBirth(modifyVolunteer.getDateOfBirth());
        }
        if (modifyVolunteer.getGender()!= null){
            volunteerBD.get().setGender(modifyVolunteer.getGender());
        }
        if (modifyVolunteer.getProvince()!= null){
            volunteerBD.get().setProvince(modifyVolunteer.getProvince());
        }
        if (modifyVolunteer.getLocality()!= null){
            volunteerBD.get().setLocality(modifyVolunteer.getLocality());
        }
        if (modifyVolunteer.getEducation()!= null){
            volunteerBD.get().setEducation(modifyVolunteer.getEducation());
        }
        if (modifyVolunteer.getAvailability()!= null){
            volunteerBD.get().setAvailability(modifyVolunteer.getAvailability());
        }
        if (modifyVolunteer.getNumberCellphone()!= null){
            volunteerBD.get().setNumberCellphone(modifyVolunteer.getNumberCellphone());
        }
        if (modifyVolunteer.getDescription()!= null){
            volunteerBD.get().setDescription(modifyVolunteer.getDescription());
        }
        if (modifyVolunteer.getImageProfile()!= null){
            volunteerBD.get().setImageProfile(modifyVolunteer.getImageProfile());
        }
        if (modifyVolunteer.getOtherSkills() != null){
            volunteerBD.get().setOtherSkills(modifyVolunteer.getOtherSkills());
        }
        if (modifyVolunteer.getSkillList() != null){
            volunteerBD.get().setSkillList(modifyVolunteer.getSkillList());
        }
        if (modifyVolunteer.getReviewList() != null){
            volunteerBD.get().setReviewList(modifyVolunteer.getReviewList());
        }

        volunteerBD.get().setRol(String.valueOf(Roles.VOLUNTEER));
        return Optional.of(iVolunteerRepository.save(volunteerBD.get()));
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        Optional<VolunteerDto> companyDB = iVolunteerRepository.getVolunteerById(id);
        HashMap<String, Object> json = new HashMap<>();

        if (companyDB.isPresent()) {
            iVolunteerRepository.delete(id);
            json.put("mensaje", "Volunteer successfully eliminated");
            return new ResponseEntity<>(json, HttpStatus.OK);
        }
        json.put("mensaje", "Volunteer does not exist");
        return new ResponseEntity<>(json, HttpStatus.NOT_FOUND);
    }
}
