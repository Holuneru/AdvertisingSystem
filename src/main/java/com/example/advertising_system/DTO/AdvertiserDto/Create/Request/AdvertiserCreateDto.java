package com.example.advertising_system.DTO.AdvertiserDto.Create.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvertiserCreateDto {
    @NotBlank private String name;
}
