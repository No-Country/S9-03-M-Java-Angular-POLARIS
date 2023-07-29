package com.polaris.appWebPolaris.domain.repository;

import com.polaris.appWebPolaris.domain.dto.ResponseReviewDto;
import com.polaris.appWebPolaris.domain.dto.ReviewDto;

import java.util.List;
import java.util.Optional;

public interface IReviewRepository {

    List<ResponseReviewDto> getAll();

    Optional<ResponseReviewDto> getReviewById(Long id);

    Optional<List<ResponseReviewDto>> getAllByVolunteerId(Long idVolunteer);

    Optional<List<ResponseReviewDto>> getAllByInstitutionId(Long idInstitution);

    ReviewDto save(ReviewDto newReviewDto);


}
