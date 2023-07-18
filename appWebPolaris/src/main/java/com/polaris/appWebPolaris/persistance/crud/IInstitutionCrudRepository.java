package com.polaris.appWebPolaris.persistance.crud;

import com.polaris.appWebPolaris.persistance.entity.InstitutionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IInstitutionCrudRepository extends JpaRepository<InstitutionEntity, Long> {

    Optional<InstitutionEntity> findByEmail(String email);

    Optional<InstitutionEntity> findByName(String name);
}
