package com.example.advertising_system.Service.AdvertiserService.Events.Targeting;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.advertising_system.DTO.TargetDto.Create.Request.TargetRequestCreate;
import com.example.advertising_system.DTO.TargetDto.Create.Response.TargetResponseCreate;
import com.example.advertising_system.Entity.AdvertEntities.Announcement;
import com.example.advertising_system.Entity.AdvertEntities.Target.AnTarget;
import com.example.advertising_system.Mappers.TargetMapper.TargetMapper;
import com.example.advertising_system.Repository.AdvertiserRepoes.AnnouncementRepo;
import com.example.advertising_system.Repository.Target.TargetRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class TargetService {

    private final TargetRepo targetRepo;
    private final AnnouncementRepo announcementRepo;
    private final TargetMapper targetMapper;
    @Transactional
    public TargetResponseCreate addTargetForAnnouncement(TargetRequestCreate targetRequestCreate){
        Announcement announcement = announcementRepo.findById(targetRequestCreate.getId()).orElseThrow(
            () -> new RuntimeException("Announcement not found")
        );

        if (announcement.getAntarget() != null) {
            throw new RuntimeException("Announcement has AnTARGET");
        }
        
        if (targetRequestCreate.getAgeFrom()!=null && targetRequestCreate.getAgeTo()!=null && targetRequestCreate.getAgeFrom() > targetRequestCreate.getAgeTo()) {
            throw new RuntimeException("INCORRECT Antarget");

        }
        
        AnTarget AnnewTarget = new AnTarget();
        AnnewTarget.setGender(targetRequestCreate.getGender());
        AnnewTarget.setAgeTo(targetRequestCreate.getAgeTo());
        AnnewTarget.setAgeFrom(targetRequestCreate.getAgeFrom());
        AnnewTarget.setLocation(targetRequestCreate.getLocation());
        AnnewTarget.setAnnouncement(announcement);
        
        AnTarget saved = targetRepo.save(AnnewTarget);

        return targetMapper.toResponse(saved);

    }


    
}
