package com.polaris.appWebPolaris.persistance.mapper;

import com.polaris.appWebPolaris.domain.dto.InstituteDto;
import com.polaris.appWebPolaris.persistance.entity.InstitutionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel="spring", uses= {IReviewMapper.class})
@Component
public interface IInstitutionMapper {

    InstituteDto toInstitutionDto(InstitutionEntity institutionEntity);

    InstitutionEntity toInstitutionEntity(InstituteDto institutionDto);

    List<InstituteDto> toInstitutionsDto(List<InstitutionEntity> institutionEntityList);
}
