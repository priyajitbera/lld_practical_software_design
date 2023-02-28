package com.priyajit.designTicTacToe.strategy.difficulylevel;

import com.priyajit.designTicTacToe.game.Board;
import com.priyajit.designTicTacToe.player.Move;

public interface DifficultyLevel {
    public abstract Move doMove(Board board);
}
