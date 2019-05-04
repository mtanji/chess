package com.mauricio.chess.dynamics.move;

import com.mauricio.chess.element.Cell;
import com.mauricio.chess.element.Piece;

public interface PieceMove {

    boolean canMove(Piece piece, Cell toCell);
}
