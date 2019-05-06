package com.mauricio.chess.dynamics.move;

import com.mauricio.chess.element.Cell;

/**
 * Base move to compose chess piece moves. {@link HorizontalMove} is used to represent moves along files. It does not
 * handle scenario where a piece should not jump over another piece.
 */
public class HorizontalMove implements MoveChain {

    private final Cell fromCell;
    private final Cell toCell;
    private MoveChain next;
    private Integer size;

    private HorizontalMove(Cell fromCell, Cell toCell) {
        this.fromCell = fromCell;
        this.toCell = toCell;
    }

    public boolean isAllowed() {
        boolean isAllowed = true;
        // horizontal moves do not allow rank change
        if (next == null && !fromCell.sameRank(toCell)) {
            return false;
        }

        if (size != null) {
            isAllowed = Math.abs(fromCell.fileDistanceTo(toCell)) == size;
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

        private final HorizontalMove verticalMove;

        Builder(Cell fromCell, Cell toCell) {
            verticalMove = new HorizontalMove(fromCell, toCell);
        }

        HorizontalMove.Builder setSize(int size) {
            verticalMove.size = size;
            return this;
        }

        HorizontalMove.Builder setNext(MoveChain moveChain) {
            verticalMove.next = moveChain;
            return this;
        }

        HorizontalMove build() {
            return verticalMove;
        }
    }
}
