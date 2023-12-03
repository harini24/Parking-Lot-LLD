package org.example.models;

import org.example.enums.FloorStatus;
import org.example.enums.VehicleType;

import java.util.List;

public class ParkingFloor extends BaseModel{
    private List<ParkingSlot> parkingSlots;
    private int floorNumber;
    private FloorStatus status;
    private List<VehicleType> vehicleTypes;

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public FloorStatus getStatus() {
        return status;
    }

    public void setStatus(FloorStatus status) {
        this.status = status;
    }

    public List<VehicleType> getVehicleTypes() {
        return vehicleTypes;
    }

    public void setVehicleTypes(List<VehicleType> vehicleTypes) {
        this.vehicleTypes = vehicleTypes;
    }
}
