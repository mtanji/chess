package com.mauricio.chess.dynamics.move;

import com.mauricio.chess.element.Cell;
import com.mauricio.chess.element.Piece;

public class QueenMove implements PieceMove {

    public boolean canMove(Piece piece, Cell toCell) {
        Cell fromCell = piece.getCell();
        MoveChain dMove = new DiagonalMove.Builder(fromCell, toCell).build();
        MoveChain vMove = new VerticalMove.Builder(fromCell, toCell).build();
        MoveChain hMove = new HorizontalMove.Builder(fromCell, toCell).build();
        return dMove.isAllowed() || vMove.isAllowed() || hMove.isAllowed();
    }
}
