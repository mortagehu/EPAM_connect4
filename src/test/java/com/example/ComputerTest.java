package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComputerTest {

    @Test
    public void testMakeMove() {
        // Mock the Random object
        Random mockRandom = Mockito.mock(Random.class);

        // Configure the mock to always return index 2
        Mockito.when(mockRandom.nextInt(Mockito.anyInt())).thenReturn(2);

        // Inject the mock into the Computer instance
        Computer computer = new Computer("Computer", "O", mockRandom);

        // Initialize the board with valid columns
        Board board = new Board(6, 7);

        // Test the makeMove method
        int move = computer.makeMove(board);

        // Validate the move
        assertEquals(2, move); // Expect column index 2 based on the mock
    }

}
