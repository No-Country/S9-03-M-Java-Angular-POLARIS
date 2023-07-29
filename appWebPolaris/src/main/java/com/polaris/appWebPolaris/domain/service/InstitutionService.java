package com.polaris.appWebPolaris.domain.service;

import com.polaris.appWebPolaris.domain.dto.InstituteDto;
import com.polaris.appWebPolaris.domain.dto.ResponseMessageDto;
import com.polaris.appWebPolaris.domain.repository.IInstitutionRepository;
import com.polaris.appWebPolaris.domain.useCase.IInstitutionUseCase;
import com.polaris.appWebPolaris.exception.CustomerExistsException;
import com.polaris.appWebPolaris.exception.EmailValidationException;
import com.polaris.appWebPolaris.persistance.entity.InstitutionEntity;
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
public class InstitutionService implements IInstitutionUseCase {

    private final IInstitutionRepository iInstitutionRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<InstituteDto> getAll() {
        return iInstitutionRepository.getAll();
    }

    @Override
    public ResponseEntity<?> getInstitutionById(Long id) {
        Optional<InstituteDto> result = iInstitutionRepository.getInstitutionById(id);
        if(result.isEmpty()){
            return ResponseEntity.badRequest().body("No existe una institución con ese id");
        }
        return ResponseEntity.ok(result);
    }

    @Override
    public Optional<InstituteDto> getInstitutionByEmail(String email) {
        return iInstitutionRepository.getInstitutionByEmail(email);
    }

    public Optional<InstituteDto> getInstitutionByName(String name) {
        return iInstitutionRepository.getInstitutionByName(name);
    }

    @Override
    public ResponseMessageDto saveInstitution(InstituteDto newInstitute) {

        if (!newInstitute.getEmail().matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
            throw new EmailValidationException();
        }

        if (getInstitutionByEmail(newInstitute.getEmail()).isPresent()) {
            throw new CustomerExistsException();
        }

        newInstitute.setPassword(passwordEncoder.encode(newInstitute.getPassword()));
        newInstitute.setRol(String.valueOf(Roles.INSTITUTION));
        iInstitutionRepository.save(newInstitute);
        return new ResponseMessageDto("Institución creada con éxito");
    }

    @Override
    public Optional<InstituteDto> update(InstituteDto modifyInstitute) {
        Optional<InstituteDto> institutionBD = iInstitutionRepository.getInstitutionById(modifyInstitute.getId());
        if (institutionBD.isEmpty()){
            return Optional.empty();
        }
        if (modifyInstitute.getName()!= null){
            institutionBD.get().setName(modifyInstitute.getName());
        }
        if (modifyInstitute.getCuit()!= null){
            institutionBD.get().setCuit(modifyInstitute.getCuit());
        }
        if (modifyInstitute.getEmail()!= null){
            institutionBD.get().setEmail(modifyInstitute.getEmail());
        }
        if (modifyInstitute.getPassword()!= null){
            institutionBD.get().setPassword(passwordEncoder.encode(modifyInstitute.getPassword()));
        }
        if (modifyInstitute.getProvince()!= null){
            institutionBD.get().setProvince(modifyInstitute.getProvince());
        }

        if (modifyInstitute.getLocality()!= null){
            institutionBD.get().setLocality(modifyInstitute.getLocality());
        }
        if (modifyInstitute.getType()!= null){
            institutionBD.get().setType(modifyInstitute.getType());
        }
        if (modifyInstitute.getAvailability()!= null){
            institutionBD.get().setAvailability(modifyInstitute.getAvailability());
        }
        if (modifyInstitute.getNumberphone()!= null){
            institutionBD.get().setNumberphone(modifyInstitute.getNumberphone());
        }
        if (modifyInstitute.getImageProfile()!= null){
            institutionBD.get().setImageProfile(modifyInstitute.getImageProfile());
        }
        if (modifyInstitute.getReviewList() != null){
            institutionBD.get().setReviewList(modifyInstitute.getReviewList());
        }

        institutionBD.get().setRol(String.valueOf(Roles.INSTITUTION));
        return Optional.of(iInstitutionRepository.save(institutionBD.get()));
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        Optional<InstituteDto> institutionDB = iInstitutionRepository.getInstitutionById(id);
        HashMap<String, Object> json = new HashMap<>();

        if (institutionDB.isPresent()) {
            iInstitutionRepository.delete(id);
            json.put("mensaje", "Institution successfully eliminated");
            return new ResponseEntity<>(json, HttpStatus.OK);
        }
        json.put("mensaje", "Institution does not exist");
        return new ResponseEntity<>(json, HttpStatus.NOT_FOUND);
    }

}
