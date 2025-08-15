package org.example.DigitalWalletDesign;
import java.util.UUID;

public class User {
    private final String userId = UUID.randomUUID().toString();
    private final String name;

    public User(String name) {
        this.name = name;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.name;
    }
}
