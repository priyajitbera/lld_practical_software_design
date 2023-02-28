package com.priyajit.designTicTacToe.game;

public class Cell {
    private Integer row;
    private Integer col;
    private Boolean isBlocked;
    private Character symbol;

    public Cell(Integer row, Integer col, Character symbol, Boolean isBlocked) {
        this.row = row;
        this.col = col;
        this.symbol = symbol;
        this.isBlocked = isBlocked;
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

    public Boolean getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(Boolean isBlocked) {
        this.isBlocked = isBlocked;
    }

    public Character getSymbol() {
        return symbol;
    }

    public void setSymbol(Character symbol) {
        this.symbol = symbol;
    }
}
