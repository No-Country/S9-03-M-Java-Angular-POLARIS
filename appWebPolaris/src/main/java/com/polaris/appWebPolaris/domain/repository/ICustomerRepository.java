package com.polaris.appWebPolaris.domain.repository;

import com.polaris.appWebPolaris.domain.dto.CustomerDto;

import java.util.List;
import java.util.Optional;

public interface ICustomerRepository {

    List<CustomerDto> getAll();

    Optional<CustomerDto> getCustomerById(Long id);

    Optional<CustomerDto> getCustomerByEmail(String email);

    void delete(Long id);

}
