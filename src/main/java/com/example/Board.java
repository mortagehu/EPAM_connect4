package com.example;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int rows;
    private final int columns;
    private final String[][] grid;

    public Board(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        this.grid = new String[rows][columns];
    }


    public void displayBoard(){
        for (int i = rows -1; i >= 0; i--){
            for(int j = 0; j < columns; j++){
                System.out.println(grid[i][j] == null ? ".": grid[i][j].charAt(0));
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    //TODO columnToIndex-et implementálni


    public boolean placeDisk(String column, String color){
        int colIndex = columnToIndex(column);
        if (colIndex == -1 || colIndex >= columns){
            return false; // érvéntelen oszlop
        }

        for (int i = 0; i < rows; i++){
            if (grid[i][colIndex] == null){
                grid[i][colIndex] = color;
                return true; //Ha sikerült elhelyezni egy disket
            }
        }
        return false; //Ha tele van a column
    }

    public List<String> getValidColumns(){
        List<String> validColumns = new ArrayList<>();
        for (int col = 0; col < columns; col++){
            if (grid[rows - 1][col] == null){
                validColumns.add(indexToColumn(col));
            }
        }
        return validColumns;
    }

    private int columnToIndex(String column){
        return column.toLowerCase().charAt(0)- 'a';
    }
    private String indexToColumn(int index) {
        return String.valueOf((char) ('a' + index));
    }
    public boolean checkWinner(String color){
        return checkVertical(color) || checkHorizontal(color) || checkDiagonal(color);
    }
}
