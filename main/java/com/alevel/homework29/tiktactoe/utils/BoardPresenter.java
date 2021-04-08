package com.alevel.homework29.tiktactoe.utils;

import com.alevel.homework29.tiktactoe.entity.Board;

public class BoardPresenter {
    private Board board;

    public BoardPresenter(Board board) {
        this.board = board;
    }

    public void displayBoard() {
        int boardSize = board.getSize();
        StringBuilder formattedBoard = new StringBuilder();
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                formattedBoard.append(" ").append(board.getSpots().get(i).get(j)).append(" ");
            }
            formattedBoard.append("\n");
        }
        System.out.print(formattedBoard);
    }
}