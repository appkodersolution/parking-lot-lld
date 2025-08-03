package com.appkoder.parkinglot.panel;

import com.appkoder.parkinglot.model.ParkingLot;
import com.appkoder.parkinglot.slot.ParkingSlot;
import com.appkoder.parkinglot.ticket.Ticket;
import com.appkoder.parkinglot.vehicle.Vehicle;

import java.util.Optional;

public class Entry {
    private final String panelId;
    private final String location;

    public Entry(String panelId, String location) {
        this.panelId = panelId;
        this.location = location;
    }

    public Ticket generateTicket(Vehicle vehicle, ParkingLot lot) {
        Optional<ParkingSlot> availableSlot = lot.getAvailableSlot(vehicle.getVehicleType());
        if (availableSlot.isPresent()) {
            ParkingSlot slot = availableSlot.get();
            if (slot.assignVehicle(vehicle)) {
                return new Ticket(vehicle, slot);
            }
        }
        throw new RuntimeException("No slot available for vehicle type: " + vehicle.getVehicleType());
    }
}