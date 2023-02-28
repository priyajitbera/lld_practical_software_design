package com.priyajit.designTicTacToe.game;

import com.priyajit.designTicTacToe.player.Move;
import com.priyajit.designTicTacToe.player.Player;
import com.priyajit.designTicTacToe.strategy.winningstrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Game {
    private List<Player> players;
    private Board board;

    // Records the move in the sequence they are played
    // Used to undo and reconstruct the board from beginning
    private List<Move> moves = new ArrayList<>();
    List<Integer> playSequence;

    private Player winner;

    public GameStatus currentGameStatus;

    public Player getWinner() {
        return winner;
    }

    private WinningStrategy winningStrategy;

    public Game(int dimension, List<Player> players, int countBlockedCells, WinningStrategy winningStrategy) {
        this.players = players;
        this.board = new Board(dimension, countBlockedCells);
        this.winningStrategy = winningStrategy;
    }

    public void start() {
        createPlaySequence();
        currentGameStatus = GameStatus.IN_PROGRESS;
        while (currentGameStatus == GameStatus.IN_PROGRESS) {
            for (int playerIndex : playSequence) {
                System.out.println("Current Board:");
                board.printBoard();
                Player player = players.get(playerIndex);
                System.out.println("Turn for " + player);
                Move move = player.makeMove(board);
                System.out.println("move played: " + move);
                moves.add(move);
                board.addMove(move.getRow(), move.getCol(), move.getPlayer().getSymbol());
                currentGameStatus = winningStrategy.validate(board, move);
                if (currentGameStatus == GameStatus.FINISHED) {
                    winner = player;
                    break;
                }
                if (currentGameStatus == GameStatus.DRAW) {
                    break;
                }
            }
        }
        System.out.println("Final Board:");
        board.printBoard();
    }

    private void createPlaySequence() {
        this.playSequence = IntStream.range(0, players.size()).boxed().collect(Collectors.toList());
        System.out.println("Play sequence is:");
        for (int playerIdx : playSequence) {
            System.out.print(players.get(playerIdx) + " -> ");
        }
    }

    public void undo() {

    }

    public void reconstructBoard() {

    }

}
