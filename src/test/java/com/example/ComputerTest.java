package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;

import java.util.List;
import java.util.Random;

public class ComputerTest {

    // Test Computer player name retrieval
    @Test
    public void testGetName() {
        Computer player = new Computer("Computer", "O");
        assertEquals("Computer", player.getName());
    }

    // Test Computer player symbol retrieval
    @Test
    public void testGetSymbol() {
        Computer player = new Computer("Computer", "O");
        assertEquals("O", player.getSymbol());
    }

    // Test makeMove with mocked random selection
    @Test
    public void testMakeMove() {
        // Mocking Random object to control its behavior
        Random mockRandom = Mockito.mock(Random.class);

        // Mock the random number generator to always return column 2
        Mockito.when(mockRandom.nextInt(Mockito.anyInt())).thenReturn(2);  // Always return 2 as the random column choice

        // Creating the Computer player and injecting the mocked Random object
        Computer computer = new Computer("Computer", "O");
        computer.setRandom(mockRandom);  // Assuming you have a setter or constructor to inject Random

        Board board = new Board(6, 7);

        // Calling the makeMove() method, which now uses the mocked Random
        int move = computer.makeMove(board);

        // Test if the move is the expected mocked value (2)
        assertEquals(2, move);  // The column should always be 2 based on our mock
    }
}
