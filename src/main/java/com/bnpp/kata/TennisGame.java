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
        if(isDeuce())
        {
            return Constants.TEXT_DEUCE;
        }

        String playerOneScoreInWord = convertScore(playerOne.getPoint());
        String playerTwoScoreInWord = convertScore(playerTwo.getPoint());

        if (playerOneScoreInWord != null && playerOneScoreInWord.equalsIgnoreCase(playerTwoScoreInWord)) {
            return playerOneScoreInWord + Constants.SCORE_SEPARATOR + Constants.TEXT_ALL;
        } else {
            return playerOneScoreInWord + Constants.SCORE_SEPARATOR + playerTwoScoreInWord;
        }
    }

    private boolean isDeuce() {
        return isScoreLevels() && isAnyPlayerHasReachedForty();
    }

    private boolean isAnyPlayerHasReachedForty() {
        return playerOne.getPoint() + playerTwo.getPoint() > Constants.MIN_POINTS_FOR_DEUCE;
    }

    private boolean isScoreLevels() {
        return playerOne.getPoint() == playerTwo.getPoint();
    }

    private String convertScore(int point) {
        return Constants.SCORE_LIST[point];
    }

    public TennisPlayer getPlayerOne() {
        return playerOne;
    }

    public TennisPlayer getPlayerTwo() {
        return playerTwo;
    }
}
