package com.appkoder.parkinglot.slot;

import com.appkoder.parkinglot.vehicle.Vehicle;

public abstract class ParkingSlot {
    protected String slotId;
    protected boolean isOccupied;
    protected String supportedVehicleType;
    protected Vehicle currentVehicle;

    public ParkingSlot(String slotId, String supportedVehicleType) {
        this.slotId = slotId;
        this.supportedVehicleType = supportedVehicleType;
        this.isOccupied = false;
    }
    public boolean assignVehicle(Vehicle vehicle) {
        if (!isOccupied && vehicle.getVehicleType().equalsIgnoreCase(supportedVehicleType)) {
            this.currentVehicle = vehicle;
            this.isOccupied = true;
            return true;
        }
        return false;
    }
    public void removeVehicle() {
        this.currentVehicle = null;
        this.isOccupied = false;
    }
    public boolean isAvailable() {
        return !isOccupied;
    }
    public String getSupportedVehicleType() {
        return supportedVehicleType;
    }
    public String getSlotId() {
        return slotId;
    }
    public boolean isOccupied() {
        return isOccupied;
    }
}