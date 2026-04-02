package com.example.advertising_system.Service.ClientService;

import org.springframework.stereotype.Service;

import com.example.advertising_system.DTO.ClientDto.ClientCreateDto.ClientCreateRequest.ClientCreateRequestDto;
import com.example.advertising_system.DTO.ClientDto.ClientCreateDto.ClientCreateResponse.ClientCreateResponseDto;
import com.example.advertising_system.Entity.ClientEntities.Client;
import com.example.advertising_system.Mappers.ClientMapper.ClientMapper;
import com.example.advertising_system.Repository.ClientRepoes.ClientRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientService {
    private final ClientRepo clientRepo;
    private final ClientMapper clientMapper;


    public ClientCreateResponseDto createClientAccount(ClientCreateRequestDto clientCreateRequestDto){
        Client client = new Client();
        client.setLogin(clientCreateRequestDto.getLogin());
        client.setAge(clientCreateRequestDto.getAge());
        client.setGender(clientCreateRequestDto.getGender());
        client.setLocation(clientCreateRequestDto.getLocation());
        Client saved = clientRepo.save(client);
        log.info("Client account created: "+saved.getId()+" "+ saved.getLogin());
        return clientMapper.toDto(saved);
    }
}
