package com.example.advertising_system.Service.MlScroreService;

import com.example.advertising_system.Entity.AdvertEntities.Advertiser;
import com.example.advertising_system.Entity.AdvertEntities.ClickedClient;
import com.example.advertising_system.Entity.ClientEntities.Client;
import com.example.advertising_system.Entity.MLScoreEntities.MLScore;
import com.example.advertising_system.Repository.AdvertiserRepoes.ClickedClientRepo;
import com.example.advertising_system.Repository.MLScoreRepo.MLScoreRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class MLScoreService {

    private final MLScoreRepo mlScoreRepo;
    private final ClickedClientRepo clickedClientRepo;
    public void theFirstClickOnAnnouncement(Advertiser advertiser, Client client){
        MLScore mlScore = new MLScore();
        mlScore.setAdvertiser(advertiser);
        mlScore.setClient(client);
        mlScore.setScore(1);
        MLScore saved = mlScoreRepo.save(mlScore);
        log.info("MlScore Created id: {}", saved.getId());
    }


    

    public boolean DetectClickTheFirst(String client_id, Long announcement_id){
         Optional<ClickedClient> optinalClickedClient = clickedClientRepo.findByClientIdWithAnnouncement(client_id,announcement_id);
         if(optinalClickedClient.isPresent()){
            log.info("Client has already clicked on an ad from this advertiser before");
            return false;
         } else {
            log.info("Client is clicking on an ad from this advertiser for the first time");
            return true;
         }
    }


}
