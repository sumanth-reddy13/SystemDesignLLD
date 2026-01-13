package org.example.TicTacToeDesign.Strategy;

import org.example.TicTacToeDesign.Models.Board;
import org.example.TicTacToeDesign.Models.Player;

public interface WinningStrategy {
    boolean checkWinner(Board board, Player player);
}
