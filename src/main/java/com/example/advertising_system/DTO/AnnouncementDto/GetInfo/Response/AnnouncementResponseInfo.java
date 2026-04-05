package com.example.advertising_system.DTO.AnnouncementDto.GetInfo.Response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AnnouncementResponseInfo {
    private int impressions;

    private int clicks;

    private double costPerImpression;   // цена за 1 показ

    private double costPerClick;        // цена за 1 переход

    private String title;               // название объявления

    private String text;                // текст объявления

    private LocalDate startDate;        // дата начала (не может быть в прошлом)

    private LocalDate endDate;          // дата окончания
}
