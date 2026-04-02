package com.example.advertising_system.Repository.ClientRepoes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.advertising_system.Entity.ClientEntities.Client;


@Repository
public interface ClientRepo extends JpaRepository<Client, String>{
    
}
