package org.example.TicTacToeDesign.State;

import org.example.TicTacToeDesign.Enums.Symbol;
import org.example.TicTacToeDesign.Game;
import org.example.TicTacToeDesign.Models.Cell;
import org.example.TicTacToeDesign.Models.Player;

public class InProgressState implements GameState {

    @Override
    public void handleMove(Game game, Player player, int row, int col) {
        if (player.getId() != (game.getCurrentPlayer().getId())) {
            throw new RuntimeException(player.getName() + ", This is not your turn to make a move");
        }

        if (row < 0 || row >= game.getBoard().getSize() || col < 0 || col >= game.getBoard().getSize()) {
            throw new RuntimeException("Given co-ordinates are not correct.");
        }

        Cell[][] board = game.getBoard().getBoard();

        if (board[row][col].getSymbol() == Symbol.O || board[row][col].getSymbol() == Symbol.X) {
            throw new RuntimeException("This cell has already been set.");
        }
        board[row][col].setSymbol(player.getSymbol());
    }
}
