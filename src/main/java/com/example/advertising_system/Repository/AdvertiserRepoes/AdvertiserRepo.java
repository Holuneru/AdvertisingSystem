package com.example.advertising_system.Repository.AdvertiserRepoes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.advertising_system.Entity.AdvertEntities.Advertiser;
import java.util.Optional;


@Repository
public interface AdvertiserRepo extends JpaRepository<Advertiser, String> {
    Optional<Advertiser> findByName(String name);
    
}
