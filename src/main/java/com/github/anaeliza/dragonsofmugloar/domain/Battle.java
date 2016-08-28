package com.github.anaeliza.dragonsofmugloar.domain;

import com.github.anaeliza.dragonsofmugloar.factory.DragonFactory;

public class Battle {

	private int gameId;
	private Knight knight;
	private Weather weather;
	private Dragon dragon;
	private Result result;

	public int getGameId() {
		return gameId;
	}

	public Knight getKnight() {
		return knight;
	}

	public Weather getWeather() {
		return weather;
	}

	public Dragon getDragon() {
		return dragon;
	}

	public Result getResult() {
		return result;
	}

	public void assignDragon(Weather weather) {
		this.weather = weather;
		this.dragon = DragonFactory.recruitDragon(knight, weather);
	}

	public void setResult(Result result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "GameId: " + gameId + "\r\n" + weather + "\r\n" + knight + "\r\n" + dragon + "\r\n" + result;
	}

}
