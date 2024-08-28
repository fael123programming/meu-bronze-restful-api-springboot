package com.meubronze.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meubronze.app.domain.Config;

public interface ConfigRepository extends JpaRepository<Config, Long> {
    Config findTopByOrderByIdDesc();
}
