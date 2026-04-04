package com.example.advertising_system.DTO.AdvertiserDto.Get_Info;

import java.time.LocalDate;

import lombok.Data;

@Data
public class AnnouncementShortDto {
    private Long id;
    private String title;
    private String text;
    private int impressions;
    private int clicks;
    private double costPerImpression;
    private double costPerClick;
    private LocalDate startDate;
    private LocalDate endDate;
    // Нет поля advertiser — цикл разорван
}
