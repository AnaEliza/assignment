package com.github.anaeliza.dragonsofmugloar.domain;

import java.util.stream.Stream;

public enum Weather {

	REGULAR("NMR"), 
	STORM("SRO"), 
	HEAVY_RAIN("HVA"), 
	LONG_DRY("T E"), 
	FOG("FUNDEFINEDG");

	private String code;

	private Weather(String code) {
		this.code = code;
	}

	public static Weather getByCode(String code) {
		return Stream.of(values())
				.filter(w -> w.code.equals(code))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("Unexpected code " + code));
	}
	
	@Override
	public String toString() {
		return "Weather: " + name();
	}

}
