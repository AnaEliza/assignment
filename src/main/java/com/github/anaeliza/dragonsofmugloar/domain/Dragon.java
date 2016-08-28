package com.github.anaeliza.dragonsofmugloar.domain;

public final class Dragon {

	private int scaleThickness;
	private int clawSharpness;
	private int wingStrength;
	private int fireBreath;

	public Dragon(int scaleThickness, int clawSharpness, int wingStrength, int fireBreath) {
		this.scaleThickness = scaleThickness;
		this.clawSharpness = clawSharpness;
		this.wingStrength = wingStrength;
		this.fireBreath = fireBreath;
	}

	public int getScaleThickness() {
		return scaleThickness;
	}

	public int getClawSharpness() {
		return clawSharpness;
	}

	public int getWingStrength() {
		return wingStrength;
	}

	public int getFireBreath() {
		return fireBreath;
	}

	@Override
	public String toString() {
		return "Dragon [Scale Thickness: " + scaleThickness + ", Claw Sharpness : " + clawSharpness
				+ ", Wing Strength: " + wingStrength + ", Fire Breath: " + fireBreath + "]";
	}
}
