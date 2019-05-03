package com.mauricio.chess.element;

import com.mauricio.chess.dynamics.Game;
import java.util.HashMap;
import java.util.Map;

public class Board {

    private static final int BOARD_LENGTH = 8;
    private static final Map<Integer, String> fileNumberToFile = new HashMap<>();
    private static final Map<String, Integer> fileToFileNumber = new HashMap<>();

    static {
        fileNumberToFile.put(1, "a");
        fileNumberToFile.put(2, "b");
        fileNumberToFile.put(3, "c");
        fileNumberToFile.put(4, "d");
        fileNumberToFile.put(5, "e");
        fileNumberToFile.put(6, "f");
        fileNumberToFile.put(7, "g");
        fileNumberToFile.put(8, "h");

        fileToFileNumber.put("a", 1);
        fileToFileNumber.put("b", 2);
        fileToFileNumber.put("c", 3);
        fileToFileNumber.put("d", 4);
        fileToFileNumber.put("e", 5);
        fileToFileNumber.put("f", 6);
        fileToFileNumber.put("g", 7);
        fileToFileNumber.put("h", 8);
    }

    private final Game game;
    private final Map<String, Piece> whitePieces = new HashMap<>();
    private final Map<String, Piece> blackPieces = new HashMap<>();
    private final Map<String, Cell> cells = new HashMap<>();

    public Board(Game game) {
        this.game = game;
        for (int fileNumber = 0; fileNumber < BOARD_LENGTH; fileNumber++) {
            for (int rank = 1; rank <= BOARD_LENGTH; rank++) {
                String file = fileNumberToFile.get(fileNumber);
                cells.put(file + rank, new Cell(file, rank));
            }
        }

        for (int fileNumber = 0; fileNumber < BOARD_LENGTH; fileNumber++) {
            String file = fileNumberToFile.get(fileNumber);

            // white pawns
            whitePieces.put("pawn" + fileNumber, new Pawn(cells.get(file + 2), PieceColor.WHITE));

            // black pawns
            blackPieces.put("pawn" + fileNumber, new Pawn(cells.get(file + 7), PieceColor.BLACK));
        }
    }

    public void move(String move, PieceColor color) {
        // validate move

        // verify check or checkmate
        if (isCheck(color)) {
            // send check message
            game.check();
        } else if (isCheckMate(color)) {
            // send checkmate message
            game.setWinner(color);
            game.end();
        }

    }

    private boolean isCheck(PieceColor color) {
        return Math.random() > 0.5;
    }

    private boolean isCheckMate(PieceColor color) {
        return Math.random() > 0.5;
    }
}
