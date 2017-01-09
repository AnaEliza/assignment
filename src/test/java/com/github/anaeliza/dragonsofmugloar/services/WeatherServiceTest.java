package com.github.anaeliza.dragonsofmugloar.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.FileInputStream;
import java.io.InputStream;

import org.junit.Test;

import com.github.anaeliza.dragonsofmugloar.domain.Weather;

public class WeatherServiceTest {
    
    @Test
    public void getWeatherForecast() {
        WeatherService service = getWeatherService("src/test/resources/weatherForecast.xml");
        Weather weather = service.getWeatherForecast(1);
        assertEquals(Weather.REGULAR, weather);
    }
    
    @Test
    public void getInvalidWeatherForecast() {
        WeatherService service = getWeatherService("src/test/resources/invalidWeatherForecast.xml");
        
        try {
            service.getWeatherForecast(1);
            fail();
        } catch (RuntimeException e) {
            assertEquals("Error while trying to get the weather forecast for gameId 1", e.getMessage());
        }
    }
    
    private WeatherService getWeatherService(String filePath) {
        return new WeatherService() {
            @Override
            protected InputStream get(String serviceUrl) {
                try {
                    return new FileInputStream(filePath);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }
}
