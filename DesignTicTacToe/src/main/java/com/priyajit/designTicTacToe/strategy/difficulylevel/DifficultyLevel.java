package com.priyajit.designTicTacToe.strategy.difficulylevel;

import com.priyajit.designTicTacToe.game.Board;
import com.priyajit.designTicTacToe.player.Move;

public abstract class DifficultyLevel {
    public static enum DIFFICULTY_LEVELS {EASY, MEDIUM, HARD};

    public abstract Move doMove(Board board);
}
