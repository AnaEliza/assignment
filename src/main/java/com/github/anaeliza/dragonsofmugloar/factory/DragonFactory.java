package com.github.anaeliza.dragonsofmugloar.factory;

import static com.github.anaeliza.dragonsofmugloar.domain.Weather.FOG;
import static com.github.anaeliza.dragonsofmugloar.domain.Weather.HEAVY_RAIN;
import static com.github.anaeliza.dragonsofmugloar.domain.Weather.LONG_DRY;
import static com.github.anaeliza.dragonsofmugloar.domain.Weather.STORM;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import com.github.anaeliza.dragonsofmugloar.domain.Dragon;
import com.github.anaeliza.dragonsofmugloar.domain.ImmutableDragon;
import com.github.anaeliza.dragonsofmugloar.domain.Knight;
import com.github.anaeliza.dragonsofmugloar.domain.Weather;

public class DragonFactory {

    /**
     * Has skills equally evolved
     */
    private static final Dragon BALANCED_DRAGON = ImmutableDragon.builder()
            .scaleThickness(5).clawSharpness(5).wingStrength(5).fireBreath(5)
            .build();

    /**
     * Doesn't breath fire but has extra sharp claws
     */
    private static final Dragon CLAW_DRAGON = ImmutableDragon.builder()
            .scaleThickness(5).clawSharpness(10).wingStrength(5).fireBreath(0)
            .build();

    public static Dragon summonDragon(Knight knight, Weather weather) {
        if (weather == STORM || weather == FOG || weather == LONG_DRY) {
            // If it is a storm everybody will die, if it is a fog the knight
            // won't be able to fight back and if it is the long dry we need a
            // balanced dragon, so in those cases we can send a balanced dragon
            return BALANCED_DRAGON;
        } else if (weather == HEAVY_RAIN) {
            // During the heavy rain fire breath is useless and claw sharpening
            // is really important
            return CLAW_DRAGON;
        } else {
            return getBestDragonAgainstKnight(knight);
        }
    }

    private static Dragon getBestDragonAgainstKnight(Knight knight) {
        List<Integer> skills = Arrays.asList(knight.attack(), knight.armor(), knight.agility(), knight.endurance());

        // First we need to find out which one is the knight's higher skill
        int skillIndex = IntStream
                .range(0, skills.size())
                .reduce((i, j) -> skills.get(i) > skills.get(j) ? i : j)
                .getAsInt();

        // Then we need to add 2 more points on that skill for our dragon
        skills.set(skillIndex, skills.get(skillIndex) + 2);

        // Then we need to remove 1 point for 2 other skills in our dragon
        IntStream.range(0, skills.size())
                .filter(i -> i != skillIndex && skills.get(i) > 0)
                .limit(2)
                .forEach(i -> skills.set(i, skills.get(i) - 1));

        return ImmutableDragon.builder()
                .scaleThickness(skills.get(0))
                .clawSharpness(skills.get(1))
                .wingStrength(skills.get(2))
                .fireBreath(skills.get(3))
                .build();
    }

}
