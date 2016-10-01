package DiceGame;

public class Dice {
    private int sides, faceValue;

    /**
     * Default constructor creates 6-sided dice
     */
    public Dice(){
        this(6);
    }

    /**
     * Constructor used when initializing dice with a custom side-count
     * @param setSides
     */
    public Dice(int setSides){
        this.sides = setSides;
        this.faceValue = 0;
    }

    /**
     * Returns current face value of the dice
     * @return int faceValue
     */
    public int getFaceValue(){
        return this.faceValue;
    }

    /**
     * Rolls the dice and sets value to faceValue variable
     */
    public void Roll(){
        this.faceValue = (int)Math.random()*6+1;
    }
}
