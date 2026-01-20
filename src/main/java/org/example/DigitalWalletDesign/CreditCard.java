package org.example.DigitalWalletDesign;

public class CreditCard extends PaymentMethod {

    public CreditCard(int id, User user) {
        super(id, user);
    }

    public boolean processPayment(double amount, Currency currency) {
        return true;
    }
}
