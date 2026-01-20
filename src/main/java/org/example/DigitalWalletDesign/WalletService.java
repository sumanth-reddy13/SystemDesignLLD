package org.example.DigitalWalletDesign;

import java.math.BigDecimal;
import java.util.*;

public class WalletService {
    Map<Integer, User> users = new HashMap<>();
    Map<String, Account> accounts = new HashMap<>();
    private static WalletService instance;

    private WalletService() {}

    public static synchronized WalletService getInstance() {
        if (instance == null) {
            instance = new WalletService();
        }
        return instance;
    }

    public void deposit(String acctNum, double amount) {
        Account acct = accounts.get(acctNum);
        acct.deposit(amount);
    }

    public BigDecimal getAccountBalance(String accountNumber) {
        Account acct = accounts.get(accountNumber);
        return acct.getBalance();
    }

    public void withdraw(String acctNum, double amount) {
        Account acct = accounts.get(acctNum);
        acct.withdraw(amount);
    }

    public void addUser(User user) {
        users.put(user.getUserId(), user);
    }

    public void createAccount(User user, String accountNumber, Currency currency) {
        Account account = new Account(user, accountNumber, currency);
        accounts.put(account.getAccountNumber(), account);
    }

    public synchronized void Transfer(String fromAccountNumber, String toAcctNum, int amount) {

        if (!accounts.containsKey(fromAccountNumber) || !accounts.containsKey(toAcctNum)) {
            throw new RuntimeException("Account number doesn't exist.");
        }
        Account fromAccount = accounts.get(fromAccountNumber);
        Account toAccount = accounts.get(toAcctNum);
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);

        Transaction transaction = new Transaction(UUID.randomUUID().toString(),
                fromAccount.getUser(),
                toAccount.getUser(),
                new BigDecimal(amount)
        );

        fromAccount.setTransaction(transaction);
        toAccount.setTransaction(transaction);
    }

    public void printAccountStatement(String accountNumber) {
        Account account = accounts.get(accountNumber);
        System.out.println(account.getTransactions());
    }

    public void overview() {
        for (Map.Entry<String, Account> account : accounts.entrySet()) {
            Set<Transaction> transactions = account.getValue().getTransactions();
            for (Transaction t : transactions) {
                System.out.println(t);
            }
        }
    }
}
