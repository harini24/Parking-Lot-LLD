package org.example.strategies;

import org.example.enums.VehicleType;
import org.example.models.Gate;
import org.example.models.ParkingSlot;

public interface SlotAssignmentStrategy {
    public ParkingSlot getSlot(Gate gate, VehicleType vehicleType);
}
