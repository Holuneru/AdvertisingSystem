package com.example.advertising_system.Service.MlScroreService;

import com.example.advertising_system.Entity.AdvertEntities.Advertiser;
import com.example.advertising_system.Entity.ClientEntities.Client;
import com.example.advertising_system.Entity.MLScoreEntities.MLScore;
import com.example.advertising_system.Repository.ClientRepoes.ClientRepo;
import com.example.advertising_system.Repository.MLScoreRepo.MLScoreRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class MLScoreService {

    private final MLScoreRepo mlScoreRepo;

    private final ClientRepo clientRepo;

    public void theFirstClickOnAnnouncement(Advertiser advertiser, Client client){
        MLScore mlScore = new MLScore();
        mlScore.setAdvertiser(advertiser);
        mlScore.setClient(client);
        mlScore.setScore(1);
        MLScore saved = mlScoreRepo.save(mlScore);
        log.info("MlScore Created id: {}", saved.getId());
    }

    public boolean DetectClickTheFirst(Advertiser advertiser, Client client){
        Client findClientWithScores = clientRepo.findWithMLScores(client.getId())
                .orElseThrow(() -> new RuntimeException("Client not found with scores"));

        MLScore targetScore = findClientWithScores.getMlScore().stream()
                .filter(score -> score.getAdvertiser().getId().equals(advertiser.getId()))
                .findFirst()
                .orElse(null);  //МЕТОД НЕ ВЕРНЫй. Он не даст повторного клика если пользователь уже кликал на
                                //Рекламы данного рекламодателя
                                //Надо добавить Сущность ClickedClient и сделать Join к Announcement
                                //Тогда мы будем проверять idслиента в Сджоиненной сущности ClickedClient
                                //Если id не обнаружен то нам вернет False и мы сможем обработать это
                                //Через Optinal
                                //Пример: Optinal<ClickedClient> optinalClickedClient = clickedClientRepo.findByClientId(client_id);

        if(targetScore == null) {
            log.info("The first Click");
            return true;
        } else {
            // Запись есть – это не первый клик
            return false;
        }

    }



}
