package org.example.strategies;

import org.example.enums.VehicleType;

import java.util.Date;

public class TireOneFeeCalculationStrategy implements  FeeCalculationStrategy{
    public int getFee(VehicleType vehicleType, Date entry, Date exit){
        return 0;
    }
}
