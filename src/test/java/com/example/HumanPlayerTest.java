package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Scanner;

public class HumanPlayerTest {


    @Test
    public void testGetName() {
        HumanPlayer player = new HumanPlayer("Player 1", "X", new Scanner(System.in));
        assertEquals("Player 1", player.getName());
    }


    @Test
    public void testGetSymbol() {
        HumanPlayer player = new HumanPlayer("Player 1", "X", new Scanner(System.in));
        assertEquals("X", player.getSymbol());
    }


    @Test
    public void testMakeMove() {

        Scanner mockScanner = mock(Scanner.class);


        when(mockScanner.nextInt()).thenReturn(3);


        Board board = new Board(6, 7);
        HumanPlayer player = new HumanPlayer("Player 1", "X", mockScanner);


        int move = player.makeMove(board);


        assertEquals(3, move);
    }
}
