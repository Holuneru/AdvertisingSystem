package com.example.advertising_system.Entity.AdvertEntities;

import javax.annotation.processing.Generated;

@Entity
@Table(name = "clickedClients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClickedClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = true)
    private Client client;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "announcement_id", nullable = true)
    private Announcement announcement;



}
