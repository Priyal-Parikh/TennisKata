package com.bnpp.kata;

import com.bnpp.kata.model.TennisPlayer;

public class TennisGame
{
    private TennisPlayer playerOne;
    private TennisPlayer playerTwo;

    public TennisGame(TennisPlayer playerOne, TennisPlayer playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void playerOneScoresPoint() {
        playerOne.setPoint(playerOne.getPoint()+1);
    }

    public void playerTwoScoresPoint() {
        playerTwo.setPoint(playerOne.getPoint()+1);
    }

    public String determineScore() {
        return "Love-All";
    }

    public TennisPlayer getPlayerOne() {
        return playerOne;
    }

    public TennisPlayer getPlayerTwo() {
        return playerTwo;
    }
}
