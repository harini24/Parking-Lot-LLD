package org.example.models;

import org.example.enums.FeeCalculationStrategyType;
import org.example.enums.ParkingStatus;
import org.example.enums.SlotAssignmentStrategyType;
import org.example.enums.VehicleType;
import org.example.strategies.FeeCalculationStrategy;

import java.util.List;

public class ParkingLot extends BaseModel{
    private String address;
    private List<ParkingFloor> floors;
    private ParkingStatus status;
    private List<Gate> gates;
    private List<VehicleType> allowedVehicleTypes;
    private FeeCalculationStrategyType feeCalculatingStrategyType;
    private SlotAssignmentStrategyType slotAssignmentStrategyType;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ParkingFloor> getFloors() {
        return floors;
    }

    public void setFloors(List<ParkingFloor> floors) {
        this.floors = floors;
    }

    public ParkingStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingStatus status) {
        this.status = status;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public List<VehicleType> getAllowedVehicleTypes() {
        return allowedVehicleTypes;
    }

    public void setAllowedVehicleTypes(List<VehicleType> allowedVehicleTypes) {
        this.allowedVehicleTypes = allowedVehicleTypes;
    }

    public SlotAssignmentStrategyType getSlotAssignmentStrategyType() {
        return slotAssignmentStrategyType;
    }

    public void setSlotAssignmentStrategyType(SlotAssignmentStrategyType slotAssignmentStrategyType) {
        this.slotAssignmentStrategyType = slotAssignmentStrategyType;
    }

    public FeeCalculationStrategyType getFeeCalculatingStrategyType() {
        return feeCalculatingStrategyType;
    }

    public void setFeeCalculatingStrategyType(FeeCalculationStrategyType feeCalculatingStrategyType) {
        this.feeCalculatingStrategyType = feeCalculatingStrategyType;
    }
}
