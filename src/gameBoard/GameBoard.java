package gameBoard;

import java.util.Scanner;

import diceCup.DiceCup;
import rules.Rules;
import player.Player;

public class GameBoard {

	private static boolean x = true; // Will tell if game is still going
	public static Scanner name = new Scanner(System.in); // Initialize scanner

	public static void main(String[] args) {

		// Instantiate dice cups
		DiceCup dc1 = new DiceCup();
		DiceCup dc2 = new DiceCup();

		// Welcome, and set name of the two players
		String n1, n2;
		System.out.println("Velkommen");
		System.out.println("Indtast navn på spiller 1");
		n1 = GameBoard.name.nextLine();
		System.out.println("Indtast navn på spiller 2");
		n2 = GameBoard.name.nextLine();
		System.out.println("Velkommen " + n1 + " og " + n2 + "\n");

		// Instantiate players with the given names
		Player p1 = new Player(n1);
		Player p2 = new Player(n2);

		// The game itself - gameloop
		do {
			if (x) { 
				startTurn(p1, dc1);
			} 
			if (x) {
				startTurn(p2, dc2);
			}
		} while (x);
	}

	// Constructor
	public GameBoard() {
	}

	// The ability to set 'x = false' if winning condition has been reached - game stops
	public static boolean setX(boolean x) {
		GameBoard.x = x;
		return GameBoard.x;
	}

	// Waiting for someone to hit 'Enter' to continue.
	public static void pause() {
		System.out.print("Tryk på 'Enter' for at fortsætte...");
		name.nextLine();
	}

	// Tells who's turn it is, waits for someone to press 'Enter' and then throws dice.
	public static void turn(Player p, DiceCup c) {		
		System.out.println("Det er din tur " + p);
		GameBoard.pause();
		c.throwDice();
		System.out.println("Du slog en " + c.getD1().getFaceValue() + "'er og en " + c.getD2().getFaceValue() + "'er");
	}
	
	// Throws dice for a player and evaluates the different rules
	public static void startTurn(Player p, DiceCup c) {
		turn(p,c);
		if (Rules.evalTwoOnes(c)) {
			p.setPoints(0);
			System.out.println(p + " slog to 1'ere, dine point er blevet nulstillet - du må slå igen");
			System.out.println(p + " har " + p.getPoints() + " point\n");
			turn(p,c);
		}	else if (Rules.evalFourty(p) && Rules.evalEqual(c)) {
			System.out.println(p + " slog to ens og har " + p.getPoints() + " point\n" + p + " har vundet");
			setX(false);
		} else if (Rules.evalTwoSixesInRow(c)) {
			System.out.println(p + " har slået to 6'ere og to 6'ere sidste runde\n" + p + " har vundet");
			setX(false);
		} else if (Rules.evalEqual(c)) {
			System.out.println(p + " slog to ens og får tildelt en ekstra tur");
			p.addPoints(c.getRoundScore());
			System.out.println(p + " har " + p.getPoints() + " point\n");
			turn(p,c);
		} else {
			p.addPoints(c.getRoundScore());
			System.out.println(p + " har " + p.getPoints() + " point\n");
		}
	}

}

