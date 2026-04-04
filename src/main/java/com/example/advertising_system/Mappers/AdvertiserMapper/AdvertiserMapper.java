package com.example.advertising_system.Mappers.AdvertiserMapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.advertising_system.DTO.AdvertiserDto.Create.Response.AdvertiserPostCreateResponse;
import com.example.advertising_system.DTO.AdvertiserDto.Get_Info.AdvertiserWithAnnouncementsDto;
import com.example.advertising_system.DTO.AdvertiserDto.Get_Info.AnnouncementShortDto;
import com.example.advertising_system.Entity.AdvertEntities.Advertiser;
import com.example.advertising_system.Entity.AdvertEntities.Announcement;

@Mapper(componentModel = "spring")
public interface AdvertiserMapper {
    AdvertiserPostCreateResponse toDto(Advertiser advertiser);
     // Сущность Advertiser → DTO с объявлениями
    @Mapping(target = "announcements", source = "announcements")
    AdvertiserWithAnnouncementsDto toWithAnnouncementsDto(Advertiser advertiser);

    // Сущность Announcement → краткое DTO
    AnnouncementShortDto toShortDto(Announcement announcement);
    // обратный метод toEntity не нужен для создания, но можно добавить
}