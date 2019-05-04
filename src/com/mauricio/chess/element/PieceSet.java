package com.mauricio.chess.element;

import com.mauricio.chess.dynamics.move.BishopMove;
import com.mauricio.chess.dynamics.move.KnightMove;
import com.mauricio.chess.dynamics.move.PawnMove;
import com.mauricio.chess.dynamics.move.QueenMove;
import com.mauricio.chess.dynamics.move.RookMove;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PieceSet {

    private final Map<PieceType, List<Piece>> pieceSet;

    PieceSet(PieceColor pieceColor) {
        pieceSet = new HashMap<>();

        List<Piece> pawns = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            pawns.add(new Piece(pieceColor, PieceType.Pawn, new PawnMove()));
        }
        pieceSet.put(PieceType.Pawn, pawns);

        pieceSet.put(PieceType.Rook,
                Arrays.asList(new Piece(pieceColor, PieceType.Rook, new RookMove()),
                        new Piece(pieceColor, PieceType.Rook, new RookMove())));
        pieceSet.put(PieceType.Knight,
                Arrays.asList(new Piece(pieceColor, PieceType.Knight, new KnightMove()),
                        new Piece(pieceColor, PieceType.Knight, new KnightMove())));
        pieceSet.put(PieceType.Bishop,
                Arrays.asList(new Piece(pieceColor, PieceType.Bishop, new BishopMove()),
                        new Piece(pieceColor, PieceType.Bishop, new BishopMove())));
        pieceSet.put(PieceType.Queen, Arrays.asList(new Piece(pieceColor, PieceType.Queen, new QueenMove())));
        pieceSet.put(PieceType.King, Arrays.asList(new Piece(pieceColor, PieceType.King, new KnightMove())));
    }

    List<Piece> getPiecesOfType(PieceType pieceType) {
        return pieceSet.get(pieceType);
    }

}
