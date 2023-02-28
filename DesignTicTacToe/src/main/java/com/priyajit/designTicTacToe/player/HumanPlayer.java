package com.priyajit.designTicTacToe.player;

import com.priyajit.designTicTacToe.ConsoleReaderImpl;
import com.priyajit.designTicTacToe.game.Board;
import com.priyajit.designTicTacToe.ConsoleReader;


public class HumanPlayer extends Player {
    public HumanPlayer(String name, char symbol) {
        super(name, symbol);
    }

    public Move makeMove(Board board) {
        int dimension = board.getDimension();
        ConsoleReader consoleReader = ConsoleReaderImpl.getInstance();
        int row = consoleReader.readInt("row", "", 0, dimension-1);
        int col = consoleReader.readInt("col", "", 0, dimension-1);
        return new Move(row, col, this);
    }
}
