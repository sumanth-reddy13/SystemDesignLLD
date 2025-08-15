package org.example.DigitalWalletDesign;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class Transaction {
    private final String transactionId = UUID.randomUUID().toString();
    private final int from;
    private final int to;
    private final BigDecimal amount;
    private final Date tranDate;

    public Transaction(int from, int to, BigDecimal amount) {
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
