package org.example.dto;

import org.example.enums.VehicleType;

public class IssueTokenRequestDTO {
    private String VehicleNumber;
    private Long GateId;
    private String vehicleOwnerName;
    private VehicleType vehicleType;

    public String getVehicleNumber() {
        return VehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        VehicleNumber = vehicleNumber;
    }

    public Long getGateId() {
        return GateId;
    }

    public void setGateId(Long gateId) {
        GateId = gateId;
    }

    public String getVehicleOwnerName() {
        return vehicleOwnerName;
    }

    public void setVehicleOwnerName(String vehicleOwnerName) {
        this.vehicleOwnerName = vehicleOwnerName;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
