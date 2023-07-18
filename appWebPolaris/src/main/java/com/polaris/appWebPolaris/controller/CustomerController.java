package com.polaris.appWebPolaris.controller;

import com.polaris.appWebPolaris.domain.dto.CustomerDto;
import com.polaris.appWebPolaris.domain.useCase.ICustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/customers")
public class CustomerController {

    private final ICustomerUseCase iCustomerUseCase;

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<CustomerDto>> getAll() {
        return ResponseEntity.ok(iCustomerUseCase.getAll());
    }

    @GetMapping(path = "/getById/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id) {
        return iCustomerUseCase.getCustomerById(id);
    }

    @GetMapping(path = "/email/{email}")
    public ResponseEntity<CustomerDto> getCustomerByEmail(@PathVariable String email) {
        return ResponseEntity.of(iCustomerUseCase.getCustomerByEmail(email));
    }

}
