package com.appkoder.parkinglot.ticket;

import com.appkoder.parkinglot.slot.ParkingSlot;
import com.appkoder.parkinglot.vehicle.Vehicle;

import java.time.LocalDateTime;
import java.time.Duration;
import java.util.UUID;

public class Ticket {
    private final String ticketId;
    private final LocalDateTime entryTime;
    private final Vehicle vehicle;
    private final ParkingSlot slot;
    public Ticket(Vehicle vehicle, ParkingSlot slot) {
        this.ticketId = UUID.randomUUID().toString();
        this.entryTime = LocalDateTime.now();
        this.vehicle = vehicle;
        this.slot = slot;
    }
    public long getDurationInMinutes() {
        return Duration.between(entryTime, LocalDateTime.now()).toMinutes();
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public ParkingSlot getSlot() {
        return slot;
    }
    public String getTicketId() {
        return ticketId;
    }
    public LocalDateTime getEntryTime() {
        return entryTime;
    }
}