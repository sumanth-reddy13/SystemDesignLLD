package org.example.ParkingLotDesign;

import org.example.ParkingLotDesign.vehicleType.Vehicle;
import org.example.ParkingLotDesign.vehicleType.VehicleType;

public class ParkingSpot {
    private final int spotNumber;
    private final VehicleType vehicleType;
    private Vehicle vehicle;
    private boolean isOccupied;

    public ParkingSpot(int spotNumber, VehicleType vehicleType, boolean isOccupied) {
        this.isOccupied = isOccupied;
        this.spotNumber = spotNumber;
        this.vehicleType = vehicleType;
    }

    public synchronized boolean isAvailable() {
        return !isOccupied;
    }

    public synchronized boolean park(Vehicle vehicle) {
        if (isOccupied || vehicle.getVehicleType() != vehicleType) {
            return false;
        }
        this.vehicle = vehicle;
        isOccupied = true;
        return true;
    }

    public synchronized void unpark() {
        vehicle = null;
        isOccupied = false;
    }

    public int getSpotNumber() {
        return this.spotNumber;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public VehicleType getVehicleType() {
        return this.vehicleType;
    }
}
