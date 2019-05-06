package com.mauricio.chess.dynamics;

import com.mauricio.chess.element.Board;
import com.mauricio.chess.element.Piece;
import com.mauricio.chess.element.Player;
import java.util.List;
import java.util.stream.Collectors;

public class MovingPieceFinder {

    private final Board board;
    private final Move move;

    public MovingPieceFinder(Board board, Move move) {
        this.board = board;
        this.move = move;
    }

    /**
     * Find the {@link Piece} that can be moved according to provided algebraic notated move
     * @return
     */
    public Piece find() {
        Player player = board.getPieces(move.getColor());
        // find pieces of a certain type from current player
        List<Piece> pieceOfType = player.getPiecesOfType(move.getPieceType()).stream()
                // consider pieces that are still in the game
                .filter(piece -> piece.getCell() != null)
                .collect(Collectors.toList());
        for (Piece piece : pieceOfType) {
            // calls injected PieceMove behavior to verify if that piece can reach the position pointed by user input
            if (piece.canMove(move.getMoveTo())) {
                return piece;
            }
        }
        throw new IllegalArgumentException(
                "There is no piece of type " + move.getPieceType() + " that can be moved to " + move.getMoveTo());
    }
}
