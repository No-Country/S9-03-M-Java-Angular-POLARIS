package com.polaris.appWebPolaris.persistance.crud;

import com.polaris.appWebPolaris.domain.dto.ReviewDto;
import com.polaris.appWebPolaris.persistance.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IReviewCrudRepository extends JpaRepository<ReviewEntity, Long> {

    Optional<List<ReviewEntity>> findAllByVolunteerId(Long idVolunteer);
    Optional<List<ReviewEntity>> findAllByInstitutionId(Long idInstitution);
}
