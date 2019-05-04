package com.mauricio.chess.dynamics.move;

import com.mauricio.chess.element.Cell;
import com.mauricio.chess.element.Piece;

public class KnightMove implements PieceMove {

    public boolean canMove(Piece piece, Cell toCell) {
        Cell fromCell = piece.getCell();

        // solution to signalize there is a chain
        MoveChain moveFinal = new HorizontalMove.Builder(fromCell, fromCell).build();

        MoveChain moveSecondHorizontal = new HorizontalMove.Builder(fromCell, toCell).setSize(1).setNext(moveFinal)
                .build();
        MoveChain moveFirstVertical = new VerticalMove.Builder(fromCell, toCell).setSize(2)
                .setNext(moveSecondHorizontal).build();

        MoveChain moveSecondVertical = new VerticalMove.Builder(fromCell, toCell).setSize(1).setNext(moveFinal).build();
        MoveChain moveFirstHorizontal = new HorizontalMove.Builder(fromCell, toCell).setSize(2)
                .setNext(moveSecondVertical).build();

        return moveFirstVertical.isAllowed() || moveFirstHorizontal.isAllowed();
    }
}
