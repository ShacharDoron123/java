
public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Tournament tournament = new Tournament(10);
        tournament.startTournament();
        tournament.printResults();
    }
}
