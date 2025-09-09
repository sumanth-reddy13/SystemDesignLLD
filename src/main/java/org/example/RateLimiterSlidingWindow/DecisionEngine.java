package org.example.RateLimiterSlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class DecisionEngine {

    public static String makeRequest(String key) {

        Map<String, Integer> keyConfigs = ConfigStore.getConfig(key);
        int timeWindowInMinute = keyConfigs.get("timeWindowInSec");
        int capacity = keyConfigs.get("capacity");

        long currentTimeInSec = System.currentTimeMillis() / 1000;

        long startTime = currentTimeInSec - timeWindowInMinute;

        int totalRequests = RequestStore.getRequestCount(key, startTime);

        if (totalRequests >= capacity) {
            return "status - 429: too many requests.";
        }

        RequestStore.registerRequest(key, currentTimeInSec);
        return "Request Accepted";
    }
}
