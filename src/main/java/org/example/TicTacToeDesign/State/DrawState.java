package org.example.TicTacToeDesign.State;

import org.example.TicTacToeDesign.Game;
import org.example.TicTacToeDesign.Models.Player;

public class DrawState implements GameState {
    public void handleMove(Game game, Player player, int row, int col) {
        System.out.println("The game is Drawn. You can't make a move.");
    }
}
