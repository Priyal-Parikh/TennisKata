package com.bnpp.kata;

import com.bnpp.kata.model.TennisPlayer;

import java.util.Scanner;

public class PlayTennisGame {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        TennisGame tennisGame = initializeGame(scanner);
        System.out.println("Let's start the game "+tennisGame.getPlayerOne().getName()+"and "+tennisGame.getPlayerTwo().getName());
        scanner.close();
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
