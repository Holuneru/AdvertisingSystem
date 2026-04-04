package com.example.advertising_system.DTO.TargetDto.Create.Response;

import com.example.advertising_system.Entity.ClientEntities.ClientGender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TargetResponseCreate {
    
    private ClientGender gender;        // MALE, FEMALE, OTHER (может быть null – не важно)

    private Integer ageFrom;            // минимальный возраст (включительно)

    private Integer ageTo;              // максимальный возраст (включительно)

    private String location;            // например, "Москва", "Сахалин"
}
