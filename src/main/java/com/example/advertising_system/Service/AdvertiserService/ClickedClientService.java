package com.example.advertising_system.Service.AdvertiserService;
@Service
@RequiredArgsConstructor
@Slf4j
public class ClickedClientService {
    private final ClickedClientRepo clickedClientRepo;
    
        ClickedClient clickedClient = new ClickedClient();
        ClickedClient saved = clickedClientRepo.save(clickedClient);
        log.info("ClickedClient Created id: {}", saved.getId());
    }
}
