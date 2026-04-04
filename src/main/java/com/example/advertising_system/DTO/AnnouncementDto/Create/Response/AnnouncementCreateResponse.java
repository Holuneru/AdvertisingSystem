package com.example.advertising_system.DTO.AnnouncementDto.Create.Response;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnnouncementCreateResponse {
    @Positive
    private double costPerImpression;   // цена за 1 показ

    @Positive
    private double costPerClick;        // цена за 1 переход

    @NotBlank
    private String title;               // название объявления

    @NotBlank
    private String text;                // текст объявления

    
    private LocalDate startDate;        // дата начала (не может быть в прошлом)

    private LocalDate endDate;          // дата окончания
}
