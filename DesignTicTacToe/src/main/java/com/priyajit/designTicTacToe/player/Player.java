package com.priyajit.designTicTacToe.player;

import com.priyajit.designTicTacToe.game.Board;

public abstract class Player {
    String name;
    Character symbol;

    public Player(String name, Character symbol){
        this.name = name;
        this.symbol = symbol;
    }

    public abstract Move makeMove(Board board);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getSymbol() {
        return symbol;
    }

    public void setSymbol(Character symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", symbol=" + symbol +
                '}';
    }
}
