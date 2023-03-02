package com.priyajit.designTicTacToe.strategy.winningstrategy;

import com.priyajit.designTicTacToe.game.Board;
import com.priyajit.designTicTacToe.game.GameStatus;
import com.priyajit.designTicTacToe.player.Move;

/**
 * Implements simple Tic Tac Toe winning strategy
 * Looks for rows / cols / diagonals with same symbol
 */
public class SimpleWinningStrategy implements WinningStrategy {

    @Override
    public GameStatus validate(Board board, Move lastMove) {
        int dimension = board.getDimension();
        char symbol = lastMove.getPlayer().getSymbol();
        int row = lastMove.getRow();
        int col = lastMove.getCol();

        // get count of the last move's symbol
        int colSymbolCount = board.getColWiseSymbolCount().get(col).get(symbol);
        int rowSymbolCount = board.getRowWiseSymbolCount().get(row).get(symbol);
        int posDiagSymbolCount = board.getPosDiagWiseSymbolCount().get(col - row).get(symbol);
        int negDiagSymbolCount = board.getNegDiagWiseSymbolCount().get(col + row).get(symbol);

        // check if any(row / col / diagonals) symbol count matches the dimension
        if (dimension == colSymbolCount || dimension == rowSymbolCount || dimension == posDiagSymbolCount || dimension == negDiagSymbolCount) {
            return GameStatus.FINISHED;
        }
        if (board.getEmptyCellCount() == 0) return GameStatus.DRAW;
        return GameStatus.IN_PROGRESS;
    }
}
