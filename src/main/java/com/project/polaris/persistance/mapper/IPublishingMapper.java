package com.project.polaris.persistance.mapper;

import com.project.polaris.domain.dto.PublishingDto;
import com.project.polaris.persistance.entity.PublishingEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface IPublishingMapper {
    PublishingDto toPublishingDto(PublishingEntity publishingEntity);
    @InheritInverseConfiguration
    @Mapping(target = "institutionEntityFK", ignore = true)
    @Mapping(target = "knowledgePublishingEntities", ignore = true)
    PublishingEntity toPublishingEntity(PublishingDto publishingDto);
    List<PublishingDto> toPublishingDtoList(List<PublishingEntity>publishingEntities);
}
