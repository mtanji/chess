package com.mauricio.chess.element;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * See {@linktourl  https://en.wikipedia.org/wiki/Rules_of_chess#Initial_setup}
 */
public class ResetBoard {
    public static Map<PieceColor, Map<PieceType, List<String>>> piecesInitialPosition = new HashMap<>();
    static {
        piecesInitialPosition.put(PieceColor.WHITE, new HashMap<>());
        piecesInitialPosition.get(PieceColor.WHITE).put(PieceType.Pawn, Arrays.asList("a2", "b2", "c2", "d2", "e2", "f2", "g2", "h2"));
        piecesInitialPosition.get(PieceColor.WHITE).put(PieceType.Rook, Arrays.asList("a1", "h1"));
        piecesInitialPosition.get(PieceColor.WHITE).put(PieceType.Knight, Arrays.asList("b1", "g1"));
        piecesInitialPosition.get(PieceColor.WHITE).put(PieceType.Bishop, Arrays.asList("c1", "f1"));
        piecesInitialPosition.get(PieceColor.WHITE).put(PieceType.Queen, Arrays.asList("d1"));
        piecesInitialPosition.get(PieceColor.WHITE).put(PieceType.King, Arrays.asList("e1"));

        piecesInitialPosition.put(PieceColor.BLACK, new HashMap<>());
        piecesInitialPosition.get(PieceColor.BLACK).put(PieceType.Pawn, Arrays.asList("a7", "b7", "c7", "d7", "e7", "f7", "g7", "h7"));
        piecesInitialPosition.get(PieceColor.BLACK).put(PieceType.Rook, Arrays.asList("a8", "h8"));
        piecesInitialPosition.get(PieceColor.BLACK).put(PieceType.Knight, Arrays.asList("b8", "g8"));
        piecesInitialPosition.get(PieceColor.BLACK).put(PieceType.Bishop, Arrays.asList("c8", "f8"));
        piecesInitialPosition.get(PieceColor.BLACK).put(PieceType.Queen, Arrays.asList("d8"));
        piecesInitialPosition.get(PieceColor.BLACK).put(PieceType.King, Arrays.asList("e8"));
    }
    List<String> whitePaws = Arrays.asList("a2", "b2", "c2", "d2", "e2", "f2", "g2", "h2");
    List<String> whiteRooks = Arrays.asList("a1", "h1");
}
