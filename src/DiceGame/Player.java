package DiceGame;
import DiceGame.*;

/**
 *
 */
public class Player {
    private String name;
    public DiceCup dicecup;
    private int points = 0;

    /**
     *
     */
    public Player(){
        this.dicecup = new DiceCup();
    }
    public Player(String playerName){
        this.name = playerName;
        this.dicecup = new DiceCup();
    }

    /**
     *
     * @return
     */
    public String getName(){
        return this.name;
    }

    /**
     *
     * @param playerName
     */
    public void setName(String playerName){
        this.name = playerName;
    }

    /**
     *
     * @param point
     */
    public void addPoints(int point){
        this.points += point;
    }

    /**
     *
     * @return int points
     */
    public int getPoints(){
        return this.points;
    }

    /**
     *
     * @param p
     */
    public void setPoints(int p){
        this.points = p;
    }
}
