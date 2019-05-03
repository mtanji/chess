package com.mauricio.chess.element;

import com.mauricio.chess.dynamics.Game;
import com.mauricio.chess.dynamics.Move;
import com.mauricio.chess.dynamics.MovingPieceFinder;
import com.mauricio.chess.dynamics.NotationParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Board {

    static final Set<String> fileCodes = new HashSet<>(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h"));

    private static final int BOARD_LENGTH = 8;
    private final Game game;
    private final Map<PieceType, List<Piece>> whitePieces = new HashMap<>();
    private final Map<PieceType, List<Piece>> blackPieces = new HashMap<>();
    private final Map<String, Cell> cells = new HashMap<>();

    public Board(Game game) {
        this.game = game;
        // build all board cells
        for (int fileNumber = 1; fileNumber <= BOARD_LENGTH; fileNumber++) {
            for (int rank = 1; rank <= BOARD_LENGTH; rank++) {
                String file = FileMapping.fileNumberToFile.get(fileNumber);
                cells.put(file + rank, new Cell(file, rank));
            }
        }

        for (int fileNumber = 1; fileNumber <= BOARD_LENGTH; fileNumber++) {
            String file = FileMapping.fileNumberToFile.get(fileNumber);

            // white pawns
            if(!whitePieces.containsKey(PieceType.Pawn)) {
                whitePieces.put(PieceType.Pawn, new ArrayList<>());
            }
            whitePieces.get(PieceType.Pawn).add(new Pawn(this, cells.get(file + 2), PieceColor.WHITE));

            // black pawns
            if(!blackPieces.containsKey(PieceType.Pawn)) {
                blackPieces.put(PieceType.Pawn, new ArrayList<>());
            }
            blackPieces.get(PieceType.Pawn).add(new Pawn(this, cells.get(file + 7), PieceColor.BLACK));
        }
    }

    public void move(String moveStr, PieceColor pieceColor) {

        // validate move
        Move move = NotationParser.parseMove(moveStr, pieceColor);

        // validate move
        MovingPieceFinder movingPieceFinder = new MovingPieceFinder(this, move);
        Piece piece = movingPieceFinder.find();

        // verify check or checkmate
        if (isCheck(pieceColor)) {
            // send check message
            game.check();
        } else if (isCheckMate(pieceColor)) {
            // send checkmate message
            game.setWinner(pieceColor);
            game.end();
        }

    }

    public Map<PieceType, List<Piece>> getPieces(PieceColor color) {
        return color == PieceColor.WHITE ? whitePieces : blackPieces;
    }

    private boolean isCheck(PieceColor color) {
        return Math.random() > 0.5;
    }

    private boolean isCheckMate(PieceColor color) {
        return Math.random() > 0.5;
    }
}
