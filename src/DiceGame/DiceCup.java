package DiceGame;

import java.lang.reflect.Array;

/**
 * Dicecup class
 */
public class DiceCup {
    private Dice[] dices = new Dice[2];
    private int roundScore;

    /**
     * constructor allow dicecup to be created with more/less than two dices (maximum of 5)
     */
    public DiceCup(){
        for(int i = 0; i < dices.length; i++){
            dices[i] = new Dice();
        }
    }

    /**
     * Rolls all dices in cup
     * TODO: Fix for-loop to be indexed instead of foreach.
     */
    public void throwDices(){
        int tempRoundScore = 0;
        for (int i = 0; i < this.dices.length; i++) {
            this.dices[i].Roll();
            tempRoundScore += this.dices[i].getFaceValue();
        }
        this.roundScore = tempRoundScore;
    }

    /**
     * Returns dice object-list from dices in cup
     * @return Dice dices
     */
    public Dice[] getDices(){
        return this.dices;
    }

    public int getRoundScore(){
        return this.roundScore;
    }
}
