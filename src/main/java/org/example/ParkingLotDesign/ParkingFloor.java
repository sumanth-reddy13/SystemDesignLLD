package org.example.ParkingLotDesign;

import org.example.ParkingLotDesign.vehicleType.VehicleType;

import java.util.List;
import java.util.Optional;

public class ParkingFloor {
    private final int floorNumber;
    private final List<ParkingSpot> parkingSpots;

    public ParkingFloor(int floor, List<ParkingSpot> parkingSpots) {
        this.floorNumber = floor;
        this.parkingSpots = parkingSpots;
    }

    // Returns an available parking spot based on the vehicle type.
    public synchronized Optional<ParkingSpot> getParkingSpot(VehicleType type) {
        return parkingSpots.stream()
                    .filter(spot -> spot.isAvailable() && spot.getVehicleType() == type)
                    .findFirst();
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public int getFloorNumber() {
        return this.floorNumber;
    }

    public List<Integer> getAvailableSpots(VehicleType type) {
        return parkingSpots.stream()
                    .filter(spot -> spot.isAvailable() && spot.getVehicleType() == type)
                    .map(ParkingSpot::getSpotNumber)
                    .toList();
    }
}