package com.example.advertising_system.Mappers.ClientMapper;

import org.mapstruct.Mapper;

import com.example.advertising_system.DTO.ClientDto.ClientCreateDto.ClientCreateResponse.ClientCreateResponseDto;
import com.example.advertising_system.Entity.ClientEntities.Client;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientCreateResponseDto toDto (Client client);
    // обратный метод toEntity не нужен для создания, но можно добавить
}
