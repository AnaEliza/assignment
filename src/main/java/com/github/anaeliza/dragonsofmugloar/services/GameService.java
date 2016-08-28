package com.github.anaeliza.dragonsofmugloar.services;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.anaeliza.dragonsofmugloar.domain.Battle;
import com.github.anaeliza.dragonsofmugloar.domain.Result;

public class GameService extends Service {

	private static final String START_GAME_URL = "api/game/";
	private static final String SEND_DRAGON_URL = "api/game/{gameId}/solution";

	private static final ObjectMapper mapper = new ObjectMapper();

	public Battle startBattle() {
		try {
			return mapper.readValue(get(START_GAME_URL), Battle.class);
		} catch (IOException e) {
			throw new RuntimeException("Error while trying to start a battle", e);
		}
	}

	public void sendDragon(Battle battle) {
		try {
			/**
			 * Jackson has a serialization option that allows you to use the class name as a wrapper:
			 * mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
			 * The generated string looks like:
			 * {"Dragon":{"scaleThickness":1,"clawSharpness":9,"wingStrength":1,"fireBreath":9}}
			 * But server can't deserialize 'Dragon', only 'dragon'.
			 */
			String dragon = "{\"dragon\":" + mapper.writeValueAsString(battle.getDragon()) + "}";
			String serviceUrl = SEND_DRAGON_URL.replaceAll("\\{gameId\\}", battle.getGameId() + "");
			
			InputStream is = put(serviceUrl, dragon);
			battle.setResult(mapper.readValue(is, Result.class));
		} catch (IOException e) {
			throw new RuntimeException("Error while trying to start a battle", e);
		}
	}

}
