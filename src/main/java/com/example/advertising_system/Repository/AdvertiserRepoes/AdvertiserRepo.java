package com.example.advertising_system.Repository.AdvertiserRepoes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.advertising_system.Entity.AdvertEntities.Advertiser;
import java.util.Optional;


@Repository
public interface AdvertiserRepo extends JpaRepository<Advertiser, String> {
    @Query("SELECT a FROM Advertiser a WHERE  a.name = :name")
    Optional<Advertiser> findByName(@Param("name") String name);
    
}
