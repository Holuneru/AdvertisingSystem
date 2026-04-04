package com.example.advertising_system.Mappers.TargetMapper;

import org.mapstruct.Mapper;

import com.example.advertising_system.DTO.TargetDto.Create.Response.TargetResponseCreate;
import com.example.advertising_system.Entity.AdvertEntities.Target.AnTarget;

@Mapper(componentModel = "spring")
public interface TargetMapper {
    TargetResponseCreate toResponse(AnTarget anTarget);
    
}
