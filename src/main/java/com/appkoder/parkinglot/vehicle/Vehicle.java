package com.appkoder.parkinglot.vehicle;

public abstract class Vehicle {
    protected String licenseNumber;
    protected String color;
    protected String vehicleType;

    public Vehicle(String licenseNumber, String color, String vehicleType) {
        this.licenseNumber = licenseNumber;
        this.color = color;
        this.vehicleType = vehicleType;
    }
    public String getLicenseNumber() {
        return licenseNumber;
    }
    public String getVehicleType() {
        return vehicleType;
    }
}