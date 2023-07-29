package com.polaris.appWebPolaris.persistance.mapper;

import com.polaris.appWebPolaris.domain.dto.CustomerDto;
import com.polaris.appWebPolaris.persistance.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface ICustomerMapper {

    CustomerDto toCustomerDto(CustomerEntity customerEntity);

    CustomerEntity toCustomerEntity(CustomerDto customerDto);

    List<CustomerDto> toCustomersDto(List<CustomerEntity> customerEntityList);

}
