package com.mauricio.chess.element;

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
            pawns.add(new Piece(pieceColor, PieceType.Pawn));
        }
        pieceSet.put(PieceType.Pawn, pawns);

        pieceSet.put(PieceType.Rook,
                Arrays.asList(new Piece(pieceColor, PieceType.Rook), new Piece(pieceColor, PieceType.Rook)));
        pieceSet.put(PieceType.Knight,
                Arrays.asList(new Piece(pieceColor, PieceType.Knight), new Piece(pieceColor, PieceType.Knight)));
        pieceSet.put(PieceType.Bishop,
                Arrays.asList(new Piece(pieceColor, PieceType.Bishop), new Piece(pieceColor, PieceType.Bishop)));
        pieceSet.put(PieceType.Queen, Arrays.asList(new Piece(pieceColor, PieceType.Queen)));
        pieceSet.put(PieceType.King, Arrays.asList(new Piece(pieceColor, PieceType.King)));
    }

    List<Piece> getPiecesOfType(PieceType pieceType) {
        return pieceSet.get(pieceType);
    }

}
