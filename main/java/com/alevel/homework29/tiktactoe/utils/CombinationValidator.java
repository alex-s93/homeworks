package com.alevel.homework29.tiktactoe.utils;

import com.alevel.homework29.tiktactoe.entity.Board;

import java.util.ArrayList;

public class CombinationValidator {
    private Board board;

    public CombinationValidator(Board board) {
        this.board = board;
    }

    public boolean isCompletedCombination() {
        ArrayList<ArrayList<String>> spots = board.getSpots();
        return isSpotsHaveRowCombination(spots) || isSpotsHaveColumnCombination(spots) || isSpotsHaveDiagonalCombination(spots);
    }

    private boolean isSpotsHaveRowCombination(ArrayList<ArrayList<String>> spots) {
        for (ArrayList<String> row : spots) {
            if (isConditionCompleted(row)) {
                return true;
            }
        }
        return false;
    }

    private boolean isConditionCompleted(ArrayList<String> arrayList) {
        if (!arrayList.contains("*")) {
            String firstElement = arrayList.get(0);
            for (int i = 1; i < arrayList.size(); i++) {
                if (!arrayList.get(i).equals(firstElement)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private boolean isSpotsHaveColumnCombination(ArrayList<ArrayList<String>> spots) {
        for (int i = 0; i < spots.size(); i++) {
            ArrayList<String> column = new ArrayList<>();
            for (ArrayList<String> spot : spots) {
                column.add(spot.get(i));
            }
            if (isConditionCompleted(column)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSpotsHaveDiagonalCombination(ArrayList<ArrayList<String>> spots) {
        int spotsSize = spots.size();

        ArrayList<String> diagonal = new ArrayList<>();
        for (int i = 0; i < spotsSize; i++) {
            diagonal.add(spots.get(i).get(i));
        }

        ArrayList<String> reverseDiagonal = new ArrayList<>();
        for (int i = 0; i < spotsSize; i++) {
            reverseDiagonal.add(spots.get(i).get(spotsSize - 1 - i));
        }

        return isConditionCompleted(diagonal) || isConditionCompleted(reverseDiagonal);
    }
}
