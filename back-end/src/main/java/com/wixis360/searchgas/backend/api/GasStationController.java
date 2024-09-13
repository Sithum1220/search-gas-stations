package com.wixis360.searchgas.backend.api;

import com.wixis360.searchgas.backend.dto.GasStationDTO;
import com.wixis360.searchgas.backend.entity.GasStation;
import com.wixis360.searchgas.backend.service.GasStationService;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/vi/gasStation")
@RestController
@CrossOrigin
public class GasStationController {

    private final GasStationService gasStationService;

    public GasStationController(GasStationService gasStationService) {
        this.gasStationService = gasStationService;
    }

//    @Autowired
//    private MongoTemplate mongoTemplate;

    @PostMapping("/save")
    public void addGasStation(@RequestBody GasStationDTO gasStationDTO) {
//        mongoTemplate.getDb().drop();
//        System.out.println("Database dropped successfully!");
        gasStationService.addGasStation(gasStationDTO);
        System.out.println(gasStationDTO.getLongitude()+" controller "+ gasStationDTO.getLatitude());
        System.out.println("save gasStation");
    }

    @GetMapping("/nearby")
    public List<GasStationDTO> getNearbyGasStations(@RequestParam double latitude, @RequestParam double longitude) {
        return gasStationService.getNearbyGasStations(latitude, longitude);
    }
}
