package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HumanPlayerTest {

    // Test HumanPlayer name retrieval
    @Test
    public void testGetName() {
        HumanPlayer player = new HumanPlayer("Player 1", "X");
        assertEquals("Player 1", player.getName());
    }

    // Test HumanPlayer symbol retrieval
    @Test
    public void testGetSymbol() {
        HumanPlayer player = new HumanPlayer("Player 1", "X");
        assertEquals("X", player.getSymbol());
    }

    // Test HumanPlayer makeMove (mocking user input)
    @Test
    public void testMakeMove() {
        // Assuming makeMove asks for input, we'll need to test this functionality.
        // For simplicity, let's assume it returns a column index directly.
        Board board = new Board(6, 7);
        HumanPlayer player = new HumanPlayer("Player 1", "X");

        // In a real-world scenario, you'd use mocking (e.g., Mockito) for the Scanner input.
        // Here we'll test if the player can make a valid move
        assertTrue(player.makeMove(board) >= 0); // Assume valid move logic in makeMove
    }
}
