package dicegame;

public class Rules {

	// Returns true if you hit a pair
	public static boolean evalEqual(DiceCup cup) {
		return (cup.getD1().getFaceValue() == cup.getD2().getFaceValue());
	}

	// Returns true if you hit two 1's
	public static boolean evalTwoOnes(DiceCup cup) {
		return (cup.getD1().getFaceValue() == 1 && cup.getD2().getFaceValue() == 1);
	}

	// Returns true if you hit two 6's in a row
	public static boolean evalTwoSixesInRow(DiceCup cup) {
		boolean a = cup.getD1().getFaceValue() == 6 && cup.getD2().getFaceValue() == 6;
		boolean b = cup.getD1().getLastFaceValue() == 6 && cup.getD2().getLastFaceValue() == 6;
		return a && b;
	}

	// Returns true if you have 40 points or more
	public static boolean evalFourty(Player name) {
		return name.getPoints() >= 40;
	}

}
