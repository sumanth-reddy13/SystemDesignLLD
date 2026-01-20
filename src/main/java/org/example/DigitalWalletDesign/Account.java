package org.example.DigitalWalletDesign;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class Account {
    private final String accountNumber;
    private BigDecimal balance;
    private final User user;
    private final Date createdAt;
    private final Set<Transaction> transactions;
    private Currency currency;

    public Account(User user, String accountNumber, Currency currency) {
        this.user = user;
        this.accountNumber = accountNumber;
        this.balance = BigDecimal.ZERO;
        this.createdAt = new Date();
        this.transactions = new TreeSet<>((a, b) -> (a.getTranDate().compareTo(b.getTranDate())));
        this.currency = currency;
    }

    public synchronized boolean deposit(double amount) {
        balance = balance.add(BigDecimal.valueOf(amount));
        return true;
    }

    public synchronized boolean withdraw(double amount) {
        balance = balance.subtract(BigDecimal.valueOf(amount));
        return true;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public User getUser() {
        return user;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }


    @Override
    public String toString() {
        return "Account Number: " + this.accountNumber + " Balance: " + this.balance
                + " Account holder name: " + this.user.getUserName();
    }

}