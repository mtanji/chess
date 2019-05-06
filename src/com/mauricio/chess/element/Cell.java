package com.mauricio.chess.element;

/**
 * Represents a position in chess board for a given file and rank
 */
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

    /**
     * Unique identifier that grants {@link java.util.Map} does not present {@link Cell} identifier collisions.
     * @return
     */
    String getId() {
        return file + rank;
    }

    /**
     * Helper method to ease move validation
     */
    public boolean sameFile(Cell cell) {
        return this.file.equals(cell.getFile());
    }

    /**
     * Helper method to ease move validation
     */
    public boolean sameRank(Cell cell) {
        return this.rank.equals(cell.getRank());
    }

    /**
     * Helper method to ease move validation
     */
    public int rankDistanceTo(Cell cell) {
        return cell.getRank() - this.rank;
    }

    /**
     * Helper method to ease move validation
     */
    public int fileDistanceTo(Cell cell) {
        return FileMapping.fileToFileNumber.get(cell.getFile()) - FileMapping.fileToFileNumber.get((this.file));
    }

    @Override
    public String toString() {
        return getId();
    }
}
