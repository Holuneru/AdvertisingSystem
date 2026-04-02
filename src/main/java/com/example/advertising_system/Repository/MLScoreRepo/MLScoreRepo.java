package com.example.advertising_system.Repository.MLScoreRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.advertising_system.Entity.MLScoreEntities.MLScore;

@Repository
public interface MLScoreRepo extends JpaRepository<MLScore, Long> {
    
}
