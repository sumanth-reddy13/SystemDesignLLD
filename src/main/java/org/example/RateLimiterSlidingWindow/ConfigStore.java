package org.example.RateLimiterSlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class ConfigStore {

    private static final Map<String, Map<String, Integer>> configStore = new HashMap<>();

    public static void addConfig(String key, int timeWindowInSec, int maxRequests) {
        if (configStore.containsKey(key)) {
            throw new IllegalArgumentException("Config already exists for key: " + key);
        }

        configStore.put(key, new HashMap<>());
        configStore.get(key).put("timeWindowInSec", timeWindowInSec);
        configStore.get(key).put("capacity", maxRequests);
    }

    public static Map<String, Integer> getConfig(String key) {
        return configStore.get(key);
    }
}
