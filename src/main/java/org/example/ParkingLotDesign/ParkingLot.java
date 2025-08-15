package org.example.ParkingLotDesign;

import org.example.ParkingLotDesign.fee.FeeStrategy;
import org.example.ParkingLotDesign.fee.FlatRateFeeStrategy;
import org.example.ParkingLotDesign.vehicleType.Vehicle;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLot {

    private static ParkingLot instance;
    private final List<ParkingFloor> floors;
    private FeeStrategy feeStrategy;
    private final Map<String, Ticket> activeTickets = new ConcurrentHashMap<>();

    public ParkingLot() {
        feeStrategy = new FlatRateFeeStrategy();
        floors = new ArrayList<>();
    }

    public static synchronized ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    public void addFloors(ParkingFloor floor) {
        floors.add(floor);
    }

    public void setFeeStrategy(FeeStrategy feeStrategy) {
        this.feeStrategy = feeStrategy;
    }

    public synchronized Ticket parkVehicle(Vehicle vehicle) throws Exception {
        if (vehicle == null) return null;

        for (ParkingFloor floor : floors) {
            Optional<ParkingSpot> spot = floor.getParkingSpot(vehicle.getVehicleType());
            if (spot.isPresent()) {
                ParkingSpot parkingSpot = spot.get();
                if (parkingSpot.park(vehicle)) {
                    String ticketId = UUID.randomUUID().toString();
                    Ticket ticket = new Ticket(ticketId, vehicle, parkingSpot);
                    activeTickets.put(ticketId, ticket);
                    return ticket;
                }
            }
        }

        throw new Exception("Parking spot is not available for " + vehicle.getVehicleType());
    }

    public synchronized double unparkVehicle(String ticketId) throws Exception {
        Ticket ticket = activeTickets.remove(ticketId);
        if (ticket == null) {
            throw new Exception("Invalid Ticket");
        }

        ParkingSpot spot = ticket.getParkingSpot();
        spot.unpark();

        ticket.setExitTimeStamp();
        return feeStrategy.calculateFee(ticket);
    }

    public List<ParkingFloor> getFloors() {
        return floors;
    }

    public Map<String, Ticket> getActiveTickets() {
        return activeTickets;
    }
}
