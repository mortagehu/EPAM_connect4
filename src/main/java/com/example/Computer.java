package com.example;

import java.util.List;
import java.util.Random;

public class Computer extends Player {
    private final Random random;

    public Computer(String name, String color){
        super(name, color);
        this.random = new Random();
    }

    public String makeMove(List<String> validColumns) {
        int index = random.nextInt(validColumns.size());
        return validColumns.get(index);
    }

}
