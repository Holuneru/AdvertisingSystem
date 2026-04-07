package com.example.advertising_system.Service.AdvertiserService;

import com.example.advertising_system.Entity.AdvertEntities.ClickedClient;
import com.example.advertising_system.Repository.AdvertiserRepoes.ClickedClientRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClickedClientService {
    private final ClickedClientRepo clickedClientRepo;
    
    public void createClickedClientEntity(String client_id, Long announcement_id){
        ClickedClient clickedClient = new ClickedClient();
        clickedClient.setClient_id(client_id);
        clickedClient.setAnnouncement_id(announcement_id);
        ClickedClient saved = clickedClientRepo.save(clickedClient);
        log.info("ClickedClient Created id: {}", saved.getId());
    }
}
