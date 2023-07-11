package com.project.polaris.persistance.crud;

import com.project.polaris.persistance.entity.PublishingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPublishingCrudRespository extends JpaRepository<PublishingEntity, Long> {
}
