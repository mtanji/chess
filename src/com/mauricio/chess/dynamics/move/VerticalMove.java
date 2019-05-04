package com.mauricio.chess.dynamics.move;

import com.mauricio.chess.element.Cell;

public class VerticalMove implements MoveChain {

    private final Cell fromCell;
    private final Cell toCell;
    private MoveChain next;
    private Boolean incrementRank;
    private boolean jumps; // TODO leave this validation for later
    private Integer size;

    private VerticalMove(Cell fromCell, Cell toCell) {
        this.fromCell = fromCell;
        this.toCell = toCell;
    }

    public boolean isAllowed() {
        boolean isAllowed = true;
        // vertical moves do not allow file change
        if(!fromCell.sameFile(toCell)) {
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

    static class Builder {

        private final VerticalMove verticalMove;

        Builder(Cell fromCell, Cell toCell) {
            verticalMove = new VerticalMove(fromCell, toCell);
        }

        Builder setSize(int size) {
            verticalMove.size = size;
            return this;
        }

        Builder setJumps(boolean jumps) {
            verticalMove.jumps = jumps;
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
