package com.appkoder.parkinglot.panel;

import com.appkoder.parkinglot.payment.Payment;
import com.appkoder.parkinglot.ticket.Ticket;

public class Exit {
    private final String panelId;
    private final String location;
    public Exit(String panelId, String location) {
        this.panelId = panelId;
        this.location = location;
    }

    public Payment processPayment(Ticket ticket) {
        long duration = ticket.getDurationInMinutes();
        double amount = calculateAmount(duration, ticket.getVehicle().getVehicleType());
        ticket.getSlot().removeVehicle();
        Payment payment = new Payment(amount);
        payment.completePayment();
        return payment;
    }
    
    private double calculateAmount(long minutes, String type) {
        return switch (type.toUpperCase()) {
            case "CAR" -> 20 + (minutes / 30) * 10;
            case "BIKE" -> 10 + (minutes / 30) * 5;
            case "EBIKE" -> 15 + (minutes / 30) * 7;
            default -> 25;
        };
    }
}