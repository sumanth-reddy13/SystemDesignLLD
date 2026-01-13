package org.example.TicTacToeDesign.State;

import org.example.TicTacToeDesign.Game;
import org.example.TicTacToeDesign.Models.Player;

public class WinnerState implements GameState {
    public void handleMove(Game game, Player player, int row, int col) {
        System.out.println(game.getWinner().getName() + " won the game. You can't make a move.");
    }
}
