package DiceGame;

import java.lang.reflect.Array;

/**
 * Dicecup class
 */
public class DiceCup {
    private Dice[] dices = new Dice[5];

    /**
     * Default constructor creates cup with 2 dices
     */
    public DiceCup(){
        this(2);
    }

    /**
     * Alternate constructor allow dicecup to be created with more/less than two dices (maximum of 5)
     * @param diceCount
     */
    public DiceCup(int diceCount){
        if(diceCount>5){
            System.out.print("The cup can only hold up to 5 dices.");
            System.out.printf("Please set a new amount of dices: ");
        }
        Dice[] dices = new Dice[diceCount];
        for(int i = 0; i < diceCount; i++){
            dices[i] = new Dice();
        }
    }

    /**
     * Rolls all dices in cup
     * TODO: Fix for-loop to be indexed instead of foreach.
     */
    public void throwDices(){
        for (Dice dice:dices) {
            dice.Roll();
            System.out.println(dice.getFaceValue());
        }
    }
}
