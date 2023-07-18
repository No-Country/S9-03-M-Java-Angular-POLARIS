package com.polaris.appWebPolaris.domain.useCase;

import com.polaris.appWebPolaris.domain.dto.CustomerDto;
import com.polaris.appWebPolaris.domain.dto.ResponseMessageDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ICustomerUseCase {

    List<CustomerDto> getAll();

    ResponseEntity<?> getCustomerById(Long id);

    Optional<CustomerDto> getCustomerByEmail(String email);

}
