package com.polaris.appWebPolaris.persistance.mapper;

import com.polaris.appWebPolaris.domain.dto.InstitutionDto;
import com.polaris.appWebPolaris.persistance.entity.InstitutionEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface IInstitutionMapper {

    InstitutionDto toInstitutionDto(InstitutionEntity institutionEntity);

    InstitutionEntity toInstitutionEntity(InstitutionDto institutionDto);

    List<InstitutionDto> toInstitutionDto(List<InstitutionEntity> institutionEntities);
}
