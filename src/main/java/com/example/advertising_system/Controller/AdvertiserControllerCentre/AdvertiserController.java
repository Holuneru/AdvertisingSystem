package com.example.advertising_system.Controller.AdvertiserControllerCentre;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.advertising_system.DTO.AdvertiserDto.Create.Request.AdvertiserCreateDto;
import com.example.advertising_system.DTO.AdvertiserDto.Create.Response.AdvertiserPostCreateResponse;
import com.example.advertising_system.DTO.AdvertiserDto.Get_Info.AdvertiserWithAnnouncementsDto;
import com.example.advertising_system.Service.AdvertiserService.AdvertiserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping(path = "/api/advertiser")
@RequiredArgsConstructor
public class AdvertiserController {
    private final AdvertiserService advertiserService;

    @PostMapping(path = "/create")
    public AdvertiserPostCreateResponse createAdveriser(@Valid @RequestBody AdvertiserCreateDto advertiserCreateDto ) {        
        return advertiserService.createAdvertiser(advertiserCreateDto);
    }

    @GetMapping(path = "/{name}/announcements")
    public AdvertiserWithAnnouncementsDto getAnnouncementsAdverter(@PathVariable String name) {
        return advertiserService.getAnnouncements(name);
    }

    @DeleteMapping(path = "/del/{id}")
    public void deleteCompany(@PathVariable String id){
        advertiserService.deleteAdvertiser(id);
    }
    
    
    
}
