package org.example.DigitalWalletDesign;

import java.util.Scanner;

public class WalletServiceDemo {
    public static void main(String[] args) {
        WalletService ws = WalletService.getInstance();

        User u1 = new User(1, "Sumanth");
        User u2 = new User(1, "Laddu");
        ws.addUser(u1);
        ws.addUser(u1);

        ws.createAccount(u1, "123456789", Currency.INR);
        ws.createAccount(u2, "789456123", Currency.INR);

        ws.deposit("123456789", 1000);
        ws.Transfer("123456789", "789456123", 102);

        ws.printAccountStatement("123456789");
        ws.overview();

        System.out.println(ws.getAccountBalance("123456789").toString());
        System.out.println(ws.getAccountBalance("789456123"));


//        outer: while(true) {
//            System.out.println("Enter your preference action below " + "\n" +
//                    "1. Create a Wallet" + "\n" +
//                    "2. Transfer Amount" + "\n" +
//                    "3. Fetch Wallet statement" + "\n" +
//                    "4. Overview" + "\n" +
//                    "5. EXIT"
//            );
//
//            switch (sc.nextInt()) {
//                case 1:
//                    System.out.println("Enter user name");
//                    String name = sc.next();
//                    System.out.println("Enter amount");
//                    int amount = sc.nextInt();
//                    ws.createWallet(name, amount);
//                    break;
//                case 2:
//                    System.out.println("Enter from account");
//                    int fromAccount = sc.nextInt();
//                    System.out.println("Enter to account");
//                    int toAccount = sc.nextInt();
//                    System.out.println("Enter amount to Transfer");
//                    amount = sc.nextInt();
//                    ws.Transfer(fromAccount, toAccount, amount);
//                    break;
//                case 3:
//                    System.out.println("Enter account number");
//                    int accNum = sc.nextInt();
//                    ws.getAccountStatement(accNum);
//                    break;
//                case 4:
//                    ws.overview();
//                    break;
//                case 5:
//                    System.out.println("Enter Account Number");
//                    accNum = sc.nextInt();
//                    System.out.println("Enter Fixed Deposit amount");
//                    amount = sc.nextInt();
//                    ws.createFD(accNum, amount);
//                    break;
//                case 6:
//                    ws.activateOffer2();
//                    break;
//                case 7:
//                    System.out.println("Application STOPPED!");
//                    break outer;
//                default:
//                    System.out.println("Enter a valid number");
//            }
//        }
    }
}
