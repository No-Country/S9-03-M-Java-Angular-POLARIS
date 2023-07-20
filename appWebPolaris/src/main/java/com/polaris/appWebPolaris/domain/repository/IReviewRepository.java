package com.polaris.appWebPolaris.domain.repository;

import com.polaris.appWebPolaris.domain.dto.ReviewDto;

import java.util.List;

public interface IReviewRepository {

    List<ReviewDto> getAll();


}
