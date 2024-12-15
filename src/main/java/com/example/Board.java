package com.example;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int rows; // Number of rows
    private final int columns; // Number of columns
    private final String[][] grid;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.grid = new String[rows][columns];
    }

    public void displayBoard() {
        // Print the game board to the console
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = 0; j < columns; j++) {
                System.out.print(grid[i][j] == null ? "." : grid[i][j].charAt(0)); // Print first character of the color
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean placeDisk(int column, String symbol) {
        if (column < 0 || column >= columns) {
            System.out.println("Invalid column: " + column);  // Debugging output
            return false; // Invalid column
        }

        // Find the first empty row in the column and place the disk
        for (int i = 0; i < rows; i++) {
            if (grid[i][column] == null) {
                grid[i][column] = symbol;
                return true; // Successful placement
            }
        }
        return false; // The column is full
    }

    public List<Integer> getValidColumns() {
        List<Integer> validColumns = new ArrayList<>();
        for (int col = 0; col < columns; col++) {
            // Check if the top row (row 0) of this column is empty
            if (grid[rows - 1][col] == null) {
                validColumns.add(col); // Add this column index to the valid columns list
            }
        }
        return validColumns;
    }

    public boolean checkWinner(String symbol) {
        // Check for a winner (vertical, horizontal, diagonal)
        return checkVertical(symbol) || checkHorizontal(symbol) || checkDiagonal(symbol);
    }

    private boolean checkVertical(String color) {
        for (int col = 0; col < columns; col++) {
            int count = 0;
            for (int row = 0; row < rows; row++) {
                if (color.equals(grid[row][col])) {
                    count++;
                    if (count == 4) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        return false;
    }

    private boolean checkHorizontal(String color) {
        for (int row = 0; row < rows; row++) {
            int count = 0;
            for (int col = 0; col < columns; col++) {
                if (color.equals(grid[row][col])) {
                    count++;
                    if (count == 4) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        return false;
    }

    public boolean checkDiagonal(String color) {
        // Left-to-right diagonal check
        for (int row = 0; row < rows - 3; row++) {
            for (int col = 0; col < columns - 3; col++) {
                if (color.equals(grid[row][col]) &&
                        color.equals(grid[row + 1][col + 1]) &&
                        color.equals(grid[row + 2][col + 2]) &&
                        color.equals(grid[row + 3][col + 3])) {
                    return true;
                }
            }
        }

        // Right-to-left diagonal check
        for (int row = 0; row < rows - 3; row++) {
            for (int col = 3; col < columns; col++) {
                if (color.equals(grid[row][col]) &&
                        color.equals(grid[row + 1][col - 1]) &&
                        color.equals(grid[row + 2][col - 2]) &&
                        color.equals(grid[row + 3][col - 3])) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isFull() {
        // Check if the board is full (when there are no empty spaces in the top row)
        for (int col = 0; col < columns; col++) {
            if (grid[0][col] == null) { // Check if any position in the top row is empty
                return false;
            }
        }
        return true;
    }


}
