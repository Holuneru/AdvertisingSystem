package com.example.advertising_system.Repository.AdvertiserRepoes;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.advertising_system.Entity.AdvertEntities.Announcement;

@Repository
public interface AnnouncementRepo extends JpaRepository<Announcement, Long>{
    @Query("select a from Announcement a left join fetch a.antarget where a.id = :id")
    Optional<Announcement> findWithTarget(@Param("id") Integer id);
} 
