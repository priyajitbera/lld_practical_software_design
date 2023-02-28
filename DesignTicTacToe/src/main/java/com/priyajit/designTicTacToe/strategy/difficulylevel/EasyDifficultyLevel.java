package com.priyajit.designTicTacToe.strategy.difficulylevel;

import com.priyajit.designTicTacToe.game.Board;
import com.priyajit.designTicTacToe.player.Move;

import java.util.Random;

// Randomly selects a free cell for move
public class EasyDifficultyLevel implements DifficultyLevel {
    @Override
    public Move doMove(Board board) {
        int dimension = board.getDimension();
        while(true){
            Random random = new Random();
            int randomRow = Math.abs(random.nextInt())%dimension;
            int randomCol = Math.abs(random.nextInt())%dimension;
            char symbol = board.getCells()[randomRow][randomCol];
            if(board.isFreeCell(randomRow, randomCol)){
                return new Move(randomRow, randomCol, null);
            }
        }
    }
}
