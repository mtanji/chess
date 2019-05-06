package com.mauricio.chess.dynamics.move;

import com.mauricio.chess.element.Cell;
import com.mauricio.chess.element.Piece;

/**
 * Interface to be injected into {@link Piece}
 */
public interface PieceMove {

    boolean canMove(Piece piece, Cell toCell);
}
