package com.bnpp.kata;

import org.junit.Assert;
import org.junit.Test;

public class TennisGameTest
{
    @Test
    public void shouldInitializeNewTennisGameWithTwoPlayers()
    {
        TennisGame tennisGame = new TennisGame("Serena Williams", "Maria Sharapova");

        Assert.assertEquals("Serena Williams", tennisGame.getPlayerOneName());
        Assert.assertEquals("Maria Sharapova", tennisGame.getPlayerTwoName());
    }

    @Test
    public void playerOneScoreIncreasesAfterWinningAPoint() {
        TennisGame tennisGame = new TennisGame("Serena Williams", "Maria Sharapova");
        tennisGame.playerOneScoresPoint();
        Assert.assertEquals(1, tennisGame.getPlayerOnePoint());
    }
}
