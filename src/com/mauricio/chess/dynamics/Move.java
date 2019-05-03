package com.mauricio.chess.dynamics;

import com.mauricio.chess.element.Cell;
import com.mauricio.chess.element.PieceColor;
import com.mauricio.chess.element.PieceType;

public class Move {

    private final PieceColor color;
    private final PieceType pieceType;
    private final Cell moveTo;

    Move(PieceColor color, PieceType pieceType, Cell moveTo) {
        this.color = color;
        this.pieceType = pieceType;
        this.moveTo = moveTo;
    }

    PieceColor getColor() {
        return color;
    }

    PieceType getPieceType() {
        return pieceType;
    }

    public Cell getMoveTo() {
        return moveTo;
    }
}
