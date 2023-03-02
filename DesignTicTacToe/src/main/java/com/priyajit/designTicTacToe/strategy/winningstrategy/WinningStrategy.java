package com.priyajit.designTicTacToe.strategy.winningstrategy;

import com.priyajit.designTicTacToe.game.Board;
import com.priyajit.designTicTacToe.game.GameStatus;
import com.priyajit.designTicTacToe.player.Move;

public interface WinningStrategy {
    public abstract GameStatus validate(Board board, Move lastMove);
}
