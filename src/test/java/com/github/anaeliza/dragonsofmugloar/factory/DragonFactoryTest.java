package com.github.anaeliza.dragonsofmugloar.factory;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.anaeliza.dragonsofmugloar.domain.Dragon;
import com.github.anaeliza.dragonsofmugloar.domain.Knight;
import com.github.anaeliza.dragonsofmugloar.domain.Weather;

public class DragonFactoryTest {

	private final Knight DEFAULT_KNIGHT = new Knight("Sir. Russell Jones of Alberta", 2, 7, 3, 8);

	@Test
	public void recruitDragonForStorm() {
		Dragon dragon = DragonFactory.recruitDragon(DEFAULT_KNIGHT, Weather.STORM);

		assertEquals(5, dragon.getScaleThickness());
		assertEquals(5, dragon.getClawSharpness());
		assertEquals(5, dragon.getWingStrength());
		assertEquals(5, dragon.getFireBreath());
	}

	@Test
	public void recruitDragonForFog() {
		Dragon dragon = DragonFactory.recruitDragon(DEFAULT_KNIGHT, Weather.FOG);

		assertEquals(5, dragon.getScaleThickness());
		assertEquals(5, dragon.getClawSharpness());
		assertEquals(5, dragon.getWingStrength());
		assertEquals(5, dragon.getFireBreath());
	}

	@Test
	public void recruitDragonForLongDry() {
		Dragon dragon = DragonFactory.recruitDragon(DEFAULT_KNIGHT, Weather.LONG_DRY);

		assertEquals(5, dragon.getScaleThickness());
		assertEquals(5, dragon.getClawSharpness());
		assertEquals(5, dragon.getWingStrength());
		assertEquals(5, dragon.getFireBreath());
	}

	@Test
	public void recruitDragonForHeavyRain() {
		Dragon dragon = DragonFactory.recruitDragon(DEFAULT_KNIGHT, Weather.HEAVY_RAIN);

		assertEquals(5, dragon.getScaleThickness());
		assertEquals(10, dragon.getClawSharpness());
		assertEquals(5, dragon.getWingStrength());
		assertEquals(0, dragon.getFireBreath());
	}
	
	@Test
	public void recruitDragonForBalancedKnight() {
		Knight knight = new Knight("Sir. Russell Jones of Alberta", 5, 5, 5, 5);
		Dragon dragon = DragonFactory.recruitDragon(knight, Weather.REGULAR);

		assertEquals(4, dragon.getScaleThickness());
		assertEquals(4, dragon.getClawSharpness());
		assertEquals(5, dragon.getWingStrength());
		assertEquals(7, dragon.getFireBreath());
	}
	
	@Test
	public void recruitDragonForKnightWithHigherAttack() {
		Knight knight = new Knight("Sir. Russell Jones of Alberta", 8, 5, 5, 2);
		Dragon dragon = DragonFactory.recruitDragon(knight, Weather.REGULAR);

		assertEquals(10, dragon.getScaleThickness());
		assertEquals(4, dragon.getClawSharpness());
		assertEquals(4, dragon.getWingStrength());
		assertEquals(2, dragon.getFireBreath());
	}
	
	@Test
	public void recruitDragonForKnightWithHigherArmor() {
		Knight knight = new Knight("Sir. Russell Jones of Alberta", 0, 8, 6, 6);
		Dragon dragon = DragonFactory.recruitDragon(knight, Weather.REGULAR);

		assertEquals(0, dragon.getScaleThickness());
		assertEquals(10, dragon.getClawSharpness());
		assertEquals(5, dragon.getWingStrength());
		assertEquals(5, dragon.getFireBreath());
	}
	
	@Test
	public void recruitDragonForKnightWithHigherAgility() {
		Knight knight = new Knight("Sir. Russell Jones of Alberta", 1, 8, 5, 6);
		Dragon dragon = DragonFactory.recruitDragon(knight, Weather.REGULAR);

		assertEquals(0, dragon.getScaleThickness());
		assertEquals(10, dragon.getClawSharpness());
		assertEquals(4, dragon.getWingStrength());
		assertEquals(6, dragon.getFireBreath());
	}
	
	@Test
	public void recruitDragonForKnightWithHigherEndurance() {
		Knight knight = new Knight("Sir. Russell Jones of Alberta", 3, 5, 5, 7);
		Dragon dragon = DragonFactory.recruitDragon(knight, Weather.REGULAR);

		assertEquals(2, dragon.getScaleThickness());
		assertEquals(4, dragon.getClawSharpness());
		assertEquals(5, dragon.getWingStrength());
		assertEquals(9, dragon.getFireBreath());
	}

}
