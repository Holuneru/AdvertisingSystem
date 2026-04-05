package com.example.advertising_system.Repository.ClientRepoes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.advertising_system.Entity.ClientEntities.Client;

import java.util.Optional;


@Repository
public interface ClientRepo extends JpaRepository<Client, String>{
    @Query("select c from Client c left join fetch c.mlScore where c.id = :id")
    Optional<Client> findWithMLScores(@Param("id") String id);
}
