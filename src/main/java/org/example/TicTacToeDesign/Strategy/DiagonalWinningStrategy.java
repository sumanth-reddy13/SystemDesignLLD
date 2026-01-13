package org.example.TicTacToeDesign.Strategy;

import org.example.TicTacToeDesign.Models.Board;
import org.example.TicTacToeDesign.Models.Player;

public class DiagonalWinningStrategy implements WinningStrategy {

    @Override
    public boolean checkWinner(Board board, Player player) {
        int row = 0;
        int col = 0;
        boolean diagWin = true;

        while (row < board.getSize() && col < board.getSize()) {
            if (board.getBoard()[row][col].getSymbol() != player.getSymbol()) {
                diagWin = false;
                break;
            }
            row++;
            col++;
        }
        if (diagWin) return true;

        row = 0;
        col = board.getSize() - 1;
        diagWin = true;

        while (row < board.getSize() && col > -1) {
            if (board.getBoard()[row][col].getSymbol() != player.getSymbol()) {
                diagWin = false;
                break;
            }
            row++;
            col--;
        }
        if (diagWin) return true;

        return false;
    }
}
