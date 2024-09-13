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
    private final GasStationRepository gasStationRepository;
    private final ModelMapper modelMapper;

    public GasStationServiceImpl(GasStationRepository gasStationRepository, ModelMapper modelMapper) {
        this.gasStationRepository = gasStationRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public void addGasStation(GasStationDTO gasStationDTO) {
        GasStation gasStation = modelMapper.map(gasStationDTO, GasStation.class);

        System.out.println(gasStation.getLongitude()+" and "+ gasStation.getLatitude());
        // Set the GeoJSON location (ensure longitude is first, then latitude)
        gasStation.setLocation(new GeoJsonPoint(gasStation.getLongitude(), gasStation.getLatitude()));

        gasStationRepository.save(gasStation);
    }

    @Override
    public List<GasStationDTO> getNearbyGasStations(double latitude, double longitude) {
        return modelMapper.map(gasStationRepository.findNearbyGasStations(latitude, longitude), new TypeToken<List<GasStationDTO>>() {}.getType());
    }
}
