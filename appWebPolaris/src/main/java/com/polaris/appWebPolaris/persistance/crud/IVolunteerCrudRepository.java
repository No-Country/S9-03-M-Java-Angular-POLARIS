package com.polaris.appWebPolaris.persistance.crud;

import com.polaris.appWebPolaris.persistance.entity.VolunteerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IVolunteerCrudRepository extends JpaRepository<VolunteerEntity, Long> {

    Optional<VolunteerEntity> findByEmail(String email);
}
