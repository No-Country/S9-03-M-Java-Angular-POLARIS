package com.polaris.appWebPolaris.domain.repository;

import com.polaris.appWebPolaris.domain.dto.ReviewDto;

import java.util.List;
import java.util.Optional;

public interface IReviewRepository {

    List<ReviewDto> getAll();

    Optional<ReviewDto> getReviewById(Long id);

    ReviewDto save(ReviewDto newReviewDto);


}
