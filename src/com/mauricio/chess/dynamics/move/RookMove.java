package com.mauricio.chess.dynamics.move;

import com.mauricio.chess.element.Cell;
import com.mauricio.chess.element.Piece;

/**
 * Implements {@link com.mauricio.chess.element.PieceType#Rook} allowed moves
 */
public class RookMove implements PieceMove {

    public boolean canMove(Piece piece, Cell toCell) {
        Cell fromCell = piece.getCell();
        MoveChain vMove = new VerticalMove.Builder(fromCell, toCell).build();
        MoveChain hMove = new HorizontalMove.Builder(fromCell, toCell).build();
        return vMove.isAllowed() || hMove.isAllowed();
    }
}
