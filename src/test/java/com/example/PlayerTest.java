package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    // Test for Player name retrieval
    @Test
    public void testGetName() {
        Player player = new HumanPlayer("Player 1", "X");
        assertEquals("Player 1", player.getName());
    }

    // Test for Player symbol retrieval
    @Test
    public void testGetSymbol() {
        Player player = new HumanPlayer("Player 1", "X");
        assertEquals("X", player.getSymbol());
    }
}
