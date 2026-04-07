package com.example.advertising_system.Entity.ClientEntities;


import com.example.advertising_system.Entity.MLScoreEntities.MLScore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clients")
@Getter
@Setter
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
