package org.example.services;

import org.example.Exceptions.BillNotFoundException;
import org.example.Exceptions.GateNotFoundException;
import org.example.Exceptions.TokenNotFoundException;
import org.example.enums.BillStatus;
import org.example.enums.FeeCalculationStrategyType;
import org.example.enums.PaymentMode;
import org.example.enums.PaymentStatus;
import org.example.models.Bill;
import org.example.models.Gate;
import org.example.models.Payment;
import org.example.models.Token;
import org.example.repositories.BillRepository;
import org.example.repositories.GateRepository;
import org.example.repositories.ParkingLotRepository;
import org.example.repositories.TokenRepository;
import org.example.strategies.FeeCalculationStrategy;
import org.example.strategies.FeeCalculationStrategyFactory;

import java.util.Date;
import java.util.Optional;

public class BillService {

    GateRepository gateRepository;
    TokenRepository tokenRepository;
    ParkingLotRepository parkingLotRepository;
    BillRepository billRepository;

    public BillService(GateRepository gateRepository, TokenRepository tokenRepository, ParkingLotRepository parkingLotRepository, BillRepository billRepository) {
        this.gateRepository = gateRepository;
        this.tokenRepository = tokenRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.billRepository = billRepository;
    }

    public Bill generateBill(Long tokenId, Long gateId) throws TokenNotFoundException, GateNotFoundException {
        Bill bill = new Bill();
        bill.setExitTime(new Date());

        Optional<Token> tokenOptional = tokenRepository.getTokenById(tokenId);
        if(tokenOptional.isEmpty()){
            throw new TokenNotFoundException();
        }
        Token token = tokenOptional.get();
        bill.setToken(token);

        Optional<Gate> gateOptional = gateRepository.findGateById(gateId);
        if(gateOptional.isEmpty()){
            throw new GateNotFoundException();
        }
        Gate gate = gateOptional.get();
        bill.setGeneratedAt(gate);
        bill.setGeneratedBy(gate.getOperator());
        bill.setStatus(BillStatus.UNPAID);

        FeeCalculationStrategyType feeCalculatingStrategyType = parkingLotRepository.getParkingLotByGate(gate).getFeeCalculatingStrategyType();
        int fee = FeeCalculationStrategyFactory.getFeeForType(feeCalculatingStrategyType).getFee(token.getVehicle().getType(), token.getEntryTime(),bill.getExitTime());

        bill.setFee(fee);
        billRepository.saveBill(bill);

        return bill;
    }

    public Payment resolveBill(Long BillId, PaymentMode mode, int amount, int referenceNumber) throws BillNotFoundException {
        Payment payment = new Payment();

        Optional<Bill> billOptional = billRepository.getBillById(BillId);
        if(billOptional.isEmpty()){
            throw new BillNotFoundException();
        }
        Bill bill = billOptional.get();
        bill.addPayment(payment);

        payment.setBill(bill);
        payment.setMode(mode);
        payment.setAmount(amount);
        payment.setReferenceNumber(referenceNumber);
        payment.setStatus(PaymentStatus.SUCCESS);

        int paid = 0;
        for(Payment pymnt:bill.getPayments()){
            if(pymnt.getStatus().equals(PaymentStatus.SUCCESS)){
                paid += pymnt.getAmount();
            }
        }
        if(paid >= bill.getFee()){
            bill.setStatus(BillStatus.PAID);
        }else if(paid > 0){
            bill.setStatus(BillStatus.PARTIALLY_PAID);
        }

        return payment;
    }

    public BillStatus getBillStatusForId(Long BillId) throws BillNotFoundException {
        Optional<Bill> billOptional = billRepository.getBillById(BillId);
        if(billOptional.isEmpty()){
            throw new BillNotFoundException();
        }
        Bill bill = billOptional.get();
        return  bill.getStatus();
    }
}
