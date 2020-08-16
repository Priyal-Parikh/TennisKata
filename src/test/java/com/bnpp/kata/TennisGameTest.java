package com.bnpp.kata;

import com.bnpp.kata.constant.Constants;
import com.bnpp.kata.model.TennisPlayer;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class TennisGameTest
{
    public static final String PLAYER_ONE_NAME = "Serena Williams";
    public static final String PLAYER_TWO_NAME = "Maria Sharapova";
    public static final int POINT_ONE = 1;
    TennisGame tennisGame;

    @Before
    public void setUp() {
        tennisGame = new TennisGame(new TennisPlayer(PLAYER_ONE_NAME), new TennisPlayer(PLAYER_TWO_NAME));
    }

    @Test
    public void shouldInitializeNewTennisGameWithTwoPlayers() {
        Assert.assertEquals(PLAYER_ONE_NAME, tennisGame.getPlayerOne().getName());
        Assert.assertEquals(PLAYER_TWO_NAME, tennisGame.getPlayerTwo().getName());
    }

    @Test
    public void playerOneScoreIncreasesAfterWinningAPoint() {
        tennisGame.scoresPoint(PLAYER_ONE_NAME);

        Assert.assertEquals(POINT_ONE, tennisGame.getPlayerOne().getPoint());
    }

    @Test
    public void playerTwoScoreIncreasesAfterWinningAPoint() {
        tennisGame.scoresPoint(PLAYER_TWO_NAME);

        Assert.assertEquals(POINT_ONE, tennisGame.getPlayerTwo().getPoint());
    }

    @Test
    public void shouldReturnLoveAllWhenGameStarts() {
        Assert.assertEquals("Love-All", tennisGame.determineScore());
    }

    @Test
    public void shouldReturnFifteenLoveWhenFirstPlayerScoresAPoint() {
        createScore(POINT_ONE, Constants.POINT_ZERO);

        Assert.assertEquals("Fifteen-Love", tennisGame.determineScore());
    }

    @Test
    public void shouldReturnFifteenAllWhenScoreIsFifteenAll() {
        createScore(POINT_ONE,POINT_ONE);

        Assert.assertEquals("Fifteen-All", tennisGame.determineScore());
    }

    @Test
    public void shouldReturnFifteenThirtyWhenScoreIsFifteenThirty() {
        createScore(POINT_ONE,Constants.POINT_TWO);

        Assert.assertEquals("Fifteen-Thirty", tennisGame.determineScore());
    }

    @Test
    @Parameters({
            "0, 0, Love-All",
            "1, 0, Fifteen-Love",
            "0, 1, Love-Fifteen",
            "1, 1, Fifteen-All",
            "2, 0, Thirty-Love",
            "2, 1, Thirty-Fifteen",
            "2, 2, Thirty-All",
            "0, 2, Love-Thirty",
            "1, 2, Fifteen-Thirty"
    })
    public void shouldReturnScoreInFormatBasedOnThePointsScored(int playerOnePoint, int playerTwoPoint,
                                                                String gameScore) {
        createScore(playerOnePoint, playerTwoPoint);

        Assert.assertEquals(gameScore, tennisGame.determineScore());
    }

    private void createScore(int playerOnePoint,int playerTwoPoint) {
        for(int pointCounter=0;pointCounter<playerOnePoint;pointCounter++)
        {
            tennisGame.scoresPoint(PLAYER_ONE_NAME);
        }
        for(int pointCounter=0;pointCounter<playerTwoPoint;pointCounter++)
        {
            tennisGame.scoresPoint(PLAYER_TWO_NAME);
        }
    }
}
