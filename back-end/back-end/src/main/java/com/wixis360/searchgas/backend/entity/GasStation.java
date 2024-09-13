package com.wixis360.searchgas.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "gasStations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GasStation {
    @Id
    private String id;
    private String name;
    private String address;
    private double latitude;
    private double longitude;
}