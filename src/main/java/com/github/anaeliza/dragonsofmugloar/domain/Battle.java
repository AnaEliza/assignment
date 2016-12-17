package com.github.anaeliza.dragonsofmugloar.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;
import javax.annotation.Nullable;

@Value.Immutable
@JsonDeserialize(as = ImmutableBattle.class)
public abstract class Battle {
    
    public abstract int gameId();
    
    public abstract Knight knight();
    
    @Nullable
    public abstract Weather weather();
    
    @Nullable
    public abstract Dragon dragon();
    
    @Nullable
    public abstract Result result();
    
    @Override
    public String toString() {
        return "GameId: " + gameId() + "\r\n" + weather() + "\r\n" + knight() + "\r\n" + dragon() + "\r\n" + result();
    }
    
}
