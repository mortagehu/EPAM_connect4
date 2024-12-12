package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board(6, 7); // Setting up a new 6x7 board before each test
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

    // Additional test cases to validate horizontal, diagonal, and full board conditions
}
