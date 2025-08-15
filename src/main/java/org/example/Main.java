package org.example;

import org.example.DigitalWalletDesign.WalletService;
import org.example.ParkingLotDesign.ParkingLotDemo;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        WalletService ws = new WalletService();
        Scanner sc = new Scanner(System.in);

        outer: while(true) {
            System.out.println("Enter your preference action below " + "\n" +
                    "1. Create a Wallet" + "\n" +
                    "2. Transfer Amount" + "\n" +
                    "3. Fetch Wallet statement" + "\n" +
                    "4. Overview" + "\n" +
                    "5. Create Fixed Deposit " + "\n" +
                    "6. Active Offer 2" + "\n" +
                    "7. EXIT"
            );

            switch (sc.nextInt()) {
                case 1:
                    System.out.println("Enter user name");
                    String name = sc.next();
                    System.out.println("Enter amount");
                    int amount = sc.nextInt();
                    ws.createWallet(name, amount);
                    break;
                case 2:
                    System.out.println("Enter from account");
                    int fromAccount = sc.nextInt();
                    System.out.println("Enter to account");
                    int toAccount = sc.nextInt();
                    System.out.println("Enter amount to Transfer");
                    amount = sc.nextInt();
                    ws.Transfer(fromAccount, toAccount, amount);
                    break;
                case 3:
                    System.out.println("Enter account number");
                    int accNum = sc.nextInt();
                    ws.getAccountStatement(accNum);
                    break;
                case 4:
                    ws.overview();
                    break;
                case 5:
                    System.out.println("Enter Account Number");
                    accNum = sc.nextInt();
                    System.out.println("Enter Fixed Deposit amount");
                    amount = sc.nextInt();
                    ws.createFD(accNum, amount);
                    break;
                case 6:
                    ws.activateOffer2();
                    break;
                case 7:
                    System.out.println("Application STOPPED!");
                    break outer;
                default:
                    System.out.println("Enter a valid number");
            }
        }
    }
}