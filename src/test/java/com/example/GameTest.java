package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void testStartGame() {
        // Mocking the dependencies
        Board mockBoard = mock(Board.class);
        Player mockPlayer1 = mock(HumanPlayer.class);
        Player mockPlayer2 = mock(Computer.class);

        // Create the game instance with the mocked objects
        Game game = new Game(mockBoard, mockPlayer1, mockPlayer2);

        // Set up the mocked methods
        when(mockBoard.isFull()).thenReturn(false);
        when(mockPlayer1.makeMove(mockBoard)).thenReturn(0);  // Player 1 makes a move
        when(mockPlayer2.makeMove(mockBoard)).thenReturn(1);  // Player 2 makes a move

        // Start the game and verify behavior
        game.start();

        // Verify interactions with mocks
        verify(mockBoard, times(1)).placeDisk(0, "X");
        verify(mockBoard, times(1)).placeDisk(1, "O");
    }
}
