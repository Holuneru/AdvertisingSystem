package com.example.advertising_system.Controller.AnnouncementController;

import com.example.advertising_system.DTO.AnnouncementDto.GetInfo.Response.AnnouncementResponseInfo;
import com.example.advertising_system.DTO.AnnouncementDto.UpdateDto.AnnouncementUpdateDto;
import org.springframework.web.bind.annotation.*;

import com.example.advertising_system.DTO.AnnouncementDto.Create.Request.AnnouncementCreateRequest;
import com.example.advertising_system.DTO.AnnouncementDto.Create.Response.AnnouncementCreateResponse;
import com.example.advertising_system.Service.AdvertiserService.AnnouncementService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/announcements")
public class AnnouncementController {
    private final AnnouncementService announcementService;

    @PostMapping(path = "/create")
    public AnnouncementCreateResponse createAnnouncement(@Valid @RequestBody AnnouncementCreateRequest announcementCreateRequest) {        
        return announcementService.createAnouncement(announcementCreateRequest);
    }

    @GetMapping("/id/{id}")
    public AnnouncementResponseInfo getOne(@PathVariable Long id) {
        return announcementService.getByIdOne(id);
    }

    @PutMapping("/update/id/{id}")
    public AnnouncementResponseInfo updateAnnouncement(@PathVariable(name = "id") Long id, @RequestBody AnnouncementUpdateDto announcementUpdateDto){
        return announcementService.updateAnnouncementINFO(id, announcementUpdateDto);
    }
}
