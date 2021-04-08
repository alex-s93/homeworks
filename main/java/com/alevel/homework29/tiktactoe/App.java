package com.alevel.homework29.tiktactoe;

import com.alevel.homework29.tiktactoe.utils.BoardChecker;
import com.alevel.homework29.tiktactoe.utils.CombinationValidator;
import com.alevel.homework29.tiktactoe.utils.ConsoleHelper;
import com.alevel.homework29.tiktactoe.entity.Board;
import com.alevel.homework29.tiktactoe.utils.BoardPresenter;
import com.alevel.homework29.tiktactoe.entity.Player;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ConsoleHelper consoleHelper = new ConsoleHelper();
        Board board = new Board(consoleHelper.getBoardSize());
        BoardPresenter boardPresenter = new BoardPresenter(board);
        CombinationValidator combinationValidator = new CombinationValidator(board);
        BoardChecker boardChecker = new BoardChecker(board);

        ArrayList<Player> players = new ArrayList<>();
        Player A = new Player("A", "x");
        Player B = new Player("B", "o");
        players.add(A);
        players.add(B);
        consoleHelper.setPlayers(players);
        consoleHelper.setCurrentPlayer();

        consoleHelper.printHelpMessage();

        while (boardChecker.isEmptySpotsExist()) {
            boardPresenter.displayBoard();
            consoleHelper.printPlayerMessage();
            ArrayList<Integer> coordinates = consoleHelper.getTurnValue();
            if (!boardChecker.isCoordinateExist(coordinates)) {
                consoleHelper.printOutOfBoundsMessage();
                continue;
            }
            if (!boardChecker.isSpotFree(coordinates)) {
                consoleHelper.printBusySpotMessage();
                continue;
            }
            board.setSpotByIndexes(coordinates, consoleHelper.getCurrentPlayer().getSymbol());
            if (combinationValidator.isCompletedCombination()) {
                consoleHelper.printWinMessage();
                boardPresenter.displayBoard();
                break;
            }
            consoleHelper.setCurrentPlayer();
        }

        if (!combinationValidator.isCompletedCombination()) {
            consoleHelper.printDrawMessage();
            boardPresenter.displayBoard();
        }

    }
}
