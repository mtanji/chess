package com.mauricio.chess.element;

public class Cell {

    private final String file;
    private final Integer rank;
    private Piece piece;

    public Cell(String file, Integer rank) {
        this.file = file;
        this.rank = rank;
    }

    public String getFile() {
        return file;
    }

    public Integer getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return file + rank;
    }
}
