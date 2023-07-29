package com.polaris.appWebPolaris.persistance.repository;

import com.polaris.appWebPolaris.domain.dto.CustomerDto;
import com.polaris.appWebPolaris.domain.repository.ICustomerRepository;
import com.polaris.appWebPolaris.persistance.crud.ICustomerCrudRepository;
import com.polaris.appWebPolaris.persistance.mapper.ICustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class CustomerRepository implements ICustomerRepository {

    private final ICustomerCrudRepository iCustomerCrudRepository;
    private final ICustomerMapper iCustomerMapper;

    @Override
    public List<CustomerDto> getAll() {
        return iCustomerMapper.toCustomersDto(iCustomerCrudRepository.findAll()) ;
    }

    @Override
    public Optional<CustomerDto> getCustomerById(Long id) {
        return iCustomerCrudRepository.findById(id)
                .map(iCustomerMapper::toCustomerDto);
    }

    @Override
    public Optional<CustomerDto> getCustomerByEmail(String email) {
        return iCustomerCrudRepository.findByEmail(email)
                .map(iCustomerMapper::toCustomerDto);
    }


    @Override
    public void delete(Long id) {
        iCustomerCrudRepository.deleteById(id);
    }
}
