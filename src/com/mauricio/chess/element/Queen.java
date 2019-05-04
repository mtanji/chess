package com.mauricio.chess.element;

public class Queen extends Piece {

    Queen(Board board, Cell currentCell, PieceColor pieceColor) {
        super(board, currentCell, pieceColor);
        currentCell.setPiece(this);
    }

    @Override
    public boolean allowed(Cell cell) {
        return true;
    }

    @Override
    protected PieceType getType() {
        return PieceType.Queen;
    }
}