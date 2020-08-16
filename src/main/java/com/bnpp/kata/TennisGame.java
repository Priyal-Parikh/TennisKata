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
        if (isGameHasWinner()) {
            return determineLeadingPlayer().getName() + Constants.SCORE_SEPARATOR + Constants.TEXT_WINS;
        }

        if(isDeuce())
        {
            return Constants.TEXT_DEUCE;
        }

        if(isPlayerHasAdvantage())
        {
            TennisPlayer leadingPlayer = determineLeadingPlayer();
            return Constants.TEXT_ADVANTAGE + Constants.SCORE_SEPARATOR + leadingPlayer.getName();
        }

        return formatScore(playerOne.getPoint(), playerTwo.getPoint());
    }

    private boolean isGameHasWinner() {
        return (determineLeadingPlayer().getPoint() > Constants.POINT_THREE
                && pointDifferenceOfPlayers() > Constants.POINT_ONE);
    }

    private int pointDifferenceOfPlayers() {
        return Math.abs(playerOne.getPoint() - playerTwo.getPoint());
    }

    private static String formatScore(int playerOnePoint, int playerTwoPoint) {
        String playerOneScoreInWord = convertScore(playerOnePoint);
        String playerTwoScoreInWord = convertScore(playerTwoPoint);

        if (playerOneScoreInWord != null && playerOneScoreInWord.equalsIgnoreCase(playerTwoScoreInWord)) {
            return playerOneScoreInWord + Constants.SCORE_SEPARATOR + Constants.TEXT_ALL;
        } else {
            return playerOneScoreInWord + Constants.SCORE_SEPARATOR + playerTwoScoreInWord;
        }
    }

    private TennisPlayer determineLeadingPlayer() {
        return (playerOne.getPoint() > playerTwo.getPoint()) ? playerOne : playerTwo;
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

    private boolean isPlayerHasAdvantage() {
        return (!isScoreLevels() && isAnyPlayerHasReachedForty());
    }

    private static String convertScore(int point) {
        return Constants.SCORE_LIST[point];
    }

    public TennisPlayer getPlayerOne() {
        return playerOne;
    }

    public TennisPlayer getPlayerTwo() {
        return playerTwo;
    }
}
