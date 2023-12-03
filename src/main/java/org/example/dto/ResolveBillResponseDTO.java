package org.example.dto;

import org.example.enums.BillStatus;
import org.example.enums.ResponseType;
import org.example.models.Payment;

public class ResolveBillResponseDTO {
    private ResponseType responseType;
    private Payment payment;

    private BillStatus billStatus;
    public ResponseType getResponseType() {
        return responseType;
    }

    public void setResponseType(ResponseType responseType) {
        this.responseType = responseType;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public BillStatus getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
    }
}
