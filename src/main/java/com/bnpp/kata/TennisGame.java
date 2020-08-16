package com.bnpp.kata;

public class TennisGame
{

    private String playerOneName;
    private String playerTwoName;
    private int playerOnePoint;

    public TennisGame(String playerOneName, String playerTwoName) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
    }

    public void playerOneScoresPoint() {
        playerOnePoint++;
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
}
