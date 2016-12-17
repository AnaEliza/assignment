package com.github.anaeliza.dragonsofmugloar;

import java.util.HashMap;
import java.util.Map;

import com.github.anaeliza.dragonsofmugloar.domain.Battle;
import com.github.anaeliza.dragonsofmugloar.domain.Dragon;
import com.github.anaeliza.dragonsofmugloar.domain.ImmutableBattle;
import com.github.anaeliza.dragonsofmugloar.domain.Result;
import com.github.anaeliza.dragonsofmugloar.domain.Result.Status;
import com.github.anaeliza.dragonsofmugloar.domain.Weather;
import com.github.anaeliza.dragonsofmugloar.factory.DragonFactory;
import com.github.anaeliza.dragonsofmugloar.services.GameService;
import com.github.anaeliza.dragonsofmugloar.services.WeatherService;

public class Challenge {
    
    private final GameService gameService = new GameService();
    private final WeatherService weatherService = new WeatherService();
    
    private final Map<Status, Integer> results = new HashMap<>();
    
    public void start() {
        Battle battle = gameService.startBattle();
        
        Weather weather = weatherService.getWeatherForecast(battle.gameId());
        Dragon dragon = DragonFactory.summonDragon(battle.knight(), weather);
        battle = ImmutableBattle.copyOf(battle).withWeather(weather).withDragon(dragon);
        
        Result result = gameService.sendDragon(battle);
        battle = ImmutableBattle.copyOf(battle).withResult(result);
        
        results.merge(battle.result().status(), 1, (oldValue, newValue) -> oldValue + newValue);
        
        System.out.println(battle);
    }
    
    public void printResult() {
        int victory = results.getOrDefault(Status.VICTORY, 0);
        int defeat = results.getOrDefault(Status.DEFEAT, 0);
        int ratio = (victory * 100) / (victory + defeat);
        
        System.out.println("Results:");
        System.out.println("\tVictory: " + victory);
        System.out.println("\tDefeat: " + defeat);
        System.out.println("\tSuccess ratio: " + ratio + "%");
    }
    
}
