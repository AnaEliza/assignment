package com.github.anaeliza.dragonsofmugloar.domain;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableResult.class)
public abstract class Result {
    
    public enum Status {
        DEFEAT, VICTORY;
        
        // Waiting for https://github.com/FasterXML/jackson-databind/issues/1313
        // to get rid of this horrible piece of code :)
        @JsonCreator
        public static Status fromString(String value) {
            return Stream.of(values())
                    .filter(s -> s.name().equalsIgnoreCase(value))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Unexpected value " + value));
        }
    }
    
    public abstract Status status();
    
    public abstract String message();
    
    @Override
    public String toString() {
        return "Result: " + status() + " (" + message() + ")";
    }
    
}
