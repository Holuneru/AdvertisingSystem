package com.example.advertising_system.Controller.ClientControllerCentre;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.advertising_system.DTO.ClientDto.ClientCreateDto.ClientCreateRequest.ClientCreateRequestDto;
import com.example.advertising_system.DTO.ClientDto.ClientCreateDto.ClientCreateResponse.ClientCreateResponseDto;
import com.example.advertising_system.Service.ClientService.ClientService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path = "/api/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @PostMapping(path = "/create")
    public ClientCreateResponseDto createClientAccount(@Valid @RequestBody ClientCreateRequestDto clientCreateRequestDto) {
        return clientService.createClientAccount(clientCreateRequestDto);
    }
    
}
