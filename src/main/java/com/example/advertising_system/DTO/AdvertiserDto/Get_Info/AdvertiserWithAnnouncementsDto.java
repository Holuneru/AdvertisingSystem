package com.example.advertising_system.DTO.AdvertiserDto.Get_Info;

import java.util.List;

import lombok.Data;

@Data
public class AdvertiserWithAnnouncementsDto {
    private String id;
    private String name;
    private List<AnnouncementShortDto> announcements;
}
