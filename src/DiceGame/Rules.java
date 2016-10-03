package DiceGame;

import DiceGame.*;

public class Rules {
    public static boolean evalEqual(DiceCup d) {
        return (d.getDices()[0].getFaceValue() == d.getDices()[1].getFaceValue());
    }

    public static boolean evalTwoOnes(DiceCup d) {
        return (d.getDices()[0].getFaceValue() == 1 && d.getDices()[1].getFaceValue() == 1);
    }

    public static boolean evalTwoSixesInRow(DiceCup d) {
        return (d.getDices()[0].getFaceValue() == 6 &&
                d.getDices()[0].getFaceValue() == 6 &&
                d.getDices()[1].getLastValue() == 6 &&
                d.getDices()[1].getLastValue() == 6);
    }

    public static boolean evalFourty(Player p) {
        return (p.getPoints() >= 40);
    }
}
