package com.sam.weatherBackend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.sam.weatherBackend.Services.WeatherService;

@RestController
public class WeatherController {

    @Autowired
    WeatherService service;

    @GetMapping("/{city}/{apikey}")
    @ResponseBody
    public String getWeather(@PathVariable("city") String city,@PathVariable("apikey") String apikey) {

        String requestedWeather = service.getWeatherByCity(city, apikey);
        
        return requestedWeather;
    }
    
}
