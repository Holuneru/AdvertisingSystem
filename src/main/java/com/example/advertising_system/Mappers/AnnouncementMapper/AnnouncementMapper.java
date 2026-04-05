package com.example.advertising_system.Mappers.AnnouncementMapper;


import com.example.advertising_system.DTO.AnnouncementDto.GetInfo.Response.AnnouncementResponseInfo;
import org.mapstruct.Mapper;
import com.example.advertising_system.DTO.AnnouncementDto.Create.Response.AnnouncementCreateResponse;
import com.example.advertising_system.Entity.AdvertEntities.Announcement;
@Mapper(componentModel = "spring")
public interface AnnouncementMapper {
    AnnouncementCreateResponse toResponse(Announcement announcement);
    AnnouncementResponseInfo toInfo(Announcement announcement);
    
    
} 

