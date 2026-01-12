package org.example.TicTacToeDesign.Models;

import org.example.TicTacToeDesign.Enums.Symbol;

public class Cell {
    Symbol symbol;

    public Cell() {
        this.symbol = Symbol.EMPTY;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public Symbol getSymbol() {
        return symbol;
    }
}
