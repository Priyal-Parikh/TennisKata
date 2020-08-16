package com.bnpp.kata;

import com.bnpp.kata.model.TennisPlayer;

import java.util.Scanner;

public class PlayTennisGame {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        TennisGame tennisGame = initializeGame(scanner);
        startGame(scanner, tennisGame);
        scanner.close();
    }

    private static void startGame(Scanner scanner, TennisGame tennisGame) {
        boolean isGameOver = false;
        System.out.println("Let's start the game "+tennisGame.getPlayerOne().getName()+"and "+tennisGame.getPlayerTwo().getName()+" !!!");
        System.out.println("***************************************************");
        System.out.println("Current Score :"+tennisGame.determineScore());
        System.out.println("***************************************************");
        while (!isGameOver) {
            System.out.print("Next point scored by " + tennisGame.getPlayerOne().getName() + " or "
                    + tennisGame.getPlayerTwo().getName() + "? :");
            String pointScoredByPlayer = scanner.nextLine();
            if (pointScoredByPlayer != null && (pointScoredByPlayer.equalsIgnoreCase(tennisGame.getPlayerOne().getName()) || pointScoredByPlayer.equalsIgnoreCase(tennisGame.getPlayerTwo().getName()))) {
                tennisGame.scoresPoint(pointScoredByPlayer);
                String score = tennisGame.determineScore();
                System.out.println("***************************************************");
                System.out.println("Current Score :"+score);
                System.out.println("***************************************************");
                isGameOver = score.contains("wins");
            } else {
                System.out.println("Invalid Player Name!!!!");
            }
        }
        System.out.println("Game over!");
    }

    private static TennisGame initializeGame(Scanner scanner)
    {
        String playerOneName;
        String playerTwoName;

        while (true)
        {
            System.out.print("Enter Player 1 Name: ");
            playerOneName = scanner.nextLine();
            System.out.print("Enter Player 2 Name: ");
            playerTwoName = scanner.nextLine();

            if (!playerOneName.equalsIgnoreCase(playerTwoName))
            {
                break;
            }

            System.out.println("Both player names must be different!!!");
        }
        return new TennisGame(new TennisPlayer(playerOneName), new TennisPlayer(playerTwoName));
    }
}
