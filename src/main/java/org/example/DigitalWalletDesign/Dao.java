package org.example.DigitalWalletDesign;

import java.util.HashMap;

public class Dao {
    HashMap<Integer, Account> accounts;

    public Dao() {
        accounts = new HashMap<>();
    }

    public HashMap<Integer, Account> getAccounts() {
        return accounts;
    }
}
