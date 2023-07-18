package com.polaris.appWebPolaris.domain.service;

import com.polaris.appWebPolaris.domain.dto.CustomerDto;
import com.polaris.appWebPolaris.domain.dto.ResponseMessageDto;
import com.polaris.appWebPolaris.domain.repository.ICustomerRepository;
import com.polaris.appWebPolaris.domain.useCase.ICustomerUseCase;
import com.polaris.appWebPolaris.exception.CustomerExistsException;
import com.polaris.appWebPolaris.exception.EmailValidationException;
import com.polaris.appWebPolaris.security.Roles;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomerService implements ICustomerUseCase {

    private final ICustomerRepository iCustomerRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<CustomerDto> getAll() {
        return iCustomerRepository.getAll();
    }

    @Override
    public ResponseEntity<?> getCustomerById(Long id) {
        Optional<CustomerDto> result = iCustomerRepository.getCustomerById(id);
        if(result.isEmpty()){
            return ResponseEntity.badRequest().body("No existe usuario con ese id");
        }
        return ResponseEntity.ok(result);
    }

    @Override
    public Optional<CustomerDto> getCustomerByEmail(String email) {
        return iCustomerRepository.getCustomerByEmail(email);
    }


}
