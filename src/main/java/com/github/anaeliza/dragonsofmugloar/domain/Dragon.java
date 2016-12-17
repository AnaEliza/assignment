package com.github.anaeliza.dragonsofmugloar.domain;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableDragon.class)
@JsonRootName("dragon")
public abstract class Dragon {
    
    public abstract int scaleThickness();
    
    public abstract int clawSharpness();
    
    public abstract int wingStrength();
    
    public abstract int fireBreath();
    
    @Override
    public String toString() {
        return "Dragon [Scale Thickness: " + scaleThickness() + ", Claw Sharpness : " + clawSharpness()
                + ", Wing Strength: " + wingStrength() + ", Fire Breath: " + fireBreath() + "]";
    }
}
