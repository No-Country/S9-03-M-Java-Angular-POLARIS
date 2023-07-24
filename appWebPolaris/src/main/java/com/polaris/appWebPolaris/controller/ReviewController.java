package com.polaris.appWebPolaris.controller;

import com.polaris.appWebPolaris.domain.dto.ResponseMessageDto;
import com.polaris.appWebPolaris.domain.dto.ResponseReviewDto;
import com.polaris.appWebPolaris.domain.dto.ReviewDto;
import com.polaris.appWebPolaris.domain.useCase.IReviewUseCase;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/reviews")
@SecurityRequirement(name = "jwt")
public class ReviewController {

    private final IReviewUseCase iReviewUseCase;


    @GetMapping(path = "/getAll")
    public ResponseEntity<List<ResponseReviewDto>> getAll() {
        return ResponseEntity.ok(iReviewUseCase.getAll());
    }

    @GetMapping(path = "/getById/{id}")
    public ResponseEntity<?> getReviewById(@PathVariable Long id) {
        return iReviewUseCase.getReviewById(id);
    }

    @GetMapping(path = "/getByVolunteerId/{id}")
    public ResponseEntity<List<ResponseReviewDto>> getReviewByVolunteerId(@PathVariable Long id) {
        return ResponseEntity.ok(iReviewUseCase.getReviewByVolunteerId(id).orElse(null));
    }

    @GetMapping(path = "/getByInstitutionId/{id}")
    public ResponseEntity<List<ResponseReviewDto>> getReviewByInstitutionId(@PathVariable Long id) {
        return ResponseEntity.ok(iReviewUseCase.getReviewByInstitutionId(id).orElse(null));
    }

    @PostMapping
    public ResponseEntity<ResponseMessageDto> save(@RequestBody ReviewDto reviewDtoNew) {
        return ResponseEntity.ok(iReviewUseCase.saveReview(reviewDtoNew));
    }
}
