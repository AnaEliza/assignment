package com.github.anaeliza.dragonsofmugloar;

import java.util.HashMap;
import java.util.Map;

import com.github.anaeliza.dragonsofmugloar.domain.Battle;
import com.github.anaeliza.dragonsofmugloar.domain.Weather;
import com.github.anaeliza.dragonsofmugloar.domain.Result.Status;
import com.github.anaeliza.dragonsofmugloar.services.GameService;
import com.github.anaeliza.dragonsofmugloar.services.WeatherService;

public class Challenge {

	private GameService gameService = new GameService();
	private WeatherService weatherService = new WeatherService();

	private Map<Status, Integer> results = new HashMap<>();

	public void start() {
		Battle battle = gameService.startBattle();

		Weather weather = weatherService.getWeatherForecast(battle.getGameId());

		battle.assignDragon(weather);

		gameService.sendDragon(battle);

		results.merge(battle.getResult().getStatus(), 1, (oldValue, newValue) -> oldValue + newValue);
		
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
