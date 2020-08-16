package com.bnpp.kata;

import com.bnpp.kata.model.TennisPlayer;
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
        tennisGame.scoresPoint(PLAYER_ONE_NAME);

        Assert.assertEquals("Fifteen-Love", tennisGame.determineScore());
    }

    @Test
    public void shouldReturnFifteenAllWhenScoreIsFifteenAll() {
        tennisGame.scoresPoint(PLAYER_ONE_NAME);
        tennisGame.scoresPoint(PLAYER_TWO_NAME);

        Assert.assertEquals("Fifteen-All", tennisGame.determineScore());
    }
}
