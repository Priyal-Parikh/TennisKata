package com.bnpp.kata;

public class TennisGame
{

    private String playerOneName;
    private String playerTwoName;

    public TennisGame(String playerOneName, String playerTwoName) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
    }

    public String getPlayerOneName() {
        return playerOneName;
    }

    public String getPlayerTwoName() {
        return playerTwoName;
    }
}
