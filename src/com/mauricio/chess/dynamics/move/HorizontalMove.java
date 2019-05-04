package com.mauricio.chess.dynamics.move;

import com.mauricio.chess.element.Cell;

public class HorizontalMove implements MoveChain {

    private final Cell fromCell;
    private final Cell toCell;
    private MoveChain next;
    private boolean jumps; // TODO leave this validation for later
    private Integer size;

    private HorizontalMove(Cell fromCell, Cell toCell) {
        this.fromCell = fromCell;
        this.toCell = toCell;
    }

    public boolean isAllowed() {
        boolean isAllowed = true;
        // horizontal moves do not allow rank change
        if(!fromCell.sameRank(toCell)) {
            return false;
        }

        if (size != null) {
            return Math.abs(fromCell.rankDistanceTo(toCell)) == size;
        }

        if(next != null) {
            isAllowed = next.isAllowed();
        }
        return isAllowed;
    }

    static class Builder {

        private final HorizontalMove verticalMove;

        Builder(Cell fromCell, Cell toCell) {
            verticalMove = new HorizontalMove(fromCell, toCell);
        }

        HorizontalMove.Builder setSize(int size) {
            verticalMove.size = size;
            return this;
        }

        HorizontalMove.Builder setJumps(boolean jumps) {
            verticalMove.jumps = jumps;
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
