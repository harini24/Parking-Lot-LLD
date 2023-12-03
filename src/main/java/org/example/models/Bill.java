package org.example.models;

import org.example.enums.BillStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Bill extends BaseModel{
    private Date exitTime;
    private Token token;
    private Gate generatedAt;
    private Operator generatedBy;
    private List<Payment> payments;
    private BillStatus status;
    private int fee;

    public Bill(){
        payments= new ArrayList<>();
    }
    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public Gate getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(Gate generatedAt) {
        this.generatedAt = generatedAt;
    }

    public Operator getGeneratedBy() {
        return generatedBy;
    }

    public void setGeneratedBy(Operator generatedBy) {
        this.generatedBy = generatedBy;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public BillStatus getStatus() {
        return status;
    }

    public void setStatus(BillStatus status) {
        this.status = status;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public void addPayment(Payment payment){
        payments.add(payment);
    }

}
