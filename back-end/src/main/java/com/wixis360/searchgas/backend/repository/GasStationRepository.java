package com.wixis360.searchgas.backend.repository;

import com.wixis360.searchgas.backend.entity.GasStation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface GasStationRepository extends MongoRepository<GasStation, String> {

    // Custom query to find nearby gas stations based on latitude and longitude within a 10,000-meter radius (10 km)
    @Query("{ 'location': { $near: { $geometry: { type: 'Point', coordinates: [ ?1, ?0 ] }, $maxDistance: 10000 } } }")
    List<GasStation> findNearbyGasStations(double latitude, double longitude);
}
