package com.mauricio.chess.element;

public class King extends Piece {

    King(Board board, Cell currentCell, PieceColor pieceColor) {
        super(board, currentCell, pieceColor);
        currentCell.setPiece(this);
    }

    @Override
    public boolean allowed(Cell cell) {
        return true;
    }
}
