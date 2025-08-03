package com.appkoder.parkinglot.account;

import com.appkoder.parkinglot.model.ParkingLot;
import com.appkoder.parkinglot.panel.Entry;
import com.appkoder.parkinglot.panel.Exit;
import com.appkoder.parkinglot.payment.Payment;
import com.appkoder.parkinglot.ticket.Ticket;
import com.appkoder.parkinglot.vehicle.Vehicle;

public class User extends Account {
    public Ticket requestTicket(Vehicle vehicle, ParkingLot lot, Entry entry) {
        return entry.generateTicket(vehicle, lot);
    }
    public Payment payForTicket(Ticket ticket, Exit exit) {
        return exit.processPayment(ticket);
    }
}