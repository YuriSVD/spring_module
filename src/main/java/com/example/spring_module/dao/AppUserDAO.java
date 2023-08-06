package com.example.spring_module.dao;

import com.example.spring_module.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserDAO extends JpaRepository<AppUser, Integer> {
    AppUser findAppUserByEmail(String email);
}
