package org.example.DigitalWalletDesign;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class Account {
    private final int accountNumber;
    private BigDecimal balance;
    private final User user;
    private final Date createdAt;
    private final Set<Transaction> transactions = new TreeSet<>((a, b) ->
                                                            (a.getTranDate().compareTo(b.getTranDate())));
    private boolean isFD;
    private BigDecimal fdAmount;
    private long consecutiveTransactionAboveFD;

    public Account(String name, BigDecimal amount) {
        this.user = new User(name);
        this.accountNumber = AccountNumberGenerator.getAccountNumber();
        this.balance = amount;
        this.createdAt = new Date();
        isFD = false;
        fdAmount = new BigDecimal(0);
        consecutiveTransactionAboveFD = 0;
    }

    public int getAccountNumber() {
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

    public void setFD(int amount) {
        fdAmount.add(new BigDecimal(amount));
        isFD = true;
    }

    public BigDecimal getFdAmount() { return fdAmount; }

    @Override
    public String toString() {
        return "Account Number: " + this.accountNumber + " Balance: " + this.balance
                + " Account holder name: " + this.user.getUserName();
    }

    public void incrementTransactionAboveFDCount() {
        consecutiveTransactionAboveFD++;
    }

    public void setIsFDToFalse() {
        isFD = false;
        consecutiveTransactionAboveFD = 0;
        fdAmount = new BigDecimal(0);
    }

    public long getConsecutiveTransactionAboveFD() { return consecutiveTransactionAboveFD; }
}