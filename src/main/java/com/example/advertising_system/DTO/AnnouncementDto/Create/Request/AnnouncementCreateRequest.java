package com.example.advertising_system.DTO.AnnouncementDto.Create.Request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnnouncementCreateRequest {

    
    private String id;

    // === Неизменяемые поля (устанавливаются при создании) ===

    @Positive
    private double costPerImpression;   // цена за 1 показ

    @Positive
    private double costPerClick;        // цена за 1 переход

    @NotBlank
    private String title;               // название объявления

    @NotBlank
    private String text;                // текст объявления

    // @Column(nullable = false, updatable = false)
    // private LocalDate startDate;        // дата начала (не может быть в прошлом)

    // @Column(nullable = false, updatable = false)
    // private LocalDate endDate;          // дата окончания
}
