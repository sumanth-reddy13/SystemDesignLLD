package org.example.TicTacToeDesign;

import org.example.TicTacToeDesign.Enums.GameStatus;
import org.example.TicTacToeDesign.Enums.Symbol;
import org.example.TicTacToeDesign.Models.Board;
import org.example.TicTacToeDesign.Models.Cell;
import org.example.TicTacToeDesign.Models.Player;
import org.example.TicTacToeDesign.State.DrawState;
import org.example.TicTacToeDesign.State.GameState;
import org.example.TicTacToeDesign.State.InProgressState;
import org.example.TicTacToeDesign.State.WinnerState;
import org.example.TicTacToeDesign.Strategy.WinningStrategy;

import java.util.List;

public class Game {
    private final Board board;
    private Player player1;
    private Player player2;
    private Player winner;
    private GameStatus status;
    private GameState gameState;
    private Player currentPlayer;
    private List<WinningStrategy> winningStrategies;

    private Game(Builder builder) {
        this.board = builder.board;
        this.player1 = builder.player1;
        this.player2 = builder.player2;
        this.winner = null;
        this.gameState = new InProgressState();
        this.currentPlayer = builder.currentPlayer;
        this.winningStrategies = builder.winningStrategies;
        this.status = GameStatus.IN_PROGRESS;
    }

    public void makeMove(Player player, int row, int col) {
        gameState.handleMove(this, player, row, col);

        if (isWinningMove()) {
            this.winner = currentPlayer;
            this.gameState = new WinnerState();
            this.status = currentPlayer.getSymbol() == Symbol.X ? GameStatus.WINNER_X : GameStatus.WINNER_O;
        } else if (isDraw()) {
            this.winner = currentPlayer;
            this.gameState = new DrawState();
            this.status = GameStatus.DRAW;
        }
        this.switchPlayer();
    }

    public boolean isWinningMove() {
        for (WinningStrategy winningStrategy : winningStrategies) {
            if (winningStrategy.checkWinner(board, currentPlayer)) return true;
        }
        return false;
    }

    public boolean isDraw() {
        Cell[][] board = this.getBoard().getBoard();
        int count = 0;
        for (Cell[] row : board) {
            for (Cell cell : row) {
                if (cell.getSymbol() == Symbol.EMPTY) count++;
            }
        }
        return count == 0;
    }

    public void switchPlayer() {
        this.currentPlayer = this.currentPlayer == player1 ? player2 : player1;
    }

    public Board getBoard() {
        return board;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Player getWinner() {
        return winner;
    }

    public GameStatus getStatus() {
        return status;
    }

    public GameState getGameState() {
        return gameState;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public static class Builder {
        private Board board;
        private Player player1;
        private Player player2;
        private Player currentPlayer;
        private List<WinningStrategy> winningStrategies;

        public Builder() {}

        public Builder board(Board board) {
            this.board = board;
            return this;
        }

        public Builder player1(Player player) {
            this.player1 = player;
            return this;
        }

        public Builder player2(Player player) {
            this.player2 = player;
            return this;
        }

        public Builder currentPlayer(Player player) {
            this.currentPlayer = player;
            return this;
        }

        public Builder winningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public Game build() {
            return new Game(this);
        }
    }
}
