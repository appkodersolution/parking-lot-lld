package com.appkoder.parkinglot.model;

import com.appkoder.parkinglot.panel.Entry;
import com.appkoder.parkinglot.panel.Exit;
import com.appkoder.parkinglot.slot.ParkingSlot;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {

    private int floorNumber;

    // Composite Pattern: ParkingFloor is composed of multiple ParkingSlot objects.
    private List<ParkingSlot> slots;

    private List<Entry> entries;
    private List<Exit> exits;

    public ParkingFloor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.slots = new ArrayList<>();
        this.entries = new ArrayList<>();
        this.exits = new ArrayList<>();
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void addSlot(ParkingSlot slot) {
        slots.add(slot); // Composite Pattern: Adding leaf (slot) to composite (floor)
    }

    public void removeSlot(String slotId) {
        slots.removeIf(s -> s.getSlotId().equals(slotId));
    }

    public ParkingSlot findAvailableSlot(String vehicleType) {
        // Composite Pattern: Floor delegates to slots list
        return slots.stream()
                    .filter(slot -> !slot.isOccupied())
                    .filter(slot -> slot.getSupportedVehicleType().equalsIgnoreCase(vehicleType))
                    .findFirst()
                    .orElse(null); // or return Optional<ParkingSlot> if preferred
    }

    public void addEntryPanel(Entry panel) {
        entries.add(panel);
    }

    public void addExitPanel(Exit panel) {
        exits.add(panel);
    }
}