package com.alevel.homework29.tiktactoe.entity;

import java.util.ArrayList;

public class Board {
    private int size;
    private ArrayList<ArrayList<String>> spots;

    public Board(int size) {
        this.size = size;
        this.spots = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ArrayList<String> row = new ArrayList<>();
            for (int j = 0; j < this.size; j++) {
                row.add("*");
            }
            spots.add(row);
        }
    }

    @Override
    public String toString() {
        return "Board{" +
                "size=" + size +
                ", spots=" + spots +
                '}';
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ArrayList<ArrayList<String>> getSpots() {
        return spots;
    }

    public void setSpotByIndexes(ArrayList<Integer> coordinates, String value) {
        int row = coordinates.get(0) - 1;
        int index = coordinates.get(1) - 1;
        ArrayList<String> newRow = spots.get(row);
        newRow.set(index, value);
        spots.set(row, newRow);
    }
}
