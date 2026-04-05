package com.example.advertising_system.Service.AdvertiserService.Events.ClickOnAnnouncemet;

import com.example.advertising_system.Service.MlScroreService.MLScoreService;
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
    private final MLScoreService mlScoreService;

    @Transactional
    public void ClickOnAnnouncement(String client_id, Long id_announcement){
        Client client = clientRepo.findById(client_id).orElseThrow(
                () -> new RuntimeException("Client not founde")
        );
        Announcement announcement = announcementRepo.findById(id_announcement).orElseThrow(
                ()-> new RuntimeException("Announcement not found")
        );

        if (!announcement.isActive()){
            throw new RuntimeException("Announcement ended on "+announcement.getEndDate());
        }

        if (mlScoreService.DetectClickTheFirst(announcement.getAdvertiser(), client)){
            mlScoreService.theFirstClickOnAnnouncement(announcement.getAdvertiser(),client);
            announcement.setClicks(announcement.getClicks()+1);
            announcementRepo.save(announcement);
            log.info("Click add");
        }else {
            throw new RuntimeException("Clicked yet");
        }

    }
    
}
