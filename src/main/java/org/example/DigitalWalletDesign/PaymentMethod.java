package org.example.DigitalWalletDesign;

public abstract class PaymentMethod {
    private final int id;
    private final User user;

    public PaymentMethod(int id, User user) {
        this.id = id;
        this.user = user;
    }

    public int getId() {
        return this.id;
    }

    public User getUser() {
        return this.user;
    }

    abstract boolean processPayment(double amount, Currency currency);
}