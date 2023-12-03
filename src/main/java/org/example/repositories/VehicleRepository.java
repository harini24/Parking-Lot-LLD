package org.example.repositories;

import org.example.models.Gate;
import org.example.models.Vehicle;

import java.util.Optional;

public class VehicleRepository {
    public Optional<Vehicle> findVehicleByNumber(String vehicleNumber){
        // db.execute();
        return Optional.empty();
    }

    public Vehicle saveVehicle(Vehicle vehicle){
        // returned vehicle had id value returned from db, whereas the argument vehicle does not have id
        return  vehicle;
    }
}
