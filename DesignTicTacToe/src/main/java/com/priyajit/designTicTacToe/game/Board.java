package com.priyajit.designTicTacToe.game;

import java.util.*;

public class Board {

    // constants
    public final static char EMPTY_CELL_SYMBOL = ' ';
    public final static char BLOCKED_CELL_SYMBOL = '!';

    // attributes
    private Integer dimension;
    private Integer blockedCellCount;
    private char[][] cells;
    private Integer emptyCellCount = 0;

    // count maps to store row, col, diag wise symbol counts
    // key:col, value: map(key:symbol, value:count)
    private Map<Integer, Map<Character, Integer>> colWiseSymbolCount = new HashMap<>();

    // key:row, value: map(key:symbol, value:count)
    private Map<Integer, Map<Character, Integer>> rowWiseSymbolCount = new HashMap<>();

    // key:(col-row), value: map(key:symbol, value:count)
    private Map<Integer, Map<Character, Integer>> posDiagWiseSymbolCount = new HashMap<>();

    // key:(row+col), value: map(key:symbol, value:count)
    private Map<Integer, Map<Character, Integer>> negDiagWiseSymbolCount = new HashMap<>();

    public Map<Integer, Map<Character, Integer>> getColWiseSymbolCount() {
        return colWiseSymbolCount;
    }

    public Map<Integer, Map<Character, Integer>> getRowWiseSymbolCount() {
        return rowWiseSymbolCount;
    }

    public Map<Integer, Map<Character, Integer>> getPosDiagWiseSymbolCount() {
        return posDiagWiseSymbolCount;
    }

    public Map<Integer, Map<Character, Integer>> getNegDiagWiseSymbolCount() {
        return negDiagWiseSymbolCount;
    }

    // constructors
    public Board(Integer dimension, Integer blockedCellCount) {
        this.dimension = dimension;
        this.blockedCellCount = blockedCellCount;

        // fill cells with empty block symbol
        this.cells = new char[dimension][dimension];
        for (int row = 0; row < dimension; row++) {
            for (int col = 0; col < dimension; col++) {
                cells[row][col] = EMPTY_CELL_SYMBOL;
            }
        }
        // generate random block cells
        generateBlockedCells(blockedCellCount);
        this.emptyCellCount = (dimension * dimension) - blockedCellCount;
    }

    // getters and setters
    public Integer getDimension() {
        return dimension;
    }

    public void setDimension(Integer dimension) {
        this.dimension = dimension;
    }

    public Integer getBlockedCellCount() {
        return blockedCellCount;
    }

    public char[][] getCells() {
        return cells;
    }

    public Integer getEmptyCellCount() {
        return emptyCellCount;
    }

    private void generateBlockedCells(int blockedCellCount) {
        var random = new Random();
        int count = 0;
        while (count < blockedCellCount) {
            int row = Math.abs(random.nextInt()) % dimension;
            int col = Math.abs(random.nextInt()) % dimension;
            if (cells[row][col] == BLOCKED_CELL_SYMBOL) continue;
            cells[row][col] = BLOCKED_CELL_SYMBOL;
            count++;
        }
    }

    public void addMove(int row, int col, char symbol) {
        cells[row][col] = symbol;
        incrSymbolCount(row, col, symbol);
        emptyCellCount--;
    }

    public void undoMove(int row, int col) {
        char symbol = cells[row][col];
        cells[row][col] = Board.EMPTY_CELL_SYMBOL;
        decrSymbolCount(row, col, symbol);
        emptyCellCount++;
    }

    private void incrSymbolCount(int row, int col, char symbol) {
        incrColWiseSymbolCount(col, symbol);
        incrRowWiseSymbolCount(row, symbol);
        incrPosDiagWiseSymbolCount(row, col, symbol);
        incrNegDiagWiseSymbolCount(row, col, symbol);
    }

    private void decrSymbolCount(int row, int col, char symbol) {
        decrColWiseSymbolCount(col, symbol);
        decrRowWiseSymbolCount(row, symbol);
        decrPosDiagWiseSymbolCount(row, col, symbol);
        decrNegDiagWiseSymbolCount(row, col, symbol);
    }

    private void incrColWiseSymbolCount(int col, char symbol) {
        var countMap = colWiseSymbolCount.getOrDefault(col, new HashMap<>());
        countMap.put(symbol, countMap.getOrDefault(symbol, 0) + 1);
        colWiseSymbolCount.put(col, countMap);
    }

    private void incrRowWiseSymbolCount(int row, char symbol) {
        var countMap = rowWiseSymbolCount.getOrDefault(row, new HashMap<>());
        countMap.put(symbol, countMap.getOrDefault(symbol, 0) + 1);
        rowWiseSymbolCount.put(row, countMap);
    }

    private void incrPosDiagWiseSymbolCount(int row, int col, char symbol) {
        var countMap = posDiagWiseSymbolCount.getOrDefault(col - row, new HashMap<>());
        countMap.put(symbol, countMap.getOrDefault(symbol, 0) + 1);
        posDiagWiseSymbolCount.put(col - row, countMap);
    }

    private void incrNegDiagWiseSymbolCount(int row, int col, char symbol) {
        var countMap = negDiagWiseSymbolCount.getOrDefault(row + col, new HashMap<>());
        countMap.put(symbol, countMap.getOrDefault(symbol, 0) + 1);
        negDiagWiseSymbolCount.put(row + col, countMap);
    }

    private void decrColWiseSymbolCount(int col, char symbol) {
        var countMap = colWiseSymbolCount.get(col);
        countMap.put(symbol, countMap.get(symbol) - 1);
    }

    private void decrRowWiseSymbolCount(int row, char symbol) {
        var countMap = rowWiseSymbolCount.get(row);
        countMap.put(symbol, countMap.get(symbol) - 1);
    }

    private void decrPosDiagWiseSymbolCount(int row, int col, char symbol) {
        var countMap = posDiagWiseSymbolCount.get(col - row);
        countMap.put(symbol, countMap.get(symbol));
    }

    private void decrNegDiagWiseSymbolCount(int row, int col, char symbol) {
        var countMap = negDiagWiseSymbolCount.get(row + col);
        countMap.put(symbol, countMap.get(symbol) - 1);
    }

    public boolean isFreeCell(int row, int col) {
        return cells[row][col] == EMPTY_CELL_SYMBOL;
    }

    public void printBoard() {
        for (int row = 0; row < dimension; row++) {
            for (int col = 0; col < dimension; col++) {
                System.out.printf(" | %c |", cells[row][col]);
            }
            System.out.println(); // new line after each row
        }
    }

}
