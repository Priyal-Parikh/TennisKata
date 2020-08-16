package com.bnpp.kata;

import com.bnpp.kata.constant.Constants;
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
            playerOne.setPoint(playerOne.getPoint() + Constants.POINT_ONE);
        } else if (pointWinner.equalsIgnoreCase(playerTwo.getName())) {
            playerTwo.setPoint(playerTwo.getPoint() + Constants.POINT_ONE);
        }
    }

    public String determineScore() {
        String playerOneScoreInWord = convertScore(playerOne.getPoint());
        String playerTwoScoreInWord = convertScore(playerTwo.getPoint());

        if (playerOneScoreInWord != null && playerOneScoreInWord.equalsIgnoreCase(playerTwoScoreInWord)) {
            return playerOneScoreInWord + Constants.SCORE_SEPARATOR + Constants.TEXT_ALL;
        } else {
            return playerOneScoreInWord + Constants.SCORE_SEPARATOR + playerTwoScoreInWord;
        }
    }

    private String convertScore(int point) {
        String pointForScoreCard = null;
        if (point == Constants.POINT_ZERO) {
            pointForScoreCard = Constants.TEXT_LOVE;
        } else if (point == Constants.POINT_ONE) {
            pointForScoreCard = Constants.TEXT_FIFTEEN;
        }else if (point == Constants.POINT_TWO) {
            pointForScoreCard = Constants.TEXT_THIRTY;
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
