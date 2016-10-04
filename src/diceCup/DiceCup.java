package diceCup;

import dice.Dice;

public class DiceCup {

	private int roundScore;
	private Dice d1 = new Dice();
	private Dice d2 = new Dice();

	// Constructor
	public DiceCup() {
	}

	// Throws two dice and returns the sum of them
	public int throwDice() {
		getD1().roll();
		getD2().roll();
		roundScore = getD1().getFaceValue() + getD2().getFaceValue();		
		//System.out.println("Du slog en " + getD1().getFaceValue() + "'er og en " + getD2().getFaceValue() + "'er");
		return roundScore;
	}

	// Get round score (sum of the face values)
	public int getRoundScore() {
		return roundScore;
	}
	
	// Get dice 1
	public Dice getD2() {
		return d2;
	}
	
	// Get dice 2
	public Dice getD1() {
		return d1;
	}

}
