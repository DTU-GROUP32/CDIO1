package DiceGame;

import DiceGame.*;

import java.util.Scanner;

/**
 *
 */
public class GameBoard {
    Player winner = null;
    Player[] players = new Player[2];

    public GameBoard() {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < players.length; i++) {
            System.out.printf("Indtast spillernavn: ");
            String name = input.next();
            players[i] = new Player(name);
        }
    }

    public void GameLoop() {
        while (this.winner == null) {
            for (int i = 0; i < this.players.length; i++) {
                System.out.println("\n" + players[i].getName() + "'s tur");
                waitForEnter();
                this.startTurn(this.players[i]);
                if (Rules.evalTwoOnes(this.players[i].dicecup)) {
                    System.out.println("Der blev slået to 1'ere. Score nulstillet");
                    this.players[i].setPoints(0);
                }
                if (Rules.evalTwoSixesInRow(this.players[i].dicecup)) {
                    System.out.println(players[i].getName() + " vandt");
                    System.out.println("vundet ved 2 6'ere i træk");
                    winner = this.players[i];
                    break;
                }
                if (Rules.evalFourty(this.players[i]) && Rules.evalEqual(this.players[i].dicecup)) {
                    System.out.println(players[i].getName() + " vandt");
                    System.out.println("Vundet ved " + players[i].getPoints() +" point og to ens terninger");
                    winner = this.players[i];
                    break;
                }
                System.out.println(this.players[i].getName() + " har " + this.players[i].getPoints() + " Point\n");

                if (Rules.evalEqual(this.players[i].dicecup)) {
                    System.out.println(players[i].getName() + " Slog to ens. ekstratur!");
                    i--;
                }
            }
        }
    }

    private void startTurn(Player player) {
        player.dicecup.throwDices();
        System.out.printf(player.getName() + " slog en " + player.dicecup.getDices()[0].getFaceValue() + "'er og en " + player.dicecup.getDices()[1].getFaceValue() + "'er\n");
        player.addPoints(player.dicecup.getRoundScore());
    }

    public static void waitForEnter() {
        System.out.printf("Tryk ENTER for at fortsætte.");
        // Init scanner
        Scanner keyboard = new Scanner(System.in);
        // Wait for double and print error message until double is received
        while (!keyboard.hasNextLine()) {
            keyboard.next();
        }
        keyboard.nextLine();
    }

    /**
     * @param message
     * @return
     */
    public static int getInputInt(String message) {
        // Init scanner
        Scanner scanner = new Scanner(System.in);
        // Print message-argument to console
        System.out.printf(message);
        // Wait for double and print error message until double is received
        while (!scanner.hasNextInt()) {
            System.out.println("Not a valid input. Make sure you type an integer");
            System.out.printf(message);
            scanner.next();
        }
        int input = scanner.nextInt();
        scanner.close();
        // Return user input
        return input;
    }
}
