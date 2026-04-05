package com.example.advertising_system.Service.AdvertiserService.Events.ClickOnAnnouncemet;


import com.example.advertising_system.Service.MlScroreService.MLScoreService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.advertising_system.Entity.AdvertEntities.Announcement;
import com.example.advertising_system.Entity.ClientEntities.Client;
import com.example.advertising_system.Repository.AdvertiserRepoes.AnnouncementRepo;
import com.example.advertising_system.Repository.ClientRepoes.ClientRepo;
import com.example.advertising_system.Service.AdvertiserService.Events.Targeting.TargetService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClickOnAnnouncementService {
    private final AnnouncementRepo announcementRepo;
    private final ClientRepo clientRepo;
    private final TargetService targetService;
    private final MLScoreService mlScoreService;
    @Transactional
    public void ClickOnAnnouncement(String client_id, Long id_announcement){
        Client client = clientRepo.findById(client_id).orElseThrow(() -> new RuntimeException("Client not found: " + client_id));
        
        Announcement announcement = announcementRepo.findWithTarget(id_announcement).orElseThrow();
        boolean checker = targetService.checkTargetParam(client, announcement.getAntarget());
        if (!checker) {
            throw new RuntimeException("Пользователь не подходит");
        }
        boolean checkOnFirstClick = mlScoreService.DetectClickTheFirst(announcement.getAdvertiser(),client);
        if (!checkOnFirstClick){
            throw new RuntimeException("Click not register becouse Client clicked yet");
        }else {
            announcement.setClicks(announcement.getClicks()+1);
            log.info("Переход засчитан");
            mlScoreService.theFirstClickOnAnnouncement(announcement.getAdvertiser(),client);
            announcementRepo.save(announcement);
        }


    }
    
}
