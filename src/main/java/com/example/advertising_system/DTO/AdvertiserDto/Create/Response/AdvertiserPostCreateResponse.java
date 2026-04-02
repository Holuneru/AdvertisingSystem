package com.example.advertising_system.DTO.AdvertiserDto.Create.Response;

import java.util.ArrayList;
import java.util.List;

import com.example.advertising_system.Entity.AdvertEntities.Announcement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvertiserPostCreateResponse {
    
    private String name;

   private List<Announcement> announcements = new ArrayList<>();

    
}