package com.example.advertising_system.Entity.AdvertEntities;

import java.util.ArrayList;
import java.util.List;

import com.example.advertising_system.Entity.MLScoreEntities.MLScore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "advertisers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Advertiser {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    
    @Column(name = "name",nullable = false,unique = true) @NotBlank(message = "Название не может быть пустым") private String name;
    
    @OneToMany(mappedBy = "advertiser")
    private List<Announcement> announcements = new ArrayList<>();

    @OneToMany(mappedBy = "advertiser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MLScore> mlScores = new ArrayList<>();
}
/*
    Атрибуты рекламодателя:

    • ID рекламодателя UUID.
    • Название.

*/