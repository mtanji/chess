package com.mauricio.chess.dynamics.move;

import com.mauricio.chess.element.Cell;
import com.mauricio.chess.element.Piece;

public class KingMove implements PieceMove {

    public boolean canMove(Piece piece, Cell toCell) {
        return true;
    }
}
