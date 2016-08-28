package com.github.anaeliza.dragonsofmugloar;

public class Main {

	public static void main(String[] args) throws Exception {
		int rounds = Integer.parseInt(args[0]);
		
		Challenge challange = new Challenge();

		for (int i = 1; i <= rounds; i++) {
			System.out.println("Round " + i);
			challange.start();
			System.out.println();
		}

		challange.printResult();
	}

}
