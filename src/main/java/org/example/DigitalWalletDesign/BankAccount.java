package org.example.DigitalWalletDesign;

public class BankAccount extends PaymentMethod {

    public BankAccount(int id, User user) {
        super(id, user);
    }

    public boolean processPayment(double amount, Currency currency) {
        return true;
    }
}
