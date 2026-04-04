package com.example.advertising_system.Service.AdvertiserService.Events.ClickOnAnnouncemet;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.advertising_system.Entity.AdvertEntities.Announcement;
import com.example.advertising_system.Entity.ClientEntities.Client;
import com.example.advertising_system.Repository.AdvertiserRepoes.AnnouncementRepo;
import com.example.advertising_system.Repository.ClientRepoes.ClientRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClickOnAnnouncementService {
    private final AnnouncementRepo announcementRepo;
    private final ClientRepo clientRepo;


    @Transactional
    public void ClickOnAnnouncement(String client_id, Long id_announcement){
        Optional<Client> clientOptional = clientRepo.findById(client_id);
        if (clientOptional.isEmpty()) {
            throw new RuntimeException("Client not founde");
        }
        Announcement announcement = announcementRepo.findById(id_announcement).orElseThrow();
        announcement.setClicks(announcement.getClicks()+1);;
        log.info("Переход засчитан");
        announcementRepo.save(announcement);
    }
    
}
