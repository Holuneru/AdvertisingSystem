package com.example.advertising_system.DTO.ClientDto.ClientCreateDto.ClientCreateResponse;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientCreateResponseDto {
    @NotBlank private String login;
    
    @NotNull @Positive private Integer age;
    
    @NotBlank private String location;
}
