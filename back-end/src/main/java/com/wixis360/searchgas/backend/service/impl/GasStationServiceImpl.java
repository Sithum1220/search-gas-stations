package com.wixis360.searchgas.backend.service.impl;

import com.wixis360.searchgas.backend.dto.GasStationDTO;
import com.wixis360.searchgas.backend.entity.GasStation;
import com.wixis360.searchgas.backend.repository.GasStationRepository;
import com.wixis360.searchgas.backend.service.GasStationService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GasStationServiceImpl implements GasStationService {

    // Repository for interacting with the MongoDB gas station collection
    private final GasStationRepository gasStationRepository;

    // ModelMapper for converting between DTO and entity objects
    private final ModelMapper modelMapper;

    // Constructor-based dependency injection
    public GasStationServiceImpl(GasStationRepository gasStationRepository, ModelMapper modelMapper) {
        this.gasStationRepository = gasStationRepository;
        this.modelMapper = modelMapper;
    }

    // Method to add a gas station, converting the DTO to an entity and saving it to the repository
    @Override
    public void addGasStation(GasStationDTO gasStationDTO) {
        // Map the DTO to a GasStation entity object
        GasStation gasStation = modelMapper.map(gasStationDTO, GasStation.class);

        // Set the GeoJsonPoint (used for geospatial queries in MongoDB) with the station's latitude and longitude
        gasStation.setLocation(new GeoJsonPoint(gasStation.getLongitude(), gasStation.getLatitude()));

        // Save the gas station entity to the repository (MongoDB)
        gasStationRepository.save(gasStation);
    }

    // Method to retrieve nearby gas stations based on latitude and longitude
    @Override
    public List<GasStationDTO> getNearbyGasStations(double latitude, double longitude) {
        // Use the repository to find nearby gas stations and map them to a list of GasStationDTOs
        return modelMapper.map(gasStationRepository.findNearbyGasStations(latitude, longitude), new TypeToken<List<GasStationDTO>>() {}.getType());
    }
}
