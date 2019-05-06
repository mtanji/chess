package com.mauricio.chess.dynamics.move;

import com.mauricio.chess.element.Cell;

/**
 * Base move to compose chess piece moves. {@link DiagonalMove} is used to represent moves along ranks and files by the
 * same amount of cells. It does not handle scenario where a piece should not jump over another piece.
 */
public class DiagonalMove implements MoveChain {

    private final Cell fromCell;
    private final Cell toCell;
    private MoveChain next = null;
    private Boolean incrementRank;
    private Integer size;

    private DiagonalMove(Cell fromCell, Cell toCell) {
        this.fromCell = fromCell;
        this.toCell = toCell;
    }

    public boolean isAllowed() {
        boolean isAllowed = true;
        // diagonal moves must have same file and rank distance between cells
        int absRankDistance = Math.abs(fromCell.rankDistanceTo(toCell));
        int absFileDistance = Math.abs(fromCell.fileDistanceTo(toCell));
        if (next == null && !(absRankDistance == absFileDistance)) {
            return false;
        }

        if (incrementRank != null && incrementRank) { // white pawn piece
            if (size != null) {
                return fromCell.rankDistanceTo(toCell) == size;
            }
        } else if (incrementRank != null && !incrementRank) { // black pawn piece
            if (size != null) {
                return fromCell.rankDistanceTo(toCell) == -size;
            }
        } else {
            if (size != null) {
                return Math.abs(fromCell.rankDistanceTo(toCell)) == size;
            }
        }

        if (next != null) {
            isAllowed = next.isAllowed();
        }
        return isAllowed;
    }

    /**
     * Builder design pattern
     */
    static class Builder {

        private final DiagonalMove diagonalMove;

        Builder(Cell fromCell, Cell toCell) {
            diagonalMove = new DiagonalMove(fromCell, toCell);
        }

        Builder setSize(int size) {
            diagonalMove.size = size;
            return this;
        }

        Builder setIncrementRank(boolean incrementRank) {
            diagonalMove.incrementRank = incrementRank;
            return this;
        }

        DiagonalMove build() {
            return diagonalMove;
        }
    }
}
