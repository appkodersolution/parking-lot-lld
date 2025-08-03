package com.appkoder.parkinglot.account;

import com.appkoder.parkinglot.model.ParkingFloor;
import com.appkoder.parkinglot.model.ParkingLot;
import com.appkoder.parkinglot.panel.Entry;
import com.appkoder.parkinglot.panel.Exit;
import com.appkoder.parkinglot.slot.ParkingSlot;

public class Admin extends Account {
    public void addFloor(ParkingLot lot, ParkingFloor floor) {
        lot.addFloor(floor);
    }
    public void addSlotToFloor(ParkingFloor floor, ParkingSlot slot) {
        floor.addSlot(slot);
    }
    public void addEntryPanel(ParkingFloor floor, Entry entry) {
        floor.addEntryPanel(entry);
    }
    public void addExitPanel(ParkingFloor floor, Exit exit) {
        floor.addExitPanel(exit);
    }
}