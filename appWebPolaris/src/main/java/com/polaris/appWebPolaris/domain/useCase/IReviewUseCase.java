package com.polaris.appWebPolaris.domain.useCase;

import com.polaris.appWebPolaris.domain.dto.ResponseReviewDto;
import com.polaris.appWebPolaris.domain.dto.ResponseMessageDto;
import com.polaris.appWebPolaris.domain.dto.ReviewDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IReviewUseCase {

    List<ResponseReviewDto> getAll();

    ResponseEntity<?> getReviewById(Long id);

    Optional<List<ResponseReviewDto>> getReviewByVolunteerId(Long id);

    Optional<List<ResponseReviewDto>> getReviewByInstitutionId(Long id);

    ResponseMessageDto saveReview(ReviewDto newReview);

}
