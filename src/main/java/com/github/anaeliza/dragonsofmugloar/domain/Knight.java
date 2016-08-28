package com.github.anaeliza.dragonsofmugloar.domain;

public final class Knight {

	private String name;
	private int attack;
	private int armor;
	private int agility;
	private int endurance;

	public Knight() {

	}

	public Knight(String name, int attack, int armor, int agility, int endurance) {
		this.name = name;
		this.attack = attack;
		this.armor = armor;
		this.agility = agility;
		this.endurance = endurance;
	}

	public String getName() {
		return name;
	}

	public int getAttack() {
		return attack;
	}

	public int getArmor() {
		return armor;
	}

	public int getAgility() {
		return agility;
	}

	public int getEndurance() {
		return endurance;
	}

	@Override
	public String toString() {
		return "Knight [Name: " + name + ", Attack: " + attack + ", Armor: " + armor + ", Agility: " + agility
				+ ", Endurance: " + endurance + "]";
	}

}
