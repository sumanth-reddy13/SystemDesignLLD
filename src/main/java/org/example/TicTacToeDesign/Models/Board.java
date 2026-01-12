package org.example.TicTacToeDesign.Models;

public class Board {
    public final Cell[][] board;
    private final int size;

    public Board(int n) {
        this.size = n;
        this.board = new Cell[n][n];
    }

    public Cell[][] getBoard() {
        return this.board;
    }

    public int getSize() {
        return this.size;
    }

}
