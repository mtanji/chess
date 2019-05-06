package com.mauricio.chess.element;

import com.mauricio.chess.dynamics.move.PieceMove;

public class Piece {

    private final PieceColor pieceColor;
    private final PieceType pieceType;
    // injected allowed piece move, according to its PieceType
    private final PieceMove pieceMove;
    private Cell currentCell;

    Piece(PieceColor pieceColor, PieceType pieceType, PieceMove pieceMove) {
        this.pieceColor = pieceColor;
        this.pieceType = pieceType;
        this.pieceMove = pieceMove;
    }

    void move(Cell cell) {
        // remove piece reference in previous position
        if (currentCell != null) {
            currentCell.setPiece(null);
        }

        // set piece reference into new position
        currentCell = cell;

        // removes captured piece from board
        Piece capturedPiece = cell.getPiece();
        if (capturedPiece != null) {
            capturedPiece.remove();
        }
        currentCell.setPiece(this);
    }

    void remove() {
        currentCell = null;
    }

    public boolean canMove(Cell toCell) {
        return pieceMove.canMove(this, toCell);
    }

    public Cell getCell() {
        return currentCell;
    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    @Override
    public String toString() {
        return pieceColor + " " + pieceType + " at " + currentCell;
    }
}
