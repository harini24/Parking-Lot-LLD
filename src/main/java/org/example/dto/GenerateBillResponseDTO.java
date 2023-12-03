package org.example.dto;

import org.example.enums.ResponseType;
import org.example.models.Bill;

public class GenerateBillResponseDTO {
    private String failureMessage;
    private ResponseType responseType;

    private Bill bill;
    public String getFailureMessage() {
        return failureMessage;
    }

    public void setFailureMessage(String failureMessage) {
        this.failureMessage = failureMessage;
    }

    public ResponseType getResponseType() {
        return responseType;
    }

    public void setResponseType(ResponseType responseType) {
        this.responseType = responseType;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}
