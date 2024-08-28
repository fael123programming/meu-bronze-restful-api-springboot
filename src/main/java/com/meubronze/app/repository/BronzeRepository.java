package com.meubronze.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meubronze.app.domain.Bronze;

public interface BronzeRepository extends JpaRepository<Bronze, Long> {
    
}
