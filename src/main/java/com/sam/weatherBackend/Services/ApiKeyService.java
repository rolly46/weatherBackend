package com.sam.weatherBackend.Services;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

@Service
public class ApiKeyService {

    private final Map<String, Integer> apiKeyUsage = new ConcurrentHashMap<>();

    // Initialize with predefined API keys
    public ApiKeyService() {
        apiKeyUsage.put("eddykey", 0);
        apiKeyUsage.put("tommykey", 0);
        apiKeyUsage.put("anotherkey", 0);
        apiKeyUsage.put("howmanymore", 0);
        apiKeyUsage.put("lastkey", 0);
    }

    public boolean isApiKeyValid(String apiKey) {
        return apiKeyUsage.containsKey(apiKey);
    }

    public boolean isRateLimitExceeded(String apiKey) {
        return apiKeyUsage.get(apiKey) >= 5;
    }

    public void incrementUsage(String apiKey) {
        apiKeyUsage.put(apiKey, apiKeyUsage.get(apiKey) + 1);
    }
    
    public void resetUsage() {
        apiKeyUsage.replaceAll((k, v) -> 0);
    }
    
}
