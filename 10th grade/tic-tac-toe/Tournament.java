//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Tournament {
    private int numGames = 10;
    private int xWins;
    private int oWins;
    private int ties;

    public Tournament(int numGames) {
        this.numGames = numGames;
        this.xWins = 0;
        this.oWins = 0;
        this.ties = 0;
    }

    public void startTournament() {
        for(int i = 1; i <= this.numGames; ++i) {
            Game game = new Game();
            char result = game.playGame();
            if (result == 'X') {
                ++this.xWins;
            } else if (result == 'O') {
                ++this.oWins;
            } else if (result == 'T') {
                ++this.ties;
            }
        }

    }

    public void printResults() {
        System.out.println("There was = " + this.ties + " ties");
        System.out.println("There was = " + this.xWins + " 'X' wins");
        System.out.println("There was = " + this.oWins + " 'O' wins");
    }
}
