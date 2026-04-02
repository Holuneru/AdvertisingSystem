package com.example.advertising_system.Mappers.AdvertiserMapper;

import org.mapstruct.Mapper;

import com.example.advertising_system.DTO.AdvertiserDto.Create.Response.AdvertiserPostCreateResponse;
import com.example.advertising_system.Entity.AdvertEntities.Advertiser;

@Mapper(componentModel = "spring")
public interface AdvertiserMapper {
    AdvertiserPostCreateResponse toDto(Advertiser advertiser);
    // обратный метод toEntity не нужен для создания, но можно добавить
}