package com.github.anaeliza.dragonsofmugloar.services;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.InputStream;

import org.junit.Test;

import com.github.anaeliza.dragonsofmugloar.domain.Battle;
import com.github.anaeliza.dragonsofmugloar.domain.Result.Status;

public class GameServiceTest {

	private GameService service = new GameService() {
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
		};
	};

	@Test
	public void startBattle() {
		Battle battle = service.startBattle();

		assertEquals(483159, battle.getGameId());
		assertEquals("Sir. Russell Jones of Alberta", battle.getKnight().getName());
		assertEquals(2, battle.getKnight().getAttack());
		assertEquals(7, battle.getKnight().getArmor());
		assertEquals(3, battle.getKnight().getAgility());
		assertEquals(8, battle.getKnight().getEndurance());
	}

	@Test
	public void sendDragon() {
		Battle battle = new Battle();
		service.sendDragon(battle);
		
		assertEquals(Status.DEFEAT, battle.getResult().getStatus());
		assertEquals("Dragon could not compete with knights armor", battle.getResult().getMessage());
	}

}
