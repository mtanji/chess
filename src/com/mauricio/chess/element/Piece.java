package com.mauricio.chess.element;

public class Piece {

    private final PieceColor pieceColor;
    private final PieceType pieceType;
    private Cell currentCell;

    Piece(PieceColor pieceColor, PieceType pieceType) {
        this.pieceColor = pieceColor;
        this.pieceType = pieceType;
    }

    void move(Cell cell) {
        // remove piece reference in previous position
        if (currentCell != null) {
            currentCell.setPiece(null);
        }
        currentCell = cell;
        // set piece reference into new position
        currentCell.setPiece(this);
    }

    public boolean allowed(Cell cell) {
        // TODO inject move strategies
        return true;
    }

    @Override
    public String toString() {
        return pieceColor + " " + pieceType + " at " + currentCell;
    }
}
