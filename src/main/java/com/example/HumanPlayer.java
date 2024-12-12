package com.example;

import java.util.Scanner;

public class HumanPlayer extends Player {
    public HumanPlayer(String name, String symbol) {
        super(name, symbol);
    }

    @Override
    public int makeMove(Board board) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Add meg az oszlop számát: ");
        return scanner.nextInt();
    }

}
