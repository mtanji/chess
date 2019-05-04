package com.mauricio.chess.dynamics.move;

import com.mauricio.chess.element.Cell;

public class HorizontalMove implements MoveChain {
    Cell currentCell;
    Cell moveToCell;
    MoveChain next;

    public boolean isAllowed() {
        boolean isAllowed = true;

        if(next != null) {
            isAllowed = next.isAllowed();
        }
        return isAllowed;
    }
}
