package com.mauricio.chess.dynamics;

import com.mauricio.chess.element.Board;
import com.mauricio.chess.element.Cell;
import com.mauricio.chess.element.PieceColor;
import com.mauricio.chess.element.PieceType;

public class NotationParser {

    //    B: Bishop
    //    R: Rook
    //    Q: Queen
    //    K: King
    //    N: kNight
    //    none: pawn
    public static Move parseMove(String move, PieceColor pieceColor, Board board) {
        int charIndex = 0;
        PieceType pieceType = PieceType.getPieceType(move.substring(charIndex, charIndex + 1));
        if(move.length() > 2) {
            charIndex++;
        }
        String file = move.substring(charIndex, charIndex + 1);
        charIndex++;
        Integer rank = Integer.valueOf(move.substring(charIndex, charIndex + 1));
        Cell moveTo = board.getCell(file + rank);
        return new Move(pieceColor, pieceType, moveTo);
    }

}
