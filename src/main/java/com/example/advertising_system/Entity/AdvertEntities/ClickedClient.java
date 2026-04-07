package com.example.advertising_system.Entity.AdvertEntities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name = "clicked_clients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClickedClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String client_id;
    private Long announcement_id;



}
