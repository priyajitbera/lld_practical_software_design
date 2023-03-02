package com.priyajit.designTicTacToe.player;

import com.priyajit.designTicTacToe.game.Board;
import com.priyajit.designTicTacToe.strategy.difficulylevel.Difficulty;
import com.priyajit.designTicTacToe.strategy.difficulylevel.DifficultyLevel;

public class BotPlayer extends Player{
    Difficulty difficulty;

    public BotPlayer(String name, char symbol) {
        super(name, symbol);
    }

    public BotPlayer(String name, char symbol, Difficulty difficulty){
        this(name, symbol);
        this.difficulty = difficulty;
    }

    @Override
    public Move makeMove(Board board){
         Move move = difficulty.doMove(board);
         move.setPlayer(this);
         return move;
    }
}
