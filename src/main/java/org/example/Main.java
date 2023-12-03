package org.example;

import org.example.controllers.BillController;
import org.example.controllers.TokenController;
import org.example.repositories.*;
import org.example.services.BillService;
import org.example.services.TokenService;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");
        GateRepository gateRepository = new GateRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        TokenRepository tokenRepository = new TokenRepository();
        BillRepository billRepository = new BillRepository();

        TokenService tokenService = new TokenService(gateRepository,vehicleRepository,parkingLotRepository,tokenRepository);

        TokenController tokenController = new TokenController(tokenService);

        BillService billService = new BillService(gateRepository,tokenRepository,parkingLotRepository,billRepository);

        BillController billController = new BillController(billService);

    }
}