package DiceGame;

import java.lang.reflect.Array;

/**
 *
 */
public class DiceCup {
    private Dice[] dices = new Dice[5];
    public DiceCup(){
        this(2);
    }
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

    public void throwDices(){
        for (Dice dice:dices) {
            dice.Roll();
            System.out.println(dice.getFaceValue());
        }
    }
}
