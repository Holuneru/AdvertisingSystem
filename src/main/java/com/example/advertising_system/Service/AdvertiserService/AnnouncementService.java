package com.example.advertising_system.Service.AdvertiserService;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.example.advertising_system.DTO.AnnouncementDto.Create.Request.AnnouncementCreateRequest;
import com.example.advertising_system.DTO.AnnouncementDto.Create.Response.AnnouncementCreateResponse;
import com.example.advertising_system.Entity.AdvertEntities.Advertiser;
import com.example.advertising_system.Entity.AdvertEntities.Announcement;
import com.example.advertising_system.Mappers.AnnouncementMapper.AnnouncementMapper;
import com.example.advertising_system.Repository.AdvertiserRepoes.AdvertiserRepo;
import com.example.advertising_system.Repository.AdvertiserRepoes.AnnouncementRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AnnouncementService {
    private final AnnouncementRepo announcementRepo;
    private final AdvertiserRepo advertiserRepo;
    private final AnnouncementMapper announcementMapper;

    public AnnouncementCreateResponse createAnouncement(AnnouncementCreateRequest announcementCreateRequest){
        Advertiser advertiser = advertiserRepo.findById(announcementCreateRequest.getUUID()).orElseThrow(()-> new RuntimeException("Advertiser undefinde"));

        Announcement announcement = new Announcement();

        announcement.setAdvertiser(advertiser);
        announcement.setImpressions(0);
        announcement.setClicks(0);
        announcement.setCostPerClick(announcementCreateRequest.getCostPerClick());
        announcement.setTitle(announcementCreateRequest.getTitle());
        announcement.setText(announcement.getText());
        announcement.setStartDate(LocalDate.now());
        announcement.setEndDate(LocalDate.now().plusDays(1));
        Announcement saved = announcementRepo.save(announcement);
        log.info("announcement created "+ saved.getId());
        return announcementMapper.toResponse(saved);
    }

}
