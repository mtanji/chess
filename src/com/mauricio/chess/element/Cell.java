package com.mauricio.chess.element;

public class Cell {

    private final String file;
    private final Integer rank;
    private Piece piece;

    public Cell(String file, Integer rank) {
        this.file = file;
        this.rank = rank;
    }

    void setPiece(Piece piece) {
        this.piece = piece;
    }

    Piece getPiece() {
        return piece;
    }

    boolean hasPiece() {
        return piece != null;
    }

    String getFile() {
        return file;
    }

    Integer getRank() {
        return rank;
    }

    String getId() {
        return file + rank;
    }

    @Override
    public String toString() {
        return getId();
    }
}
