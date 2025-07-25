package org.example.ParkingLotDesign.fee;

import org.example.ParkingLotDesign.Ticket;

public class FlatRateFeeStrategy implements FeeStrategy {

    private final double rate = 10.00;
    public FlatRateFeeStrategy() {}

    @Override
    public double calculateFee(Ticket ticket) {
        long duration = ticket.getExitTimeStamp() - ticket.getEntryTimeStamp();
        double hours = ((double) duration / (1000 * 60 * 60));
        return hours * rate;
    }
}
