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

    public void scoresPoint(String pointWinner) {
        if (pointWinner.equalsIgnoreCase(playerOne.getName())) {
            playerOne.setPoint(playerOne.getPoint() + 1);
        } else if (pointWinner.equalsIgnoreCase(playerTwo.getName())) {
            playerTwo.setPoint(playerTwo.getPoint() + 1);
        }
    }

    public String determineScore() {
        String playerOneScoreInWord = convertScore(playerOne.getPoint());
        String playerTwoScoreInWord = convertScore(playerTwo.getPoint());

        if (playerOneScoreInWord != null && playerOneScoreInWord.equalsIgnoreCase(playerTwoScoreInWord)) {
            return playerOneScoreInWord + "-" + "All";
        } else {
            return playerOneScoreInWord + "-" + playerTwoScoreInWord;
        }
    }

    private String convertScore(int point) {
        String pointForScoreCard = null;
        if (point == 0) {
            pointForScoreCard = "Love";
        } else if (point == 1) {
            pointForScoreCard = "Fifteen";
        }
        return pointForScoreCard;
    }


    public TennisPlayer getPlayerOne() {
        return playerOne;
    }

    public TennisPlayer getPlayerTwo() {
        return playerTwo;
    }
}
