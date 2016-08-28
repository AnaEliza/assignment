package com.github.anaeliza.dragonsofmugloar.domain;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Result {

	public enum Status {
		DEFEAT, VICTORY;
		
		@JsonCreator
		public static Status fromString(String value) {
			return Stream.of(values())
					.filter(s -> s.name().equalsIgnoreCase(value))
					.findFirst()
					.orElseThrow(() -> new IllegalArgumentException("Unexpected value " + value));
		}
	}

	private Status status;
	private String message;
	
	public Status getStatus() {
		return status;
	}
	
	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "Result: " + status + " (" + message + ")";
	}

}
