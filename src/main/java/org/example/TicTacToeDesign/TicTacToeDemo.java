package org.example.TicTacToeDesign;

import org.example.TicTacToeDesign.Enums.GameStatus;
import org.example.TicTacToeDesign.Enums.Symbol;
import org.example.TicTacToeDesign.Models.Board;
import org.example.TicTacToeDesign.Models.Player;
import org.example.TicTacToeDesign.Strategy.ColumnWinningStrategy;
import org.example.TicTacToeDesign.Strategy.DiagonalWinningStrategy;
import org.example.TicTacToeDesign.Strategy.RowWinningStrategy;
import org.example.TicTacToeDesign.Strategy.WinningStrategy;

import java.util.List;
import java.util.Scanner;

public class TicTacToeDemo {
    public static void main(String[] args) {

        Player alice = new Player(1, "alice", Symbol.X);
        Player bob = new Player(2, "bob", Symbol.O);
        Board board = new Board(3);
        List<WinningStrategy> winningStrategies = List.of(
                new ColumnWinningStrategy(),
                new RowWinningStrategy(),
                new DiagonalWinningStrategy()
        );

        TicTacToeSystem system = TicTacToeSystem.getInstance();
        Game game = system.createGame(new Game.Builder()
                .player1(alice)
                .player2(bob)
                .currentPlayer(alice)
                .board(board)
                .winningStrategies(winningStrategies)
                .build()
        );
        System.out.printf("Starting game with Player1: %s and Player2: %s", alice.getName(), bob.getName());
        System.out.println();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("Press 1 to PLAY");
            System.out.println("Press 2 to EXIT");

            try {
                int option = sc.nextInt();
                boolean endGame = false;
                switch (option) {
                    case 1:
                        playGame(game, system, sc);
                        break;
                    case 2:
                        endGame = true;
                        break;
                    default:
                        System.out.println("Invalid option. Exiting the game.");
                }

                if (endGame) break;
            }
            catch (Exception e) {
                System.out.println("Exception occurred: " + e);
            }
        }
    }

    public static void playGame(Game game, TicTacToeSystem system, Scanner sc) throws Exception {
        while (game.getStatus() == GameStatus.IN_PROGRESS) {
            System.out.println(game.getCurrentPlayer().getName() + "'s Turn");
            System.out.println("Enter the cell co-ordinates:");
            int row = sc.nextInt();
            int col = sc.nextInt();
            system.makeMove(game.getCurrentPlayer(), row, col);
            game.getBoard().printBoard();
        }

        System.out.println("GAME STATUS : " + game.getStatus());
        if (game.getStatus() == GameStatus.DRAW) {
            System.out.println("It is a Draw");
        } else {
            System.out.println(game.getWinner().getName() + " won the game.");
        }
    }
}
