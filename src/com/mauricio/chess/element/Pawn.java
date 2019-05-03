package com.mauricio.chess.element;

public class Pawn extends Piece {

    private Cell currentCell;

    Pawn(Cell currentCell, PieceColor color) {
        super(color);
        this.currentCell = currentCell;
    }

    @Override
    void move(Cell cell) {

    }

    @Override
    boolean allowed(Cell cell) {
        return false;
    }
}
