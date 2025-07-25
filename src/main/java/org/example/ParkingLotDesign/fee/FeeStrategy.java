package org.example.ParkingLotDesign.fee;

import org.example.ParkingLotDesign.Ticket;

public interface FeeStrategy {

    double calculateFee(Ticket ticket);
}
