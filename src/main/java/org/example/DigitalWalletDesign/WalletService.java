package org.example.DigitalWalletDesign;

import java.math.BigDecimal;
import java.util.*;

public class WalletService {
    HashMap<Integer, Account> accounts;
    PriorityQueue<Account> offer2PQ;

    public WalletService() {
        Dao dao = new Dao();
        accounts = dao.getAccounts();
        offer2PQ = new PriorityQueue<>(
                        (acc1, acc2) -> {
                            if (acc2.getTransactions().size() != acc1.getTransactions().size())
                                return acc2.getTransactions().size() < acc1.getTransactions().size() ? -1 : 1;

                            if (!acc2.getBalance().equals(acc1.getBalance())) {
                                return acc2.getBalance().intValue() < acc1.getBalance().intValue() ? -1 : 1;
                            }

                            return acc1.getCreatedAt().getTime() < acc2.getCreatedAt().getTime() ? -1 : 1;
                        });
    }

    public void createWallet(String name, int amount) {
        Account account = new Account(name, new BigDecimal(amount));
        accounts.put(account.getAccountNumber(), account);
        offer2PQ.add(account);
        System.out.println(account);
    }

    public void createFD(int accountNumber, int amount) {
        Account account = accounts.get(accountNumber);
        account.setFD(amount);
    }

    public void Transfer(int from, int to, int amount) {
        Transaction transaction = new Transaction(from, to, new BigDecimal(amount));
        Account fromAccount = accounts.get(from);
        Account toAccount = accounts.get(to);

        fromAccount.setBalance(fromAccount.getBalance().subtract(new BigDecimal(amount)));
        toAccount.setBalance(toAccount.getBalance().add(new BigDecimal(amount)));

        if (isOffer1Valid(fromAccount, toAccount)) {
            fromAccount.getBalance().add(new BigDecimal(10));
            toAccount.getBalance().add(new BigDecimal(10));
        }

        fdAmountCheck(fromAccount);
        fromAccount.setTransaction(transaction);
        System.out.println(transaction);
    }

    public void getAccountStatement(int accountNumber) {
        Account account = accounts.get(accountNumber);
        System.out.println(account.getTransactions());
    }

    public void overview() {
        for (Map.Entry<Integer, Account> account : accounts.entrySet()) {
            Set<Transaction> transactions = account.getValue().getTransactions();
            for (Transaction t : transactions) {
                System.out.println(t);
            }
        }
    }

    public boolean isOffer1Valid(Account fromAccount, Account toAccount) {
        return fromAccount.getBalance().equals(toAccount.getBalance());
    }

    public void fdAmountCheck(Account fromAccount) {
        if (fromAccount.getBalance().compareTo(fromAccount.getFdAmount()) > 0) {
            fromAccount.incrementTransactionAboveFDCount();
            long transactionsAboveFD = fromAccount.getConsecutiveTransactionAboveFD();
            if (transactionsAboveFD == 5) {
                fromAccount.getBalance().add(new BigDecimal(10));
            }
        }
        else {
            fromAccount.setIsFDToFalse();
        }
    }

    public void activateOffer2() {
        if (offer2PQ.size() < 3) return;

        int k = 3;
        List<Account> list = new ArrayList<>();
        while (k > 0 && !offer2PQ.isEmpty()) {
            list.add(offer2PQ.poll());
            k--;
        }

        System.out.println("Accounts eligible for offer 2 are : " + list);

        list.get(0).getBalance().add(new BigDecimal(10));
        list.get(1).getBalance().add(new BigDecimal(10));
        list.get(2).getBalance().add(new BigDecimal(10));

        for (Account acct : list) {
            offer2PQ.offer(acct);
        }
    }
}
