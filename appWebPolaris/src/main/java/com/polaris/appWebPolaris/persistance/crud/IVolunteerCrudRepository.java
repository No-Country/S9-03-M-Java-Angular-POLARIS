package com.polaris.appWebPolaris.persistance.crud;

import com.polaris.appWebPolaris.domain.dto.VolunteerDto;
import com.polaris.appWebPolaris.enums.SkillsEnum;
import com.polaris.appWebPolaris.persistance.entity.VolunteerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IVolunteerCrudRepository extends JpaRepository<VolunteerEntity, Long> {

    Optional<VolunteerEntity> findByEmail(String email);
    List<VolunteerEntity> findBySkillList(SkillsEnum skillsEnum);
}
