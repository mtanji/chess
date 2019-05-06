package com.mauricio.chess.dynamics.move;

import com.mauricio.chess.element.Cell;
import com.mauricio.chess.element.Piece;

/**
 * Implements {@link com.mauricio.chess.element.PieceType#Bishop} allowed moves
 */
public class BishopMove implements PieceMove {

    public boolean canMove(Piece piece, Cell toCell) {
        Cell fromCell = piece.getCell();
        MoveChain move = new DiagonalMove.Builder(fromCell, toCell).build();
        return move.isAllowed();
    }
}
