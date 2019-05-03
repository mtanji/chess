package com.mauricio.chess.element;

public abstract class Piece {

    private final PieceColor color;

    Piece(PieceColor color) {
        this.color = color;
    }

    abstract void move(Cell cell);

    abstract boolean allowed(Cell cell);
}
