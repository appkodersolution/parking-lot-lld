package com.appkoder.parkinglot;

import com.appkoder.parkinglot.account.User;
import com.appkoder.parkinglot.model.ParkingFloor;
import com.appkoder.parkinglot.model.ParkingLot;
import com.appkoder.parkinglot.panel.Entry;
import com.appkoder.parkinglot.panel.Exit;
import com.appkoder.parkinglot.payment.Payment;
import com.appkoder.parkinglot.slot.CarSlot;
import com.appkoder.parkinglot.ticket.Ticket;
import com.appkoder.parkinglot.vehicle.Car;
import com.appkoder.parkinglot.vehicle.Vehicle;

public class Main {
    public static void main(String[] args) {
        // STEP 1: Create a ParkingLot instance (Singleton)
        ParkingLot lot = ParkingLot.getInstance("AppKoder Parking", "123 Code Street");

        // STEP 2: Add a parking floor
        ParkingFloor floor1 = new ParkingFloor(1);
        lot.addFloor(floor1);

        // STEP 3: Add a CarSlot to the floor
        CarSlot slot1 = new CarSlot("C1");
        floor1.addSlot(slot1);

        // STEP 4: Create Entry and Exit Panels and attach to floor
        Entry entryPanel = new Entry("E1", "North Gate");
        Exit exitPanel = new Exit("X1", "South Gate");
        floor1.addEntryPanel(entryPanel);
        floor1.addExitPanel(exitPanel);

        // STEP 5: Create a Car and a User
        Vehicle car = new Car("TN09AB1234", "Black");
        User user = new User();

        // STEP 6: User requests ticket at entry
        System.out.println("🚗 Vehicle arriving...");
        Ticket ticket = user.requestTicket(car, lot, entryPanel);
        System.out.println("🎫 Ticket issued: " + ticket.getTicketId() + " at " + ticket.getEntryTime());

        // Wait to simulate parking time (just for illustration)
        try {
            Thread.sleep(3000); // 3 seconds = simulate 3 minutes
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // STEP 7: User exits and pays
        Payment payment = user.payForTicket(ticket, exitPanel);
        System.out.println("💳 Payment completed. Amount: ₹" + payment.getAmount());
        System.out.println("🅿️ Slot released: " + ticket.getSlot().getSlotId());
        System.out.println("✅ Payment Status: " + payment.getStatus());
    }
}
