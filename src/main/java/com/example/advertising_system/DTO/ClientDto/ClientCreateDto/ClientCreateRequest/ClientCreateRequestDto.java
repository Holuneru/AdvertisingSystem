package com.example.advertising_system.DTO.ClientDto.ClientCreateDto.ClientCreateRequest;

import com.example.advertising_system.Entity.ClientEntities.ClientGender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientCreateRequestDto {
    @NotBlank private String login;
    
    @NotNull @Positive private Integer age;
    
    @NotBlank private String location;

    private ClientGender gender;
}
