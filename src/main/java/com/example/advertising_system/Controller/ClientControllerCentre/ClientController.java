package com.example.advertising_system.Controller.ClientControllerCentre;

import org.springframework.web.bind.annotation.*;

import com.example.advertising_system.DTO.ClientDto.ClientCreateDto.ClientCreateRequest.ClientCreateRequestDto;
import com.example.advertising_system.DTO.ClientDto.ClientCreateDto.ClientCreateResponse.ClientCreateResponseDto;
import com.example.advertising_system.Service.ClientService.ClientService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping(path = "/api/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @PostMapping(path = "/create")
    public ClientCreateResponseDto createClientAccount(@Valid @RequestBody ClientCreateRequestDto clientCreateRequestDto) {
        return clientService.createClientAccount(clientCreateRequestDto);
    }

    @GetMapping(path = "/id/{id}")
    public ClientCreateResponseDto getClientById(@PathVariable(name = "id") String id){
        return clientService.getClientById(id);
    }



}
