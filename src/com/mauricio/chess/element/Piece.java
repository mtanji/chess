package com.mauricio.chess.element;

public abstract class Piece {

    protected final Board board;
    protected final PieceColor pieceColor;
    protected Cell currentCell;

    Piece(Board board, Cell currentCell, PieceColor pieceColor) {
        this.pieceColor = pieceColor;
        this.currentCell = currentCell;
        this.board = board;
    }

    void move(Cell cell) {
        // remove piece reference in previous position
        currentCell.setPiece(null);
        currentCell = cell;
        // set piece reference into new position
        currentCell.setPiece(this);
    }

    abstract public boolean allowed(Cell cell);

    abstract protected PieceType getType();

    @Override
    public String toString() {
        return pieceColor + " " + getType() + " from " + currentCell;
    }
}
