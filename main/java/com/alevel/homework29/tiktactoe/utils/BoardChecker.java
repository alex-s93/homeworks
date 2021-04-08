package com.alevel.homework29.tiktactoe.utils;

import com.alevel.homework29.tiktactoe.entity.Board;

import java.util.ArrayList;

public class BoardChecker {
    private Board board;

    public BoardChecker(Board board) {
        this.board = board;
    }

    public boolean isEmptySpotsExist() {
        for (ArrayList<String> arrayList : board.getSpots()) {
            if (arrayList.contains("*")) {
                return true;
            }
        }
        return false;
    }

    public boolean isSpotFree(ArrayList<Integer> coordinates) {
        int row = coordinates.get(0);
        int index = coordinates.get(1);

        return board.getSpots().get(row-1).get(index-1).contains("*");
    }

    public boolean isCoordinateExist(ArrayList<Integer> coordinates) {
        for (int coordinate: coordinates) {
            if (coordinate > board.getSize()) {
                return false;
            }
        }
        return true;
    }
}
