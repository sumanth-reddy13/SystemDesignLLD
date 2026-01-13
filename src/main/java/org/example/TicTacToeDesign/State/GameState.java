package org.example.TicTacToeDesign.State;

import org.example.TicTacToeDesign.Game;
import org.example.TicTacToeDesign.Models.Player;

public interface GameState {
    void handleMove(Game game, Player player, int row, int col);
}
