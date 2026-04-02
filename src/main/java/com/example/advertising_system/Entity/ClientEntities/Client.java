package com.example.advertising_system.Entity.ClientEntities;

import java.util.ArrayList;
import java.util.List;

import com.example.advertising_system.Entity.MLScoreEntities.MLScore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clients")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    
    @Column(nullable = false) @NotBlank private String login;
    
    @Column(nullable = false) @NotNull @Min(14) @Max(120) private Integer age;
    
    @Column(nullable = false) @NotBlank private String location;

    @Enumerated(EnumType.STRING)
    private ClientGender gender;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MLScore> mlScore = new ArrayList<>();
}

/*
Атрибуты клиента:

    • ID пользователя UUID.
    • Логин в системе.
    • Возраст.
    • Название локации (метка, которая может быть как городом, регионом,
    так и небольшим районом, пример «Сахалин», «Екатеринбург», «Метро
    Белорусская» и др.).
    • Пол.

*/
