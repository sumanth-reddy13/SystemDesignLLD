package org.example.RateLimiterSlidingWindow;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        outer: while (true) {
            System.out.println("Press 1 to create a requestor key");
            System.out.println("Press 2 to make a request");
            System.out.println("Press 3 to exit");

            int choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("Enter a key");
                    String key = sc.next();
                    ConfigStore.addConfig(key, 10, 1);
                    System.out.println("Configuration created for key: " + key);
                    break;
                }
                case 2: {
                    System.out.println("Enter key to make a request");
                    String key = sc.next();
                    String response = DecisionEngine.makeRequest(key);
                    System.out.println(response);
                    break;
                }
                case 3: {
                    break outer;
                }
                default:
                    System.out.println("Please select a valid option from 1, 2, 3");
                    break;
            }
        }
    }
}
