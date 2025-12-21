package game;

import java.util.Date;

public class Game {
    private Date date;
    private Player player1;
    private Player player2;

    public Game(Date date, Player p1, Player p2) {
        this.date = date;
        this.player1 = p1;
        this.player2 = p2;
    }

    public void playGame() {
        for (int i = 1; i <= 10; i++) {
            player1.playOneRound();
            player2.playOneRound();
        }
    }

    @Override
    public String toString() {
        return "Game Date: " + date + "\n" + player1 + "\n" + player2;
    }
}
