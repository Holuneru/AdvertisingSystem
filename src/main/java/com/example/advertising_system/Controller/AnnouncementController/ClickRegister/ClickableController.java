package com.example.advertising_system.Controller.AnnouncementController.ClickRegister;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.advertising_system.Repository.ClientRepoes.ClickOnAnnouncementService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping(path = "/clients/click")
@RequiredArgsConstructor
public class ClickableController {

    private final ClickOnAnnouncementService clickOnAnnouncementService;

    @PutMapping("/{id}/announcement")
    public void clickOnAnnouncementEvent(@PathVariable String id, @RequestParam(required = true) Long announcement_id) { 
        clickOnAnnouncementService.ClickOnAnnouncement(id, announcement_id);
    }
    
}
