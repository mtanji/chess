package com.mauricio.chess.element;

public class Cell {

    private final String file;
    private final Integer rank;
    private Piece piece;

    public Cell(String file, Integer rank) {
        this.file = file;
        this.rank = rank;
    }

    Piece getPiece() {
        return piece;
    }

    void setPiece(Piece piece) {
        this.piece = piece;
    }

    boolean hasPiece() {
        return piece != null;
    }

    public String getFile() {
        return file;
    }

    public Integer getRank() {
        return rank;
    }

    String getId() {
        return file + rank;
    }

    public boolean sameFile(Cell cell) {
        return this.file.equals(cell.getFile());
    }

    public boolean sameRank(Cell cell) {
        return this.rank.equals(cell.getRank());
    }

    public int rankDistanceTo(Cell cell) {
        return cell.getRank() - this.rank;
    }

    public int fileDistanceTo(Cell cell) {
        return FileMapping.fileToFileNumber.get(cell.getFile()) - FileMapping.fileToFileNumber.get((this.file));
    }

    @Override
    public String toString() {
        return getId();
    }
}
