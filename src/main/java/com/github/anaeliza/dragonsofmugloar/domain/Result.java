package com.github.anaeliza.dragonsofmugloar.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableResult.class)
public abstract class Result {
    
    public enum Status {
        DEFEAT, VICTORY
    }
    
    public abstract Status status();
    
    public abstract String message();
    
    @Override
    public String toString() {
        return "Result: " + status() + " (" + message() + ")";
    }
    
}
