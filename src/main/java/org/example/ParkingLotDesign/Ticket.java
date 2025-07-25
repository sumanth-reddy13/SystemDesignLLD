package org.example.ParkingLotDesign;

import org.example.ParkingLotDesign.vehicleType.Vehicle;

import java.util.Date;

public class Ticket {

    private final String ticketId;
    private final Vehicle vehicle;
    private final ParkingSpot spot;
    private final long entryTimeStamp;
    private long exitTimeStamp;

    public Ticket(String ticketId, Vehicle vehicle, ParkingSpot spot) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTimeStamp = new Date().getTime() - (1000 * 60 * 60 * 24);
    }

    public void setExitTimeStamp() {
        this.exitTimeStamp = new Date().getTime();
    }

    public long getExitTimeStamp() {
        return exitTimeStamp;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public String getTicketId() {
        return this.ticketId;
    }

    public ParkingSpot getParkingSpot() {
        return this.spot;
    }

    public long getEntryTimeStamp() {
        return entryTimeStamp;
    }

    @Override
    public String toString() {
        return "TicketID : " + ticketId + "\n" +
                "Vehicle : " + vehicle.getLicenseNumber() + " \n" +
                "Parking Spot:  " + spot.getSpotNumber() + "\n" +
                "Entry Time: " + getEntryTimeStamp() + "\n" +
                "Exit Time: " + getExitTimeStamp();
    }
}
