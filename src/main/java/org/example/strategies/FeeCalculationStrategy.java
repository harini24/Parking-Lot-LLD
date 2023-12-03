package org.example.strategies;

import org.example.enums.VehicleType;

import java.util.Date;

public interface FeeCalculationStrategy {

    public int getFee(VehicleType vehicleType, Date entry, Date exit);
}
