package com.polaris.appWebPolaris.repository;

import com.polaris.appWebPolaris.model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoginRepository extends JpaRepository<UserLogin, Long> {
}
