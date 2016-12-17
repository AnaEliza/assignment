package com.github.anaeliza.dragonsofmugloar.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableKnight.class)
public abstract class Knight {
    
    public abstract String name();
    
    public abstract int attack();
    
    public abstract int armor();
    
    public abstract int agility();
    
    public abstract int endurance();
    
    @Override
    public String toString() {
        return "Knight [Name: " + name() + ", Attack: " + attack() + ", Armor: " + armor()
                + ", Agility: " + agility() + ", Endurance: " + endurance() + "]";
    }
    
}
