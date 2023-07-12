package com.project.polaris.persistance.crud;

import com.project.polaris.persistance.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserCrudRepository extends JpaRepository<UserEntity, Long> {
}
