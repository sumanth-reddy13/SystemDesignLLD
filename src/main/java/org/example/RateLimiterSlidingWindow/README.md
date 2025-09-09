# RateLimiter — Sliding Window Implementation

## Components

### Decision Engine 
- Main part of the Rate Limiter. 
- Performs the check for a request whether to allow it or not.

### ConfigStore
- Stores the configuration for a key. 
- Configurations include time_window_sec and capacity.
- time_window_sec determines the active window.
- Capacity determines the maximum requests allowed in a window. 

### RequestStore
- Retrieves the count of requests in a window. 
- Adds a request to the memory.




## References
- [Arpit Bhayani's System Design Sliding Window based rate limiter](https://www.codementor.io/@arpitbhayani/system-design-sliding-window-based-rate-limiter-157x7sburi)