package com.example;

public abstract class Player {
    private final String name; // Játékos neve
    private final String symbol; // Játékos szimbóluma ('X' vagy 'O')

    // Konstruktor
    public Player(String name, String symbol) {
        this.name = name;
        if (symbol.charAt(0) != 'X' && symbol.charAt(0) != 'O') {
            throw new IllegalArgumentException("Érvénytelen szimbólum! Csak 'X' vagy 'O' lehet.");
        }
        this.symbol = symbol;
    }

    // Getterek
    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    // Absztrakt metódus a lépéshez
    public abstract int makeMove(Board board);
}


