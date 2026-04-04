package com.example.advertising_system.Entity.AdvertEntities.Target;

import com.example.advertising_system.Entity.AdvertEntities.Announcement;
import com.example.advertising_system.Entity.ClientEntities.ClientGender;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "targets")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnTarget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ClientGender gender;        // MALE, FEMALE, OTHER (может быть null – не важно)

    private Integer ageFrom;            // минимальный возраст (включительно)
    private Integer ageTo;              // максимальный возраст (включительно)

    private String location;            // например, "Москва", "Сахалин"

    // Связь с объявлением (один к одному)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "announcement_id", unique = true)
    private Announcement announcement;
}
