package com.mauricio.chess.element;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum PieceType {
    Pawn(""),
    Bishop("B"),
    Rook("R"),
    Queen("Q"),
    King("K"),
    Knight("N");

    private static Set<String> pieceChars = new HashSet<>(Arrays.asList("B", "R", "Q", "K", "N"));
    String notation;

    PieceType(String notation) {
        this.notation = notation;
    }

    public static PieceType getPieceType(String pieceCode) {
        switch (pieceCode) {
            case "B":
                return PieceType.Bishop;
            case "R":
                return PieceType.Rook;
            case "Q":
                return PieceType.Queen;
            case "K":
                return PieceType.King;
            case "N":
                return PieceType.Knight;
            default:
                if (FileMapping.fileCodesSet.contains(pieceCode)) {
                    return PieceType.Pawn;
                }
                throw new IllegalArgumentException(
                        "Invalid piece code. Piece code must be either B, R, Q, K, N or absent in case of pawn");
        }
    }

    public static boolean isPieceTypeCode(String character) {
        return pieceChars.contains(character);
    }
}
