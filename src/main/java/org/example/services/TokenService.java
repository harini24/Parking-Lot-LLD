package org.example.services;

import org.example.Exceptions.GateNotFoundException;
import org.example.enums.SlotAssignmentStrategyType;
import org.example.enums.VehicleType;
import org.example.models.Gate;
import org.example.models.ParkingSlot;
import org.example.models.Token;
import org.example.models.Vehicle;
import org.example.repositories.GateRepository;
import org.example.repositories.ParkingLotRepository;
import org.example.repositories.TokenRepository;
import org.example.repositories.VehicleRepository;
import org.example.strategies.SlotAssignmentStrategyFactory;

import java.util.Date;
import java.util.Optional;

public class  TokenService {

    GateRepository gateRepository;
    VehicleRepository vehicleRepository;
    ParkingLotRepository parkingLotRepository;
    TokenRepository tokenRepository;

    public TokenService(GateRepository gateRepository, VehicleRepository vehicleRepository, ParkingLotRepository parkingLotRepository,TokenRepository tokenRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.tokenRepository = tokenRepository;
    }

    public Token issueToken(String vehicleNumber, String vehicleOwner, VehicleType type, Long gateId) throws GateNotFoundException {
        // create token
        // assign spot
        // return ticket
        Token token = new Token();
        token.setEntryTime(new Date());

        Optional<Gate> gateOptional = gateRepository.findGateById(gateId);
        if(gateOptional.isEmpty()){
            throw new GateNotFoundException();
        }
        Gate gate = gateOptional.get();
        token.setEntryGate(gate);
        token.setGeneratedBy(gate.getOperator());

        Optional<Vehicle> vehicleOptional = vehicleRepository.findVehicleByNumber(vehicleNumber);
        Vehicle savedVehicle;
        if(vehicleOptional.isEmpty()){
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleNo(vehicleNumber);
            vehicle.setOwnerName(vehicleOwner);
            vehicle.setType(type);

            savedVehicle = vehicleRepository.saveVehicle(vehicle);
        }else{
            savedVehicle = vehicleOptional.get();
        }
        SlotAssignmentStrategyType slotAssignmentStrategyType = parkingLotRepository.getParkingLotByGate(gate).getSlotAssignmentStrategyType();
        ParkingSlot slot  = SlotAssignmentStrategyFactory.getSlotForType(slotAssignmentStrategyType).getSlot(gate,type);

        token.setSlot(slot);
        token.setVehicle(savedVehicle);

        token = tokenRepository.saveToken(token);
        token.setNumber("TICKET - "+token.getNumber());
        return token;
    }
}
