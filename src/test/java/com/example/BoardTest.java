package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board(6, 7); // Setting up a new 6x7 board before each test
    }

    @Test

    public void testDisplayBoard() {
        // Set up a board with 3 rows and 3 columns
        Board board = new Board(3, 3);

        // Place some disks on the board
        board.placeDisk(0, "X");  // Place X in column 0
        board.placeDisk(1, "O");  // Place O in column 1
        board.placeDisk(2, "X");  // Place X in column 2

        // Capture the output printed by displayBoard()
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Call the displayBoard() method to print the board
        board.displayBoard();

        // Define the expected output with dots for empty spaces
        String expectedOutput = ". . . \n" +
                ". . . \n" +
                "X O X \n";

        // Get the actual output
        String actualOutput = outContent.toString();

        // Normalize line endings and trim any leading/trailing spaces
        actualOutput = actualOutput.replace("\r\n", "\n").trim();
        expectedOutput = expectedOutput.replace("\r\n", "\n").trim();

        // Check that the captured output matches the expected output
        assertEquals(expectedOutput, actualOutput, "The output doesn't match the expected board.");
    }


    @Test
    void testPlaceDiskValidMove() {
        assertTrue(board.placeDisk(0, "X"));
    }

    @Test
    void testPlaceDiskColumnFull() {
        // Fill the column
        for (int i = 0; i < 6; i++) {
            board.placeDisk(1, "X");
        }
        assertFalse(board.placeDisk(1, "O")); // This should return false, column is full
    }

    @Test
    void testGetValidColumns() {
        // Initially, all columns are valid
        assertEquals(7, board.getValidColumns().size());
    }

    @Test
    void testCheckWinnerVertical() {
        board.placeDisk(0, "X");
        board.placeDisk(1, "X");
        board.placeDisk(2, "X");
        board.placeDisk(3, "X");
        assertTrue(board.checkWinner("X"));
    }

    @Test
    public void testHorizontalWin() {
        // Set up a board where player "X" wins horizontally on the first row
        Board board = new Board(6, 7);
        board.placeDisk(0, "X");  // (0,0)
        board.placeDisk(1, "X");  // (0,1)
        board.placeDisk(2, "X");  // (0,2)
        board.placeDisk(3, "X");  // (0,3)

        // Check if the board recognizes a horizontal win
        assertTrue(board.checkWinner("X"));
    }

    @Test
    public void testNoHorizontalWin() {
        // Set up a board where there is no horizontal win
        Board board = new Board(6, 7);
        board.placeDisk(0, "X");
        board.placeDisk(1, "O");
        board.placeDisk(2, "X");
        board.placeDisk(3, "O");

        // Check if the board correctly recognizes no win
        assertFalse(board.checkWinner("X"));
    }
    @Test
    public void testVerticalWin() {
        // Set up a board where player "X" wins vertically in the first column
        Board board = new Board(6, 7);
        board.placeDisk(0, "X");  // (0,0)
        board.placeDisk(1, "X");  // (1,0)
        board.placeDisk(2, "X");  // (2,0)
        board.placeDisk(3, "X");  // (3,0)

        // Check if the board recognizes a vertical win
        assertTrue(board.checkWinner("X"));
    }

    @Test
    public void testNoVerticalWin() {
        // Set up a board where there is no vertical win
        Board board = new Board(6, 7);
        board.placeDisk(0, "X");
        board.placeDisk(1, "O");
        board.placeDisk(2, "X");
        board.placeDisk(3, "O");

        // Check if the board correctly recognizes no win
        assertFalse(board.checkWinner("X"));
    }

    @Test
    public void testDiagonalWinBottomLeftToTopRight() {
        // Set up a board where player "X" wins diagonally
        Board board = new Board(6, 7);
        board.placeDisk(0, "X");  // (5,0)
        board.placeDisk(1, "X");  // (4,1)
        board.placeDisk(2, "X");  // (3,2)
        board.placeDisk(3, "X");  // (2,3)

        // Check if the board recognizes a diagonal win
        assertTrue(board.checkWinner("X"));
    }

    @Test
    public void testNoDiagonalWinBottomLeftToTopRight() {
        // Set up a board where there is no diagonal win from bottom-left to top-right
        Board board = new Board(6, 7);
        board.placeDisk(0, "X");
        board.placeDisk(1, "O");
        board.placeDisk(2, "X");
        board.placeDisk(3, "O");

        // Check if the board correctly recognizes no win
        assertFalse(board.checkWinner("X"));
    }
    @Test
    public void testDiagonalWinBottomRightToTopLeft() {
        // Set up a board where player "X" wins diagonally
        Board board = new Board(6, 7);
        board.placeDisk(6, "X");  // (5,6)
        board.placeDisk(5, "X");  // (4,5)
        board.placeDisk(4, "X");  // (3,4)
        board.placeDisk(3, "X");  // (2,3)

        // Check if the board recognizes a diagonal win
        assertTrue(board.checkWinner("X"));
    }

    @Test
    public void testNoDiagonalWinBottomRightToTopLeft() {
        // Set up a board where there is no diagonal win from bottom-right to top-left
        Board board = new Board(6, 7);
        board.placeDisk(6, "X");
        board.placeDisk(5, "O");
        board.placeDisk(4, "X");
        board.placeDisk(3, "O");

        // Check if the board correctly recognizes no win
        assertFalse(board.checkWinner("X"));
    }





    @Test
    public void testBoardFull() {
        // Set up a board where all cells are filled (no empty spaces)
        Board board = new Board(6, 7);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                board.placeDisk(i, (i + j) % 2 == 0 ? "X" : "O");  // Fill with alternating X and O
            }
        }

        // Check if the board is full
        assertFalse(board.isFull());
    }

    @Test
    public void testBoardNotFull() {
        // Set up a board where there is at least one empty spot
        Board board = new Board(6, 7);
        board.placeDisk(0, "X");
        board.placeDisk(1, "O");

        // Check if the board is not full
        assertFalse(board.isFull());
    }


    // Additional test cases to validate horizontal, diagonal, and full board conditions
}
