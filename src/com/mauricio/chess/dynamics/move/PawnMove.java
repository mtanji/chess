package com.mauricio.chess.dynamics.move;

import com.mauricio.chess.element.Cell;
import com.mauricio.chess.element.Piece;
import com.mauricio.chess.element.PieceColor;

/**
 * Implements {@link com.mauricio.chess.element.PieceType#Pawn} allowed moves
 */
public class PawnMove implements PieceMove {

    public boolean canMove(Piece piece, Cell toCell) {
        boolean isWhite = piece.getPieceColor() == PieceColor.WHITE;
        Cell fromCell = piece.getCell();
        MoveChain move1 = new VerticalMove.Builder(fromCell, toCell).setIncrementRank(isWhite).setSize(1).build();
        MoveChain move2 = new VerticalMove.Builder(fromCell, toCell).setIncrementRank(isWhite).setSize(2).build();
        MoveChain captureMove = new DiagonalMove.Builder(fromCell, toCell).setIncrementRank(isWhite).setSize(1).build();
        return move1.isAllowed() || move2.isAllowed() || captureMove.isAllowed();
    }

}
