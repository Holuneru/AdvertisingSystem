package com.example.advertising_system.Service.AdvertiserService;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.advertising_system.DTO.AdvertiserDto.Create.Request.AdvertiserCreateDto;
import com.example.advertising_system.DTO.AdvertiserDto.Create.Response.AdvertiserPostCreateResponse;
import com.example.advertising_system.DTO.AdvertiserDto.Get_Info.AdvertiserWithAnnouncementsDto;
import com.example.advertising_system.Entity.AdvertEntities.Advertiser;
import com.example.advertising_system.Mappers.AdvertiserMapper.AdvertiserMapper;
import com.example.advertising_system.Repository.AdvertiserRepoes.AdvertiserRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdvertiserService {
    private final AdvertiserRepo advertiserRepo;
    private final AdvertiserMapper advertiserMapper;

    @Transactional
    public AdvertiserPostCreateResponse createAdvertiser(AdvertiserCreateDto advertiserCreateDto){
        if (advertiserCreateDto.getName() == null || advertiserCreateDto.getName().isBlank()) {
            throw new RuntimeException("Name Invalide");
        }
        Advertiser advertiser = new Advertiser();
        advertiser.setName(advertiserCreateDto.getName());
        Advertiser saved = advertiserRepo.save(advertiser);
        log.info("Рекламодатель сохранен под UUID: "+ saved.getId());
        return advertiserMapper.toDto(saved);
    }

    public AdvertiserWithAnnouncementsDto getAnnouncements(String name){
        Advertiser advertiser = advertiserRepo.findWithAnnouncements(name).orElseThrow(
            () -> new RuntimeException("Advertiser undefinde"));
        return advertiserMapper.toWithAnnouncementsDto(advertiser);
    }

    public void deleteAdvertiser(String uuID){
        Advertiser advertiser = advertiserRepo.findById(uuID).orElseThrow(
            ()-> new RuntimeException("Advertiser undefinde"));
        advertiserRepo.delete(advertiser);
        log.info("Удалено");
    }

}
