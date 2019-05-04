package com.mauricio.chess.element;

public class FullPiece extends Piece {

    private final PieceColor pieceColor;
    private final PieceType pieceType;
    private final int index;
    //    private final Board board;
    private Cell currentCell;

    FullPiece(PieceColor pieceColor, PieceType pieceType, int index/*, Board board*/) {
        super(new Board(), new Cell("", 1), pieceColor); // TODO remove after refactor
        this.pieceColor = pieceColor;
        this.pieceType = pieceType;
        this.index = index;
//        this.board = board;
//        this.currentCell = currentCell;
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
        return true;
    }//TODO remove after refactor

    protected PieceType getType() {
        return pieceType;
    }//TODO remove after refactor

    @Override
    public String toString() {
        return pieceColor + " " + pieceType + " at " + currentCell;
    }
}