package com.martin.basics;

import java.util.Random;
import java.util.Scanner;

public class ScrapsGameApp {

	private static Random random = new Random();

	private enum Status {
		CONTINUE, WON, LOST
	};

	public static void main(String[] args) {

		gameSracps();

	}

	public static void gameSracps() {
		System.out.println("For first roll hit enter.");
		Scanner sc = new Scanner(System.in);
		Status gameStatus; //must not be initialized - gameStatus get value in every branch of switch case 
		int myPoint = 0; //must be initialized - myPoint get value only in default branch of switch case

		sc.nextLine();

		// first roll dice
		int sum = rollDiceSum();

		switch (sum) {
		case 7:
		case 11:
			gameStatus = Status.WON;
			break;
		case 2:
		case 3:
		case 12:
			gameStatus = Status.LOST;
		default:
			gameStatus = Status.CONTINUE;
			myPoint = sum;
			System.out.println("Your point is " + sum + ". You must roll it to win.");
			break;
		}

		while (gameStatus == Status.CONTINUE) {
			System.out.println("For next roll hit enter.");
			sc.nextLine();
			sum = rollDiceSum();

			if (sum == myPoint) {
				gameStatus = Status.WON;
			} else if (sum == 7) {
				gameStatus = Status.LOST;
			}
		}

		if (gameStatus == Status.WON) {
			System.out.println("You win");
		} else {
			System.out.println("You lose");
		}

	}

	public static int getRandomNumber() {
		return 1 + random.nextInt(6);
	}

	public static int rollDiceSum() {
		int value1 = getRandomNumber();
		int value2 = getRandomNumber();
		int sum = value1 + value2;

		System.out.println("Player rolled " + value1 + " + " + value2 + " = " + sum);

		return sum;
	}

}
