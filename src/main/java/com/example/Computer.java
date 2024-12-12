package com.example;

import java.util.List;
import java.util.Random;

public class Computer extends Player {
    private final Random random;

    // Konstruktor
    public Computer(String name, String symbol) {
        super(name, symbol);
        this.random = new Random();
    }

    // Absztrakt metódus implementációja
    @Override
    public int makeMove(Board board) {
        List<Integer> validColumns = board.getValidColumns();
        Random random = new Random(); // Initialize the Random object
        int randomColumn = validColumns.get(random.nextInt(validColumns.size())); // Get a random valid column
        return randomColumn; // Return the randomly selected column index
    }



}
