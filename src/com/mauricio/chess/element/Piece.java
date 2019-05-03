package com.mauricio.chess.element;

public abstract class Piece {

    protected final PieceColor pieceColor;
    protected Cell currentCell;

    Piece(PieceColor pieceColor, Cell currentCell) {
        this.pieceColor = pieceColor;
        this.currentCell = currentCell;
    }

    void move(Cell cell) {
        // remove piece reference in previous position
        currentCell.setPiece(null);
        currentCell = cell;
        // set piece reference into new position
        currentCell.setPiece(this);
    }

    abstract public boolean allowed(Cell cell);
}
