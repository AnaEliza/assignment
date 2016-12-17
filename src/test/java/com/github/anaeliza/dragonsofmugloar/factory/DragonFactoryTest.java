package com.github.anaeliza.dragonsofmugloar.factory;

import static org.junit.Assert.assertEquals;

import com.github.anaeliza.dragonsofmugloar.domain.ImmutableKnight;
import org.junit.Test;

import com.github.anaeliza.dragonsofmugloar.domain.Dragon;
import com.github.anaeliza.dragonsofmugloar.domain.Knight;
import com.github.anaeliza.dragonsofmugloar.domain.Weather;

public class DragonFactoryTest {

    private final Knight DEFAULT_KNIGHT = ImmutableKnight.builder()
            .name("Sir. Russell Jones of Alberta")
            .attack(2).armor(7).agility(3).endurance(8)
            .build();

    @Test
    public void summonDragonForStorm() {
        Dragon dragon = DragonFactory.summonDragon(DEFAULT_KNIGHT, Weather.STORM);

        assertEquals(5, dragon.scaleThickness());
        assertEquals(5, dragon.clawSharpness());
        assertEquals(5, dragon.wingStrength());
        assertEquals(5, dragon.fireBreath());
    }

    @Test
    public void summonDragonForFog() {
        Dragon dragon = DragonFactory.summonDragon(DEFAULT_KNIGHT, Weather.FOG);

        assertEquals(5, dragon.scaleThickness());
        assertEquals(5, dragon.clawSharpness());
        assertEquals(5, dragon.wingStrength());
        assertEquals(5, dragon.fireBreath());
    }

    @Test
    public void summonDragonForLongDry() {
        Dragon dragon = DragonFactory.summonDragon(DEFAULT_KNIGHT, Weather.LONG_DRY);

        assertEquals(5, dragon.scaleThickness());
        assertEquals(5, dragon.clawSharpness());
        assertEquals(5, dragon.wingStrength());
        assertEquals(5, dragon.fireBreath());
    }

    @Test
    public void summonDragonForHeavyRain() {
        Dragon dragon = DragonFactory.summonDragon(DEFAULT_KNIGHT, Weather.HEAVY_RAIN);

        assertEquals(5, dragon.scaleThickness());
        assertEquals(10, dragon.clawSharpness());
        assertEquals(5, dragon.wingStrength());
        assertEquals(0, dragon.fireBreath());
    }

    @Test
    public void summonDragonForBalancedKnight() {
        Knight knight = ImmutableKnight.builder()
                .name("Sir. Russell Jones of Alberta")
                .attack(5).armor(5).agility(5).endurance(5)
                .build();
        Dragon dragon = DragonFactory.summonDragon(knight, Weather.REGULAR);

        assertEquals(4, dragon.scaleThickness());
        assertEquals(4, dragon.clawSharpness());
        assertEquals(5, dragon.wingStrength());
        assertEquals(7, dragon.fireBreath());
    }

    @Test
    public void summonDragonForKnightWithHigherAttack() {
        Knight knight = ImmutableKnight.builder()
                .name("Sir. Russell Jones of Alberta")
                .attack(8).armor(5).agility(5).endurance(2)
                .build();
        Dragon dragon = DragonFactory.summonDragon(knight, Weather.REGULAR);

        assertEquals(10, dragon.scaleThickness());
        assertEquals(4, dragon.clawSharpness());
        assertEquals(4, dragon.wingStrength());
        assertEquals(2, dragon.fireBreath());
    }

    @Test
    public void summonDragonForKnightWithHigherArmor() {
        Knight knight = ImmutableKnight.builder()
                .name("Sir. Russell Jones of Alberta")
                .attack(0).armor(8).agility(6).endurance(6)
                .build();
        Dragon dragon = DragonFactory.summonDragon(knight, Weather.REGULAR);

        assertEquals(0, dragon.scaleThickness());
        assertEquals(10, dragon.clawSharpness());
        assertEquals(5, dragon.wingStrength());
        assertEquals(5, dragon.fireBreath());
    }

    @Test
    public void summonDragonForKnightWithHigherAgility() {
        Knight knight = ImmutableKnight.builder()
                .name("Sir. Russell Jones of Alberta")
                .attack(1).armor(8).agility(5).endurance(6)
                .build();
        Dragon dragon = DragonFactory.summonDragon(knight, Weather.REGULAR);

        assertEquals(0, dragon.scaleThickness());
        assertEquals(10, dragon.clawSharpness());
        assertEquals(4, dragon.wingStrength());
        assertEquals(6, dragon.fireBreath());
    }

    @Test
    public void summonDragonForKnightWithHigherEndurance() {
        Knight knight = ImmutableKnight.builder()
                .name("Sir. Russell Jones of Alberta")
                .attack(3).armor(5).agility(5).endurance(7)
                .build();
        Dragon dragon = DragonFactory.summonDragon(knight, Weather.REGULAR);

        assertEquals(2, dragon.scaleThickness());
        assertEquals(4, dragon.clawSharpness());
        assertEquals(5, dragon.wingStrength());
        assertEquals(9, dragon.fireBreath());
    }

}
