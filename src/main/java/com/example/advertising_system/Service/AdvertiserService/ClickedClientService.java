package com.example.advertising_system.Service.AdvertiserService;
@Service
@RequiredArgsConstructor
@Slf4j
public class ClickedClientService {
    private final ClickedClientRepo clickedClientRepo;
    
    public void createClickedClientEntity(Client client, Announcement announcement){
        ClickedClient clickedClient = new ClickedClient();
        clickedClient.setClient(client);
        clickedClient.setAnnouncement(announcement);
        ClickedClient saved = clickedClientRepo.save(clickedClient);
        log.info("ClickedClient Created id: {}", saved.getId());
    }
}
