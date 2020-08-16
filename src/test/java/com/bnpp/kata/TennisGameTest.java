package com.bnpp.kata;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TennisGameTest
{
    public static final String PLAYER_ONE_NAME = "Serena Williams";
    public static final String PLAYER_TWO_NAME = "Maria Sharapova";
    public static final int POINT_ONE = 1;
    TennisGame tennisGame;

    @Before
    public void setUp() {
        tennisGame = new TennisGame(PLAYER_ONE_NAME, PLAYER_TWO_NAME);
    }

    @Test
    public void shouldInitializeNewTennisGameWithTwoPlayers() {
        Assert.assertEquals(PLAYER_ONE_NAME, tennisGame.getPlayerOneName());
        Assert.assertEquals(PLAYER_TWO_NAME, tennisGame.getPlayerTwoName());
    }

    @Test
    public void playerOneScoreIncreasesAfterWinningAPoint() {
        tennisGame.playerOneScoresPoint();

        Assert.assertEquals(POINT_ONE, tennisGame.getPlayerOnePoint());
    }

    @Test
    public void playerTwoScoreIncreasesAfterWinningAPoint() {
        tennisGame.playerTwoScoresPoint();

        Assert.assertEquals(POINT_ONE, tennisGame.getPlayerTwoPoint());
    }
}
