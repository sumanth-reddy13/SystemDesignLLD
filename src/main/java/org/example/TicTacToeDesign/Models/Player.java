package org.example.TicTacToeDesign.Models;

import org.example.TicTacToeDesign.Enums.Symbol;

public class Player {
    private int id;
    private String name;
    private Symbol symbol;

    public Player(int id, String name, Symbol symbol) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public Symbol getSymbol() {
        return this.symbol;
    }
}
