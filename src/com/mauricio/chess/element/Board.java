package com.mauricio.chess.element;

import com.mauricio.chess.dynamics.Game;
import java.util.HashMap;
import java.util.Map;

public class Board {

    private static final int BOARD_LENGTH = 8;
    private static final Map<Integer, String> fileNumberToFile = new HashMap<>();
    private static final Map<String, Integer> fileToFileNumber = new HashMap<>();

    static {
        fileNumberToFile.put(0, "a");
        fileNumberToFile.put(1, "b");
        fileNumberToFile.put(2, "c");
        fileNumberToFile.put(3, "d");
        fileNumberToFile.put(4, "e");
        fileNumberToFile.put(5, "f");
        fileNumberToFile.put(6, "g");
        fileNumberToFile.put(7, "h");

        fileToFileNumber.put("a", 0);
        fileToFileNumber.put("b", 1);
        fileToFileNumber.put("c", 2);
        fileToFileNumber.put("d", 3);
        fileToFileNumber.put("e", 4);
        fileToFileNumber.put("f", 5);
        fileToFileNumber.put("g", 6);
        fileToFileNumber.put("h", 7);
    }

    private final Game game;
    Cell[][] cells = new Cell[BOARD_LENGTH][BOARD_LENGTH];

    public Board(Game game) {
        this.game = game;
        for (int file = 0; file < BOARD_LENGTH; file++) {
            for (int rank = 0; rank < BOARD_LENGTH; rank++) {
                cells[file][rank] = new Cell(fileNumberToFile.get(file), rank);
            }
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
