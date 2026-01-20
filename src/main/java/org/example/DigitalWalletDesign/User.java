package org.example.DigitalWalletDesign;
import java.util.UUID;

public class User {
    private int userId;
    private final String name;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public User(String name) {
        this.name = name;
    }

    public int getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                '}';
    }
}
