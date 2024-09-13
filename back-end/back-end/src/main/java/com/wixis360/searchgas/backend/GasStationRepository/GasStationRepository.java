package com.wixis360.searchgas.backend.GasStationRepository;

import com.wixis360.searchgas.backend.entity.GasStation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface GasStationRepository extends MongoRepository<GasStation, String> {
    @Query("{ 'location': { $near: { $geometry: { type: 'Point', coordinates: [ ?1, ?0 ] }, $maxDistance: 10000 } } }")
    List<GasStation> findNearbyGasStations(double latitude, double longitude);
}