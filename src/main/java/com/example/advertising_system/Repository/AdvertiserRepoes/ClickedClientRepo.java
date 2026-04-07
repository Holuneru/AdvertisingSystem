package com.example.advertising_system.Repository.AdvertiserRepoes;
@Repository
public interface ClickedClientRepo extends JpaRepository<ClickedClient, Long> {
    @Query("SELECT cc FROM ClickedClient cc JOIN FETCH cc.announcement WHERE cc.client.id = :clientId AND cc.announcement.advertiser.id = :advertiserId")
    Optional<ClickedClient> findByClientIdWithAnnouncement(Long clientId, Long advertiserId);
}
