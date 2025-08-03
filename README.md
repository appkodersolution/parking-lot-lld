Here’s a complete and polished `README.md` content for your GitHub repo [`appkodersolution/parking-lot-lld`](https://github.com/appkodersolution/parking-lot-lld), aligned with your Medium blog post:

---

## 🅿️ Parking Lot System – Low Level Design (LLD)

This repository contains the complete Java implementation of the **Parking Lot System** described in the blog post:

🔗 **Blog**: [LLD Part-1: Parking Lot Design](https://medium.com/appkodersolution/lld-part-1-parking-lot-design-73a2825addf3)

---

### Overview

This project is a classic **Low-Level Design (LLD)** example for designing a scalable and extensible **Parking Lot System** using Object-Oriented Programming in Java 21 with Gradle.

It demonstrates the use of:

* ✅ SOLID Principles
* ✅ Design Patterns like Singleton, Composite, Inheritance, Factory, and State
* ✅ Modular Java 21 features
* ✅ Java 8 Stream API and Optional

---

### Features Implemented

| Feature               | Description                           |
| --------------------- | ------------------------------------- |
| Multiple Floors       | Each with its own slots and panels    |
| Multiple Slot Types   | `Car`, `Bike`, `Ebike`, etc.          |
| Entry Panel           | Issues a ticket if slot is available  |
| Exit Panel            | Processes payment and frees slot      |
| Ticketing             | Includes entry time, slot, vehicle    |
| Payment               | Calculates amount based on duration   |
| Admin Controls        | Add floors, slots, panels             |
| Thread-safe Singleton | For centralized `ParkingLot` instance |

---

### 🔁 Flow Covered

1. Admin adds floors, slots, and panels
2. User enters with vehicle at `Entry` panel
3. System checks for available slot and issues ticket
4. User exits via `Exit` panel
5. System calculates fee and completes payment

---

### 📋 Sequence Diagram

<img width="1600" height="800" alt="image" src="https://github.com/user-attachments/assets/3a344880-da61-4421-ad14-a25a524b8cf5" />

```
User -> Entry Panel -> ParkingLot -> Slot -> Ticket -> Exit Panel -> Payment
```

---

### 🚀 How to Run

```bash
# Build
./gradlew clean build

# Run Main
./gradlew run --args='com.appkoder.parkinglot.main.Main'
```

Or import into **IntelliJ IDEA** or **VSCode** and run the `Main` class.

---
