package com.meubronze.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meubronze.app.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
    
}
