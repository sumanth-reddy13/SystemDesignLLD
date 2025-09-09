package org.example.RateLimiterSlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class RequestStore {

    private static final Map<String, Map<Long, Integer>> requestStore = new HashMap<>();

    public static void registerRequest(String key, Long currentTime) {
        requestStore.putIfAbsent(key, new HashMap<>());
        requestStore.get(key).put(currentTime, requestStore.get(key).getOrDefault(currentTime, 0) + 1);
    }

    public static int getRequestCount(String key, long startTime) {
        if (!requestStore.containsKey(key)) {
            return 0;
        }
        int totalRequests = 0;

        for (Long timeSec : requestStore.get(key).keySet()) {
            long timeSecLong = timeSec;
            if (timeSecLong >= startTime) {
                totalRequests += requestStore.get(key).get(timeSec);
            }
        }

        return totalRequests;
    }
}
