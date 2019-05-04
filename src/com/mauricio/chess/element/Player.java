package com.mauricio.chess.element;

import java.util.List;

public class Player {

    private final PieceColor pieceColor;
    private final PieceSet pieceSet;

    public Player(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
        this.pieceSet = new PieceSet(pieceColor);
    }

    public PieceColor getType() {
        return pieceColor;
    }

    public List<Piece> getPiecesOfType(PieceType pieceType) {
        return pieceSet.getPiecesOfType(pieceType);
    }
}
