package com.appkoder.parkinglot.payment;

import java.time.LocalDateTime;
import java.util.UUID;

public class Payment {
    private final String paymentId;
    private final LocalDateTime exitTime;
    private final double amount;
    private PaymentStatus status;
    public Payment(double amount) {
        this.paymentId = UUID.randomUUID().toString();
        this.exitTime = LocalDateTime.now();
        this.amount = amount;
        this.status = PaymentStatus.UNPAID;
    }
    public void completePayment() {
        this.status = PaymentStatus.PAID;
    }
    public PaymentStatus getStatus() {
        return status;
    }
    public double getAmount() {
        return amount;
    }
    public LocalDateTime getExitTime() {
        return exitTime;
    }
    public String getPaymentId() {
        return paymentId;
    }
}