package com.polaris.appWebPolaris.persistance.mapper;

import com.polaris.appWebPolaris.domain.dto.VolunteerDto;
import com.polaris.appWebPolaris.persistance.entity.VolunteerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel="spring", uses= {IReviewMapper.class})
public interface IVolunteerMapper {

    VolunteerDto toVolunteerDto(VolunteerEntity volunteerEntity);

    VolunteerEntity toVolunteerEntity(VolunteerDto volunteerDto);

    List<VolunteerDto> toVolunteersDto(List<VolunteerEntity> volunteerEntityList);
}