package org.example.TicTacToeDesign;

import org.example.TicTacToeDesign.Models.Board;
import org.example.TicTacToeDesign.Models.Player;

public class TicTacToeService {
    private static TicTacToeService instance;
    private Game game;

    public synchronized TicTacToeService getInstance() {
        if (instance == null) {
            instance = new TicTacToeService();
        }
        return instance;
    }

    public Game createGame(Game game) {
        this.game = game;
        return game;
    }

    public void makeMove(Player player, int row, int col) {
        game.makeMove(player, row, col);
    }
}
