package com.mauricio.chess.element;

public class Knight extends Piece {

    Knight(Board board, Cell currentCell, PieceColor pieceColor) {
        super(board, currentCell, pieceColor);
        currentCell.setPiece(this);
    }

    @Override
    public boolean allowed(Cell cell) {
        return true;
    }
}
