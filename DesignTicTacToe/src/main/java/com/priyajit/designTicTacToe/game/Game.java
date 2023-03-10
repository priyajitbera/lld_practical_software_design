package com.priyajit.designTicTacToe.game;

import com.priyajit.designTicTacToe.ConsoleReader;
import com.priyajit.designTicTacToe.ConsoleReaderImpl;
import com.priyajit.designTicTacToe.player.Move;
import com.priyajit.designTicTacToe.player.Player;
import com.priyajit.designTicTacToe.strategy.winningstrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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

    private GameStatus currentGameStatus;

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
        ConsoleReader consoleReader = ConsoleReaderImpl.getInstance();
        createPlaySequence();
        currentGameStatus = GameStatus.IN_PROGRESS;
        while (currentGameStatus == GameStatus.IN_PROGRESS) {
            for (int playerIndex : playSequence) {
                System.out.println("Current Board:");
                board.printBoard();

                // ask for choice of undo
                if (moves.size() > 0) {
                    Set<Character> options = Set.of('y', 'n');
                    char choice = consoleReader.readChar("choice", "undo previous move?", options);
                    if (choice == 'y') {
                        undo();
                        continue;
                    }
                }
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

    public GameStatus getCurrentGameStatus() {
        return currentGameStatus;
    }

    private void createPlaySequence() {
        this.playSequence = IntStream.range(0, players.size()).boxed().collect(Collectors.toList());
        System.out.println("Play sequence is:");
        for (int playerIdx : playSequence) {
            System.out.print(players.get(playerIdx) + " -> ");
        }
    }

    public void undo() {
        if (moves.size() == 0) return;
        Move lastMove = moves.get(moves.size() - 1);
        board.undoMove(lastMove.getRow(), lastMove.getCol());
    }

    public void reconstructBoard() {
        // TODO : implement
        resetBoard();
    }

    private void resetBoard() {

    }
}
