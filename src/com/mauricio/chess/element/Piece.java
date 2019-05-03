package com.mauricio.chess.element;

public abstract class Piece {

    protected final PieceColor pieceColor;

    Piece(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    abstract void move(Cell cell);

    abstract public boolean allowed(Cell cell);
}
