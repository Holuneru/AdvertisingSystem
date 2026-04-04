package com.example.advertising_system.Repository.AdvertiserRepoes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.advertising_system.Entity.AdvertEntities.Announcement;

@Repository
public interface AnnouncementRepo extends JpaRepository<Announcement, Long>{
    
    
} 
