package com.bnpp.kata;

public class TennisGame
{

    private String playerOneName;
    private String playerTwoName;
    private int playerOnePoint;
    private int playerTwoPoint;

    public TennisGame(String playerOneName, String playerTwoName) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
    }

    public void playerOneScoresPoint() {
        playerOnePoint++;
    }

    public void playerTwoScoresPoint() {
        playerTwoPoint++;
    }

    public String determineScore() {
        return "Love-All";
    }

    public String getPlayerOneName() {
        return playerOneName;
    }

    public String getPlayerTwoName() {
        return playerTwoName;
    }

    public int getPlayerOnePoint() {
        return playerOnePoint;
    }

    public int getPlayerTwoPoint() {
        return playerTwoPoint;
    }
}
