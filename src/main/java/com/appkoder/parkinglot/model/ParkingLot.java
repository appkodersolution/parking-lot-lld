package com.appkoder.parkinglot.model;

import com.appkoder.parkinglot.panel.Entry;
import com.appkoder.parkinglot.panel.Exit;
import com.appkoder.parkinglot.slot.ParkingSlot;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ParkingLot {

    private static volatile ParkingLot instance;
    private static final Object lock = new Object();

    private String name;
    private String address;

    // Composite Pattern: ParkingLot is composed of multiple ParkingFloor objects.
    private List<ParkingFloor> floors;

    private List<Entry> entries;
    private List<Exit> exits;

    private ParkingLot(String name, String address) {
        this.name = name;
        this.address = address;
        this.floors = new ArrayList<>();
        this.entries = new ArrayList<>();
        this.exits = new ArrayList<>();
    }

    // Thread-safe Singleton with double-checked locking
    public static ParkingLot getInstance(String name, String address) {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new ParkingLot(name, address);
                }
            }
        }
        return instance;
    }

    public void addFloor(ParkingFloor floor) {
        floors.add(floor); // Composite Pattern: Adding component (floor) to composite (lot)
    }

    public void removeFloor(int floorNumber) {
        floors.removeIf(f -> f.getFloorNumber() == floorNumber);
    }

    public void addEntryPanel(Entry entry) {
        entries.add(entry);
    }

    public void addExitPanel(Exit exit) {
        exits.add(exit);
    }

    public Optional<ParkingSlot> getAvailableSlot(String vehicleType) {
        // Composite Pattern: Delegates search to each floor using stream
        return floors.stream()
                     .map(floor -> floor.findAvailableSlot(vehicleType))
                     .filter(Objects::nonNull)
                     .findFirst();
    }
}