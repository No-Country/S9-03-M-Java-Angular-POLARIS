package com.polaris.appWebPolaris.persistance.repository;

import com.polaris.appWebPolaris.domain.dto.InstituteDto;
import com.polaris.appWebPolaris.domain.dto.ResponseReviewDto;
import com.polaris.appWebPolaris.domain.dto.ReviewDto;
import com.polaris.appWebPolaris.domain.repository.IReviewRepository;
import com.polaris.appWebPolaris.persistance.crud.IReviewCrudRepository;
import com.polaris.appWebPolaris.persistance.entity.ReviewEntity;
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
    public List<ResponseReviewDto> getAll() {
        return iReviewMapper.toResponseReviewsDto(iReviewCrudRepository.findAll());
    }

    @Override
    public Optional<ResponseReviewDto> getReviewById(Long id) {
        return iReviewCrudRepository.findById(id)
                .map(iReviewMapper::toResponseReviewDto);
    }

    @Override
    public ReviewDto save(ReviewDto newReview) {
        return iReviewMapper
                .toReviewDto(iReviewCrudRepository
                        .save(iReviewMapper
                                .toReviewEntity(newReview)));
    }

    @Override
    public Optional<List<ResponseReviewDto>> getAllByVolunteerId(Long idVolunteer) {
        return iReviewCrudRepository.findAllByVolunteerId(idVolunteer)
                .map(iReviewMapper::toResponseReviewsDto);

    }

    @Override
    public Optional<List<ResponseReviewDto>> getAllByInstitutionId(Long idInstitution) {
        return iReviewCrudRepository.findAllByInstitutionId(idInstitution)
                .map(iReviewMapper::toResponseReviewsDto);
    }
}
