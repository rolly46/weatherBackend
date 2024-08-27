package com.sam.weatherBackend.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.sam.weatherBackend.Models.Weather;
import com.sam.weatherBackend.Repositories.WeatherRepo;

import reactor.core.publisher.Mono;

@Service
public class WeatherService {

    @Autowired
    WeatherRepo repo;
    @Autowired
    private WebClient webClient;
    @Autowired
    ApiKeyService apiKeyService;

    List<Weather> retreavedWeather;

    public String getWeatherByCity(String city, String apiKey) {
        // Check key
        if (apiKeyService.isApiKeyValid(apiKey) && !apiKeyService.isRateLimitExceeded(apiKey)) {
            // Use key
            apiKeyService.incrementUsage(apiKey);
            // check H2 if city is in DB
            retreavedWeather = repo.findByCity(city);
            System.out.println(retreavedWeather);
            // Does not exist
            if (retreavedWeather.size() == 0) {
                System.out.println("Does not exist in H2");
                // otherwise pull from OpenWeather Endpoint and save in repo
                Weather response = makeWeatherHTTPRequest(city);
                repo.save(response);
                return response.id;

            } else {
                System.out.println("Does exist in H2");
                return retreavedWeather.get(0).id;
            }
        } else {
            return "Error :(, either you have exceeded the API usage limit or the key is invalid.";
        }
    }

    private Weather makeWeatherHTTPRequest(String city) {
        // OpenWeather API key (hard coded not great..)
        String api = "9371b7983b04a8f89f7eecd4d9b99589";
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + api;
        Mono<Weather> response = webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(Weather.class);
        return response.block(); 
    }

}
