package com.priyajit.designTicTacToe.strategy.difficulylevel;

import com.priyajit.designTicTacToe.game.Board;
import com.priyajit.designTicTacToe.player.Move;

import java.util.Random;

/**
 * Implementation of DifficultyLevel for bot players
 * (same strategy as easy difficulty level, made up for demo)
 */
public class MediumDifficultyLevel extends DifficultyLevel {
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
