package com.priyajit.designTicTacToe.player;

import com.priyajit.designTicTacToe.game.Board;
import com.priyajit.designTicTacToe.ConsoleReader;


public class HumanPlayer extends Player {
    public HumanPlayer(String name, char symbol) {
        super(name, symbol);
    }

    public Move makeMove(Board board) {
        int dimension = board.getDimension();
        System.out.println("Enter row:");
        int row = ConsoleReader.scanner.nextInt();
        while(!isValidRow(row, dimension)){

            row = ConsoleReader.scanner.nextInt();
        }
        System.out.println("Enter col:");
        int col = ConsoleReader.scanner.nextInt();
        return new Move(row, col, this);
    }
    private boolean isValidRow(int row, int dimension){
        return row >=0 && row < dimension;
    }
    private boolean isValidCol(int col, int dimension){
        return col >=0 && col < dimension;
    }
}
