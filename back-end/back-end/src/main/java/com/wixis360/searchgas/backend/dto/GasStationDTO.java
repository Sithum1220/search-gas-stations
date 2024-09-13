package com.wixis360.searchgas.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GasStationDTO {
    private String id;
    private String name;
    private String address;
    private double latitude;
    private double longitude;
}
