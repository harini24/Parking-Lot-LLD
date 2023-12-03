package org.example.dto;

import org.example.enums.PaymentMode;
import org.example.enums.PaymentStatus;

public class ResolveBillRequestDTO {
    private Long BillId;
    private PaymentMode mode;
    private int referenceNumber;
    private int amount;

    public Long getBillId() {
        return BillId;
    }

    public void setBillId(Long billId) {
        BillId = billId;
    }

    public PaymentMode getMode() {
        return mode;
    }

    public void setMode(PaymentMode mode) {
        this.mode = mode;
    }

    public int getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(int referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
