package com.example.advertising_system.Controller.AnnouncementController.SetTargetController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.advertising_system.DTO.TargetDto.Create.Request.TargetRequestCreate;
import com.example.advertising_system.DTO.TargetDto.Create.Response.TargetResponseCreate;
import com.example.advertising_system.Service.AdvertiserService.Events.Targeting.TargetService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/announcements/setTarget")
public class TargetController {

    private final TargetService targetService;

    @PostMapping(path = "/announcement/{id}/target/create")
    public TargetResponseCreate addTarget(@RequestBody TargetRequestCreate targetRequestCreate) {
        
        return targetService.addTargetForAnnouncement(targetRequestCreate);
    }
    
    
}
