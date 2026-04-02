package com.example.advertising_system.Entity.MLScoreEntities;


import com.example.advertising_system.Entity.AdvertEntities.Advertiser;
import com.example.advertising_system.Entity.ClientEntities.Client;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ml_scores")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MLScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "advertiser_id", nullable = false)
    private Advertiser advertiser;
    
    @Column(nullable = false) @NotNull @PositiveOrZero private Integer score;
}

/*
Атрибуты ML-скоров:
    • ID пользователя.
    • ID рекламодателя.
    • ML-скор.
*/