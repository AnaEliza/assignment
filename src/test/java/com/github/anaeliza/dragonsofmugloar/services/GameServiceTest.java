package com.github.anaeliza.dragonsofmugloar.services;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.InputStream;

import com.github.anaeliza.dragonsofmugloar.domain.Battle;
import com.github.anaeliza.dragonsofmugloar.domain.ImmutableBattle;
import com.github.anaeliza.dragonsofmugloar.domain.ImmutableKnight;
import com.github.anaeliza.dragonsofmugloar.domain.Knight;
import com.github.anaeliza.dragonsofmugloar.domain.Result;
import org.junit.Test;

import com.github.anaeliza.dragonsofmugloar.domain.Result.Status;

public class GameServiceTest {
    
    private final Knight DEFAULT_KNIGHT = ImmutableKnight.builder()
            .name("Sir. Russell Jones of Alberta")
            .attack(2).armor(7).agility(3).endurance(8)
            .build();
    
    
    private final GameService service = new GameService() {
        @Override
        protected InputStream get(String serviceUrl) {
            try {
                return new FileInputStream("src/test/resources/startBattleResponse");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        
        @Override
        protected InputStream put(String serviceUrl, String data) {
            try {
                return new FileInputStream("src/test/resources/battleResultResponse");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    };
    
    @Test
    public void startBattle() {
        Battle battle = service.startBattle();
        
        assertEquals(483159, battle.gameId());
        assertEquals(DEFAULT_KNIGHT, battle.knight());
    }
    
    @Test
    public void sendDragon() {
        Battle battle = ImmutableBattle.builder().gameId(1).knight(DEFAULT_KNIGHT).build();
        Result result = service.sendDragon(battle);
        
        assertEquals(Status.DEFEAT, result.status());
        assertEquals("Dragon could not compete with knights armor", result.message());
    }
    
}
