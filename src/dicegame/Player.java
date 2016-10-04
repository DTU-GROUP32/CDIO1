package dicegame;

public class Player {

	private int point = 0; // Number of points the player has
	private String name; // Name of the player

	// Constructor
	public Player(String name) {
		this.name = name;		
	}

	// Set the players points
	public void setPoints(int point) {
		this.point = point;
	}

	// Get the players points
	public int getPoints() {
		return this.point;
	}

	// Add points to the player
	public int addPoints(int point) {
		this.point += point;
		return this.point;
	}

	// Default toString method, returns name of the player
	public String toString() {
		return name;
	}

}
