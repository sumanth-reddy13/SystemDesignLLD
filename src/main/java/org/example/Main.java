package org.example;

import org.example.ParkingLotDesign.ParkingLotDemo;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ParkingLotDemo plDemo = new ParkingLotDemo();
        try {
            plDemo.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}