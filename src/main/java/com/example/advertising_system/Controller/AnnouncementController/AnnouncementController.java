package com.example.advertising_system.Controller.AnnouncementController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.advertising_system.DTO.AnnouncementDto.Create.Request.AnnouncementCreateRequest;
import com.example.advertising_system.DTO.AnnouncementDto.Create.Response.AnnouncementCreateResponse;
import com.example.advertising_system.Service.AdvertiserService.AnnouncementService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/announcements")
public class AnnouncementController {
    private final AnnouncementService announcementService;

    @PostMapping(path = "/create")
    public AnnouncementCreateResponse createAnnouncement(@Valid @RequestBody AnnouncementCreateRequest announcementCreateRequest) {        
        return announcementService.createAnouncement(announcementCreateRequest);
    }
    
}
