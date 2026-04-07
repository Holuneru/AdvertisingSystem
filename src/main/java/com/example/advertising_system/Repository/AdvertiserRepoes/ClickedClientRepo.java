package com.example.advertising_system.Repository.AdvertiserRepoes;

import com.example.advertising_system.Entity.AdvertEntities.ClickedClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClickedClientRepo extends JpaRepository<ClickedClient, Long> {
    @Query("SELECT cc FROM ClickedClient cc WHERE cc.client_id = :client_id AND cc.announcement_id = :announcement_id")
    Optional<ClickedClient> findByClientIdWithAnnouncement(@Param("client_id") String client_id,@Param("announcement_id") Long announcement_id);
}
