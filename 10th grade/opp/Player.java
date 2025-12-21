package game;

import java.util.Scanner;

public class Player {
    private String name;
    private int myLuckyNumber;
    private int totalScore;
    private Scanner reader = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.myLuckyNumber = 0;
        this.totalScore = 0;
    }

    public void setMyLuckyNumber(int num) { this.myLuckyNumber = num; }

    public void playOneRound() {
        int total = 0;
        System.out.println(name + ", enter 5 numbers:");
        for (int i = 1; i <= 5; i++) {
            total += reader.nextInt();
        }
        totalScore += Math.abs(myLuckyNumber - total);
    }

    public int getTotalScore() { return totalScore; }

    @Override
    public String toString() {
        return "Player: " + name + ", Total Score: " + totalScore;
    }
}
