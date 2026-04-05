package com.example.advertising_system.Service.AdvertiserService;

import java.time.LocalDate;
import java.util.Objects;

import com.example.advertising_system.DTO.AnnouncementDto.GetInfo.Response.AnnouncementResponseInfo;
import com.example.advertising_system.DTO.AnnouncementDto.UpdateDto.AnnouncementUpdateDto;
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
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AnnouncementService {
    private final AnnouncementRepo announcementRepo;
    private final AdvertiserRepo advertiserRepo;
    private final AnnouncementMapper announcementMapper;

    public AnnouncementCreateResponse createAnouncement(AnnouncementCreateRequest announcementCreateRequest){
        Advertiser advertiser = advertiserRepo.findByName(announcementCreateRequest.getName()).orElseThrow(()-> new RuntimeException("Advertiser undefinde"));

        Announcement announcement = new Announcement();

        announcement.setAdvertiser(advertiser);
        announcement.setImpressions(0);
        announcement.setClicks(0);
        announcement.setCostPerClick(announcementCreateRequest.getCostPerClick());
        announcement.setTitle(announcementCreateRequest.getTitle());
        announcement.setText(announcementCreateRequest.getText());
        announcement.setStartDate(LocalDate.now());
        announcement.setEndDate(LocalDate.now().plusDays(1));
        Announcement saved = announcementRepo.save(announcement);
        log.info("announcement created {}", saved.getId());
        return announcementMapper.toResponse(saved);
    }

    public AnnouncementResponseInfo getByIdOne(Long id) {
        Announcement announcementOptional = announcementRepo.findById(id).orElseThrow(
                () -> new RuntimeException("NOT FOUND Announcement")
        );
        return announcementMapper.toInfo(announcementOptional);
    }

    @Transactional
    public AnnouncementResponseInfo updateAnnouncementINFO(Long id, AnnouncementUpdateDto announcementUpdateDto) {
        Announcement announcement = announcementRepo.findById(id).orElseThrow(
                () -> new RuntimeException("Announcement not found")
        );
        if (announcementUpdateDto.getTitle()!=null&&!announcementUpdateDto.getTitle().isBlank() && !Objects.equals(announcementUpdateDto.getTitle(),announcement.getTitle())){
            announcement.setTitle(announcementUpdateDto.getTitle());
            log.info("Title updated: {}", announcementUpdateDto.getTitle());
        }
        if (announcementUpdateDto.getText()!=null&& !announcementUpdateDto.getText().isBlank() && !Objects.equals(announcementUpdateDto.getText(),announcement.getText())){
            announcement.setText(announcementUpdateDto.getText());
            log.info("Text updated: {}", announcementUpdateDto.getText());
        }
        Announcement saved = announcementRepo.save(announcement);
        return announcementMapper.toInfo(saved);
    }
}
