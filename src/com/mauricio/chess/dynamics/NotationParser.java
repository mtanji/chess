package com.mauricio.chess.dynamics;

import com.mauricio.chess.element.Board;
import com.mauricio.chess.element.Cell;
import com.mauricio.chess.element.PieceColor;
import com.mauricio.chess.element.PieceType;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class NotationParser {

    //    B: Bishop
    //    R: Rook
    //    Q: Queen
    //    K: King
    //    N: kNight
    //    none: pawn
    public static Move parseMove(String move, PieceColor pieceColor, Board board) {
        try {
            LinkedList<String> moveStream = new LinkedList<>(Arrays.asList(move.split("")));
            String first = moveStream.removeFirst();
            PieceType pieceType = PieceType.getPieceType(first);
            String cellCode;
            if (!PieceType.isPieceTypeCode(first)) {
                cellCode = first;
            } else {
                cellCode = moveStream.removeFirst();
            }
            cellCode += moveStream.removeFirst();
            Cell moveTo = board.getCell(cellCode);
            return new Move(pieceColor, pieceType, moveTo);
        } catch (NoSuchElementException nsee) {
            throw new IllegalArgumentException("Algebraic chess notation is invalid: " + nsee.getMessage(), nsee);
        }
    }

}
