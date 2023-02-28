package com.priyajit.designTicTacToe.player;

import com.priyajit.designTicTacToe.player.Player;

public class Move {
    Integer row;
    Integer col;
    Player player;

    public Move(Integer row, Integer col, Player player) {
        this.row = row;
        this.col = col;
        this.player = player;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getCol() {
        return col;
    }

    public void setCol(Integer col) {
        this.col = col;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "Move{" +
                "row=" + row +
                ", col=" + col +
                ", player=" + player +
                '}';
    }
}
