package org.example.TicTacToeDesign.Models;

public class Board {
    public final Cell[][] board;
    private final int size;

    public Board(int n) {
        this.size = n;
        this.board = new Cell[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                this.board[i][j] = new Cell();
            }
        }
    }

    public Cell[][] getBoard() {
        return this.board;
    }

    public int getSize() {
        return this.size;
    }

    public void printBoard() {
        System.out.println("***** BOARD *****");
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                System.out.print(board[i][j].getSymbol().getChar() + " ");
            }
            System.out.println();
        }
    }
}
