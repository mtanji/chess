package com.mauricio.chess.dynamics;

import com.mauricio.chess.element.Board;
import com.mauricio.chess.element.Piece;
import com.mauricio.chess.element.PieceType;
import java.util.List;
import java.util.Map;

public class MovingPieceFinder {

    private final Board board;
    private final Move move;

    public MovingPieceFinder(Board board, Move move) {
        this.board = board;
        this.move = move;
    }

    public Piece find() {
        Map<PieceType, List<Piece>> pieces = board.getPieces(move.getColor());
        List<Piece> pieceOfType = pieces.get(move.getPieceType());
        for (Piece piece : pieceOfType) {
            if (piece.allowed(move.getMoveTo())) {
                return piece;
            }
        }
        throw new IllegalArgumentException(
                "There is no piece of type " + move.getPieceType() + " that can be moved to " + move.getMoveTo());
    }
}
