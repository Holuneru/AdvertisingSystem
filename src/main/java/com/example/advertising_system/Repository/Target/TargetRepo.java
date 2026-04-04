package com.example.advertising_system.Repository.Target;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.advertising_system.Entity.AdvertEntities.Target.AnTarget;

@Repository
public interface TargetRepo extends JpaRepository<AnTarget, Long>{
    
}
