package com.example;

import java.util.List;
import java.util.Random;

public class Computer extends Player {
    private Random random;


    public Computer(String name, String symbol, Random random) {
        super(name, symbol);
        this.random = random;
    }

    // Fallback constructor for production use
    public Computer(String name, String symbol) {
        this(name, symbol, new Random());
    }

    @Override
    public int makeMove(Board board) {
        List<Integer> validColumns = board.getValidColumns();
        return validColumns.get(random.nextInt(validColumns.size())); // Use the injected Random object
    }
}
