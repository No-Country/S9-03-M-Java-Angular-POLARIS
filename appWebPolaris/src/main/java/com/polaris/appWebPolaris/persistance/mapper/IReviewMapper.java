package com.polaris.appWebPolaris.persistance.mapper;

import com.polaris.appWebPolaris.domain.dto.ResponseReviewDto;
import com.polaris.appWebPolaris.domain.dto.ReviewDto;
import com.polaris.appWebPolaris.persistance.entity.ReviewEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IReviewMapper {

    @Mappings({
            @Mapping(source = "volunteer.id", target = "idVolunteer"),
            @Mapping(source = "institution.id", target = "idInstitution")
    })
    ReviewDto toReviewDto(ReviewEntity reviewEntity);

    @Mappings({
            @Mapping(target = "name", source = "institution.name"),
            @Mapping(target = "image", source = "institution.imageProfile"),
            @Mapping(target = "locality", source = "institution.locality"),
    })
    ResponseReviewDto toResponseReviewDto(ReviewEntity reviewEntity);

    @InheritInverseConfiguration
    ReviewEntity toReviewEntity(ReviewDto reviewDto);
    List<ReviewDto> toReviewsDto(List<ReviewEntity> reviewEntityList);

    @Mappings({
            @Mapping(target = "name", source = "institution.name"),
            @Mapping(target = "image", source = "institution.imageProfile"),
            @Mapping(target = "locality", source = "institution.locality"),
    })
    List<ResponseReviewDto> toResponseReviewsDto(List<ReviewEntity> reviewEntityList);
}
