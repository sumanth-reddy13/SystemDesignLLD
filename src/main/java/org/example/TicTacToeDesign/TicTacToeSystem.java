// java
package org.example.TicTacToeDesign;

import org.example.TicTacToeDesign.Models.Player;
import org.example.TicTacToeDesign.Strategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeSystem {
    private static volatile TicTacToeSystem instance;
    private Game game;
    private final List<WinningStrategy> winningStrategies = new ArrayList<>();

    private TicTacToeSystem() {}

    public static synchronized TicTacToeSystem getInstance() {
        if (instance == null) {
            instance = new TicTacToeSystem();
        }
        return instance;
    }

    public Game createGame(Game game) {
        if (game == null) throw new IllegalArgumentException("game cannot be null");
        this.game = game;
        return game;
    }

    public void makeMove(Player player, int row, int col) {
        if (game == null) throw new IllegalStateException("Game not created. Call createGame(...) first.");
        game.makeMove(player, row, col);
    }

    public void setWinningStrategy(WinningStrategy strategy) {
        if (strategy == null) throw new IllegalArgumentException("strategy cannot be null");
        winningStrategies.add(strategy);
    }
}