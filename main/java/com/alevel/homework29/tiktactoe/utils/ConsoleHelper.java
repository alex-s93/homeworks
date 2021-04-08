package com.alevel.homework29.tiktactoe.utils;

import com.alevel.homework29.tiktactoe.entity.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleHelper {
    private Scanner scanner = new Scanner(System.in);
    private Player currentPlayer;
    private ArrayList<Player> players;
    private boolean odd = true;

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void setCurrentPlayer() {
        if (odd) {
            this.currentPlayer = players.get(0);
            this.odd = false;
        } else {
            this.currentPlayer = players.get(1);
            this.odd = true;
        }
    }

    public int getBoardSize() {
        System.out.println("What size of board do you want to play?");
        return Integer.parseInt(scanner.nextLine());
    }

    public ArrayList<Integer> getTurnValue() {
        System.out.println("Enter row number and position number:");
        ArrayList<Integer> indexes = new ArrayList<>();
        for (String number: scanner.nextLine().trim().split(",")) {
            indexes.add(Integer.parseInt(number));
        }
        return indexes;
    }

    public void printOutOfBoundsMessage() {
        System.out.println("Coordinates are incorrect: the row number or the position number out of bounds");
    }

    public void printBusySpotMessage() {
        System.out.println("This spot already busy. Try again!");
    }

    public void printWinMessage() {
        System.out.println("Player " + currentPlayer.getName() + " win!");
    }

    public void printDrawMessage() {
        System.out.println("Draw!");
    }

    public void printPlayerMessage() {
        System.out.println("Player " + currentPlayer.getName() + " - your turn! Your symbol - '" + currentPlayer.getSymbol() + "'");
    }

    public void printHelpMessage() {
        System.out.println(
                "______________________________________________________________________________________________________________"+
                "\nHELP:\nCoordinates of the move consist of two elements: row number and position number in the row.\n" +
                "The coordinates should look like this:\n1,2\n" +
                "Where: 1 is the row number, and 2 - the position number in the row.\n" +
                "______________________________________________________________________________________________________________");
    }
}
