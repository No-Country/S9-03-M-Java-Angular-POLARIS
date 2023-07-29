package com.polaris.appWebPolaris.domain.service;

import com.polaris.appWebPolaris.domain.dto.ResponseReviewDto;
import com.polaris.appWebPolaris.domain.dto.ResponseMessageDto;
import com.polaris.appWebPolaris.domain.dto.ReviewDto;
import com.polaris.appWebPolaris.domain.repository.IReviewRepository;
import com.polaris.appWebPolaris.domain.useCase.IReviewUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class IReviewService implements IReviewUseCase {

    private final IReviewRepository iReviewRepository;

    @Override
    public List<ResponseReviewDto> getAll() {
        return iReviewRepository.getAll();
    }

    @Override
    public ResponseEntity<?> getReviewById(Long id) {
        Optional<ResponseReviewDto> result = iReviewRepository.getReviewById(id);
        if(result.isEmpty()){
            return ResponseEntity.badRequest().body("No existe una reseña con ese id");
        }
        return ResponseEntity.ok(result);
    }

    @Override
    public Optional<List<ResponseReviewDto>> getReviewByVolunteerId(Long id) {
        return iReviewRepository.getAllByVolunteerId(id);
    }

    @Override
    public Optional<List<ResponseReviewDto>> getReviewByInstitutionId(Long id) {
        return iReviewRepository.getAllByInstitutionId(id);
    }

    @Override
    public ResponseMessageDto saveReview(ReviewDto newReview) {
        iReviewRepository.save(newReview);
        return new ResponseMessageDto("Reseña guardada con éxito");
    }

}
