package com.polaris.appWebPolaris.persistance.repository;

import com.polaris.appWebPolaris.domain.dto.InstituteDto;
import com.polaris.appWebPolaris.domain.dto.ReviewDto;
import com.polaris.appWebPolaris.domain.repository.IReviewRepository;
import com.polaris.appWebPolaris.persistance.crud.IReviewCrudRepository;
import com.polaris.appWebPolaris.persistance.mapper.IInstitutionMapper;
import com.polaris.appWebPolaris.persistance.mapper.IReviewMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class ReviewRepository implements IReviewRepository {

    private final IReviewCrudRepository iReviewCrudRepository;
    private final IReviewMapper iReviewMapper;

    @Override
    public List<ReviewDto> getAll() {
        return iReviewMapper.toReviewsDto(iReviewCrudRepository.findAll());
    }

    @Override
    public Optional<ReviewDto> getReviewById(Long id) {
        return iReviewCrudRepository.findById(id)
                .map(iReviewMapper::toReviewDto);
    }

    @Override
    public ReviewDto save(ReviewDto newReview) {
        return iReviewMapper
                .toReviewDto(iReviewCrudRepository
                        .save(iReviewMapper
                                .toReviewEntity(newReview)));
    }
}
