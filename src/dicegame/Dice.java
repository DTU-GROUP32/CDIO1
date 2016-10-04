package dicegame;

public class Dice {

	private static final int sides = 6; // Number of sides on the dice
	private int faceValue; // The present face value
	private int lastFaceValue; // 

	//Constructor
	public Dice() {
		roll();
	}

	// Roll dice and return the face value
	public int roll() {
		setLastFaceValue(getFaceValue());
		faceValue = (int) (Math.random() * sides) + 1;
		return faceValue;
	}

	// Get face value
	public int getFaceValue() {
		return faceValue;
	}

	// Set face value
	public int setFaceValue(int value) {
		faceValue = value;
		return faceValue;
	}

	// Get last face value
	public int getLastFaceValue() {
		return lastFaceValue;
	}

	// Set last face value
	public int setLastFaceValue(int value) {
		lastFaceValue = value;
		return lastFaceValue;
	}

	// toString method: Return face value
	public String toString() {
		return "Face Value: " + faceValue;
	}

}
