package com.mauricio.chess.element;

public class Cell {
    private final String file;
    private final Integer rank;
    private Piece piece;

    Cell(String file, Integer rank) {
        this.file = file;
        this.rank = rank;
    }
}
