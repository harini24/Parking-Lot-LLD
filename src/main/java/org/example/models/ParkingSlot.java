package org.example.models;

import org.example.enums.ParkingSlotStatus;
import org.example.enums.VehicleType;

public class ParkingSlot extends BaseModel{
    private int slotNumber;
    private VehicleType parkingType;
    private ParkingSlotStatus status;
    private ParkingFloor floor;

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public VehicleType getParkingType() {
        return parkingType;
    }

    public void setParkingType(VehicleType parkingType) {
        this.parkingType = parkingType;
    }

    public ParkingSlotStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingSlotStatus status) {
        this.status = status;
    }

    public ParkingFloor getFloor() {
        return floor;
    }

    public void setFloor(ParkingFloor floor) {
        this.floor = floor;
    }
}
