package com.priyajit.designTicTacToe.player;

import com.priyajit.designTicTacToe.game.Board;
import com.priyajit.designTicTacToe.strategy.difficulylevel.DifficultyLevel;

public class BotPlayer extends Player{
    DifficultyLevel difficultyLevel;

    public BotPlayer(String name, char symbol) {
        super(name, symbol);
    }

    public BotPlayer(String name, char symbol, DifficultyLevel difficultyLevel){
        this(name, symbol);
        this.difficultyLevel = difficultyLevel;
    }

    @Override
    public Move makeMove(Board board){
         Move move = difficultyLevel.doMove(board);
         move.setPlayer(this);
         return move;
    }
}
