package org.example.DigitalWalletDesign;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class Transaction {
    private final String transactionId;
    private final User from;
    private final User to;
    private final BigDecimal amount;
    private final Date tranDate;

    public Transaction(String transactionId, User from, User to, BigDecimal amount) {
        this.transactionId = transactionId;
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.tranDate = new Date();
    }

    public Date getTranDate() {
        return this.tranDate;
    }

    @Override
    public String toString() {
        return "from: " + from + " to: " + to + " amount: " + amount + " tranDate: " + tranDate;
    }
}
