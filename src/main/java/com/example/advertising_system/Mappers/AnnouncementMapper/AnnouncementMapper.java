package com.example.advertising_system.Mappers.AnnouncementMapper;


import org.mapstruct.Mapper;
import com.example.advertising_system.DTO.AnnouncementDto.Create.Response.AnnouncementCreateResponse;
import com.example.advertising_system.Entity.AdvertEntities.Announcement;
@Mapper(componentModel = "spring")
public interface AnnouncementMapper {
    AnnouncementCreateResponse toResponse(Announcement announcement);
    
    
    
} 

