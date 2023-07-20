package com.polaris.appWebPolaris.persistance.crud;

import com.polaris.appWebPolaris.persistance.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReviewCrudRepository extends JpaRepository<ReviewEntity, Long> {

}
