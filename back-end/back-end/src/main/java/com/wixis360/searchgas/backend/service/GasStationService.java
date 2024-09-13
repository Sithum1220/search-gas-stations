package com.wixis360.searchgas.backend.service;

import com.wixis360.searchgas.backend.dto.GasStationDTO;
import com.wixis360.searchgas.backend.entity.GasStation;
import com.wixis360.searchgas.backend.repository.GasStationRepository;
import org.springframework.stereotype.Service;

import java.util.List;


public interface GasStationService {

     void addGasStation(GasStationDTO gasStationDTO);

     List<GasStationDTO> getNearbyGasStations(double latitude, double longitude);
}
