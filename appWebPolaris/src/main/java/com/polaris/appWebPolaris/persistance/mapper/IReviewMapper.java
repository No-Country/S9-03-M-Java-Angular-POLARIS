package com.polaris.appWebPolaris.persistance.mapper;

import com.polaris.appWebPolaris.domain.dto.ReviewDto;
import com.polaris.appWebPolaris.persistance.entity.ReviewEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface IReviewMapper {
    ReviewDto toReviewDto(ReviewEntity reviewEntity);

    ReviewEntity toReviewEntity(ReviewDto reviewDto);
    List<ReviewDto> toReviewsDto(List<ReviewEntity> reviewEntityList);
}
