package com.example.advertising_system.Repository.ClientRepoes;

import org.springframework.stereotype.Service;

import com.example.advertising_system.Entity.AdvertEntities.Announcement;
import com.example.advertising_system.Repository.AdvertiserRepoes.AnnouncementRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClickOnAnnouncementService {
    private final AnnouncementRepo announcementRepo;

    public void ClickOnAnnouncement(Long id_announcement){
        Announcement announcement = announcementRepo.findById(id_announcement).orElseThrow();
        announcement.setImpressions(announcement.getImpressions()+1);
    }
    
}
