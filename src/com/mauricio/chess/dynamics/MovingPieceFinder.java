package com.mauricio.chess.dynamics;

import com.mauricio.chess.element.Board;
import com.mauricio.chess.element.Piece;
import com.mauricio.chess.element.Player;
import java.util.List;

public class MovingPieceFinder {

    private final Board board;
    private final Move move;

    public MovingPieceFinder(Board board, Move move) {
        this.board = board;
        this.move = move;
    }

    public Piece find() {
        Player player = board.getPieces(move.getColor());
        List<Piece> pieceOfType = player.getPiecesOfType(move.getPieceType());
        for (Piece piece : pieceOfType) {
            if (piece.canMove(move.getMoveTo())) {
                return piece;
            }
        }
        throw new IllegalArgumentException(
                "There is no piece of type " + move.getPieceType() + " that can be moved to " + move.getMoveTo());
    }
}
