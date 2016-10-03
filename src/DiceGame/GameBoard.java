package DiceGame;
import DiceGame.*;

/**
 *
 */
public class GameBoard {
    Player winner = null;
    Player[] players = new Player[2];

    public GameBoard(){
        for(int i = 0; i < players.length; i++){
            players[i] = new Player();
        }
    }

    public void GameLoop(){
        while(this.winner == null){
            for(int i = 0; i < this.players.length; i++){
                this.startTurn(this.players[i]);
                if(Rules.evalTwoOnes(this.players[i].dicecup)){
                    this.players[i].setPoints(0);
                }
                if(Rules.evalTwoSixesInRow(this.players[i].dicecup)){
                    System.out.println("Win by double sixes");
                    winner = this.players[i];
                    break;
                }
                if(Rules.evalFourty(this.players[i]) && Rules.evalEqual(this.players[i].dicecup)){
                    System.out.println("Win by 40 points and equal throw");
                    winner = this.players[i];
                    break;
                }
                if (Rules.evalEqual(this.players[i].dicecup)){
                    i++;
                }
            }
        }
    }
    private void startTurn(Player player){
        player.dicecup.throwDices();
        player.addPoints(player.dicecup.getRoundScore());
        System.out.println(player.getPoints());
    }
}
