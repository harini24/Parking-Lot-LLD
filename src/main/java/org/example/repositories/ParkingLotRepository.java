package org.example.repositories;

import org.example.models.Gate;
import org.example.models.ParkingLot;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class ParkingLotRepository {

    public Optional<ParkingLot> getParkingLotById(Long parkingLotId){
        return Optional.empty();
    }

    private Map<Long, ParkingLot> parkingLots = new TreeMap<>();
    public ParkingLot getParkingLotByGate(Gate gate){
        for(ParkingLot parkingLot : parkingLots.values()){
            if(parkingLot.getGates().contains(gate)){
                return parkingLot;
            }
        }
        return null;
    }
}
