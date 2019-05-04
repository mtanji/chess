package com.mauricio.chess.element;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PieceSet {

//    private final PieceColor pieceColor;
    private final Map<PieceType, List<Piece>> pieceSet;

    PieceSet(PieceColor pieceColor) {
//        this.pieceColor = pieceColor;
        pieceSet = new HashMap<>();

        List<Piece> pawns = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            pawns.add(new FullPiece(pieceColor, PieceType.Pawn, i));
        }
        pieceSet.put(PieceType.Pawn, pawns);

        pieceSet.put(PieceType.Rook,
                Arrays.asList(new FullPiece(pieceColor, PieceType.Rook, 0), new FullPiece(pieceColor, PieceType.Rook, 1)));
        pieceSet.put(PieceType.Knight,
                Arrays.asList(new FullPiece(pieceColor, PieceType.Knight, 0), new FullPiece(pieceColor, PieceType.Knight, 1)));
        pieceSet.put(PieceType.Bishop,
                Arrays.asList(new FullPiece(pieceColor, PieceType.Bishop, 0), new FullPiece(pieceColor, PieceType.Bishop, 1)));
        pieceSet.put(PieceType.Queen, Arrays.asList(new FullPiece(pieceColor, PieceType.Queen, 0)));
        pieceSet.put(PieceType.King, Arrays.asList(new FullPiece(pieceColor, PieceType.King, 0)));
    }

    List<Piece> getPiecesOfType(PieceType pieceType) {
        return pieceSet.get(pieceType);
    }

}
