package org.example.TicTacToeDesign.Strategy;

import org.example.TicTacToeDesign.Models.Board;
import org.example.TicTacToeDesign.Models.Player;

public class RowWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWinner(Board board, Player player) {
        for (int row = 0; row < board.getSize(); row++) {
            boolean colWin = true;
            for (int col = 0; col < board.getSize(); col++) {
                if (board.getBoard()[row][col].getSymbol() != player.getSymbol()) {
                    colWin = false;
                    break;
                }
            }
            if (colWin) return true;
        }
        return false;
    }
}
