package com.mauricio.chess.dynamics.move;

import com.mauricio.chess.element.Cell;
import com.mauricio.chess.element.Piece;

/**
 * Implements {@link com.mauricio.chess.element.PieceType#King} allowed moves
 */
public class KingMove implements PieceMove {

    public boolean canMove(Piece piece, Cell toCell) {
        Cell fromCell = piece.getCell();
        MoveChain dMove = new DiagonalMove.Builder(fromCell, toCell).setSize(1).build();
        MoveChain vMove = new VerticalMove.Builder(fromCell, toCell).setSize(1).build();
        MoveChain hMove = new HorizontalMove.Builder(fromCell, toCell).setSize(1).build();
        return dMove.isAllowed() || vMove.isAllowed() || hMove.isAllowed();
    }
}
