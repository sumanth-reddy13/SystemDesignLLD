package org.example.ParkingLotDesign.fee;

import org.example.ParkingLotDesign.Ticket;
import org.example.ParkingLotDesign.vehicleType.VehicleType;
import java.util.Map;

public class VehicleBasedFeeStrategy implements FeeStrategy{
    private final Map<VehicleType, Double> hourlyRates = Map.of(
            VehicleType.BIKE, 10.0,
            VehicleType.CAR, 20.0,
            VehicleType.TRUCK, 30.0
    );

    public VehicleBasedFeeStrategy() {}

    @Override
    public double calculateFee(Ticket ticket) {
        long duration = ticket.getExitTimeStamp() - ticket.getEntryTimeStamp();
        double hours = (double) (duration/(1000 * 60 * 60));

        return hourlyRates.get(ticket.getVehicle().getVehicleType()) * hours;
    }
}
