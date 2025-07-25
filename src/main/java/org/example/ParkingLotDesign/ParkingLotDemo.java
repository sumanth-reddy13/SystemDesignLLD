package org.example.ParkingLotDesign;

import org.example.ParkingLotDesign.vehicleType.Bike;
import org.example.ParkingLotDesign.vehicleType.Car;
import org.example.ParkingLotDesign.vehicleType.Vehicle;
import org.example.ParkingLotDesign.vehicleType.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotDemo {

    public void run() throws Exception {
        ParkingLot parkingLot = ParkingLot.getInstance();

        List<ParkingSpot> spots = List.of(
                new ParkingSpot(101, VehicleType.BIKE, false),
                new ParkingSpot(102, VehicleType.CAR, false),
                new ParkingSpot(103, VehicleType.TRUCK, false)
        );

        ParkingFloor floor1 = new ParkingFloor(1, spots);
        ParkingFloor floor2 = new ParkingFloor(2, List.of(
                new ParkingSpot(201, VehicleType.BIKE, false),
                new ParkingSpot(202, VehicleType.CAR, false)
        ));

        parkingLot.addFloors(floor1);
        parkingLot.addFloors(floor2);

        Vehicle audi = new Car("TS1234", VehicleType.CAR);
        Vehicle ktm = new Bike("TS234", VehicleType.BIKE);
        Vehicle truck1 = new Bike("TS2345", VehicleType.TRUCK);

        Ticket audiParkingTicket = parkingLot.parkVehicle(audi);
        Ticket ktmParkingTicket = parkingLot.parkVehicle(ktm);
        Ticket truck1ParkingTicket = parkingLot.parkVehicle(truck1);

        List<String> tickets = new ArrayList<>();
        tickets.add(audiParkingTicket.getTicketId());
        tickets.add(ktmParkingTicket.getTicketId());
        tickets.add(truck1ParkingTicket.getTicketId());

        double fee = parkingLot.unparkVehicle(audiParkingTicket.getTicketId());
        System.out.println("Parking charges for " + audiParkingTicket.getVehicle().getLicenseNumber() + " are Rs. " + fee);
    }
}
