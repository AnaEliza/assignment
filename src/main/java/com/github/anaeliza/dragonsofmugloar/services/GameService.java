package com.github.anaeliza.dragonsofmugloar.services;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.github.anaeliza.dragonsofmugloar.domain.Battle;
import com.github.anaeliza.dragonsofmugloar.domain.Result;

public class GameService extends Service {
    
    private static final String START_GAME_URL = "api/game/";
    private static final String SEND_DRAGON_URL = "api/game/{gameId}/solution";
    
    private static final ObjectMapper mapper = new ObjectMapper();
    
    static {
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
    }
    
    public Battle startBattle() {
        try {
            return mapper.readValue(get(START_GAME_URL), Battle.class);
        } catch (IOException e) {
            throw new RuntimeException("Error while trying to start a battle", e);
        }
    }
    
    public Result sendDragon(Battle battle) {
        try {
            String dragon = mapper.writeValueAsString(battle.dragon());
            String serviceUrl = SEND_DRAGON_URL.replaceAll("\\{gameId\\}", battle.gameId() + "");
            
            InputStream is = put(serviceUrl, dragon);
            return mapper.readValue(is, Result.class);
        } catch (IOException e) {
            throw new RuntimeException("Error while trying to start a battle", e);
        }
    }
    
}
