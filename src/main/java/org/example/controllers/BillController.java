package org.example.controllers;

import org.example.dto.GenerateBillRequestDTO;
import org.example.dto.GenerateBillResponseDTO;
import org.example.dto.ResolveBillRequestDTO;
import org.example.dto.ResolveBillResponseDTO;
import org.example.enums.ResponseType;
import org.example.models.Bill;
import org.example.models.Payment;
import org.example.services.BillService;

public class BillController {
    BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    public GenerateBillResponseDTO generateBill(GenerateBillRequestDTO resolveBillRequestDTO){
        GenerateBillResponseDTO response = new GenerateBillResponseDTO();
        try{
            Bill bill = billService.generateBill(resolveBillRequestDTO.getTokenId(),resolveBillRequestDTO.getGateId());
            response.setBill(bill);
            response.setResponseType(ResponseType.SUCCESS);
        }catch (Exception e){
            response.setResponseType(ResponseType.FAILURE);
        }
        return response;
    }

    public ResolveBillResponseDTO resolveBill(ResolveBillRequestDTO resolveBillRequestDTO){
        ResolveBillResponseDTO response = new ResolveBillResponseDTO();
        try{
            Payment payment = billService.resolveBill(resolveBillRequestDTO.getBillId(),resolveBillRequestDTO.getMode(),resolveBillRequestDTO.getAmount(),resolveBillRequestDTO.getReferenceNumber());
            response.setPayment(payment);
            response.setBillStatus(billService.getBillStatusForId(resolveBillRequestDTO.getBillId()));
            response.setResponseType(ResponseType.SUCCESS);
        }catch (Exception e){
            response.setResponseType(ResponseType.FAILURE);
        }
        return response;
    }
}
