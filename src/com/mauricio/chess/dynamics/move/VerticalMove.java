package com.mauricio.chess.dynamics.move;

import com.mauricio.chess.element.Cell;

/**
 * Base move to compose chess piece moves. {@link VerticalMove} is used to represent moves along ranks. It does not
 * handle scenario where a piece should not jump over another piece.
 */
public class VerticalMove implements MoveChain {

    private final Cell fromCell;
    private final Cell toCell;
    private MoveChain next;
    private Boolean incrementRank;
    private Integer size;

    private VerticalMove(Cell fromCell, Cell toCell) {
        this.fromCell = fromCell;
        this.toCell = toCell;
    }

    public boolean isAllowed() {
        boolean isAllowed = true;
        // vertical moves do not allow file change
        if (next == null && !fromCell.sameFile(toCell)) {
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
                isAllowed = Math.abs(fromCell.rankDistanceTo(toCell)) == size;
            }
        }

        if (isAllowed && next != null) {
            isAllowed = next.isAllowed();
        }
        return isAllowed;
    }

    /**
     * Builder design pattern
     */
    static class Builder {

        private final VerticalMove verticalMove;

        Builder(Cell fromCell, Cell toCell) {
            verticalMove = new VerticalMove(fromCell, toCell);
        }

        Builder setSize(int size) {
            verticalMove.size = size;
            return this;
        }

        Builder setIncrementRank(boolean incrementRank) {
            verticalMove.incrementRank = incrementRank;
            return this;
        }

        Builder setNext(MoveChain moveChain) {
            verticalMove.next = moveChain;
            return this;
        }

        VerticalMove build() {
            return verticalMove;
        }
    }
}
