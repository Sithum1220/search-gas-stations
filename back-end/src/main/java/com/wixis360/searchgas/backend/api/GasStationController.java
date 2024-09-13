package com.wixis360.searchgas.backend.api;

import com.wixis360.searchgas.backend.dto.GasStationDTO;
import com.wixis360.searchgas.backend.entity.GasStation;
import com.wixis360.searchgas.backend.service.GasStationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/vi/gasStation")
@RestController
@CrossOrigin
public class GasStationController {

    // Dependency injection for GasStationService to handle business logic
    private final GasStationService gasStationService;

    public GasStationController(GasStationService gasStationService) {
        this.gasStationService = gasStationService;
    }

    // API endpoint for saving a new gas station, expecting a GasStationDTO in the request body
    @PostMapping("/save")
    public void addGasStation(@RequestBody GasStationDTO gasStationDTO) {
        gasStationService.addGasStation(gasStationDTO);  // Calls the service layer to add the gas station
    }

    // API endpoint for retrieving nearby gas stations, using latitude and longitude as request parameters
    @GetMapping("/nearby")
    public List<GasStationDTO> getNearbyGasStations(@RequestParam double latitude, @RequestParam double longitude) {
        // Calls the service layer to get the list of nearby gas stations
        return gasStationService.getNearbyGasStations(latitude, longitude);
    }
}
