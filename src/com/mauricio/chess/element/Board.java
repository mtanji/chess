package com.mauricio.chess.element;

import com.mauricio.chess.dynamics.Game;
import com.mauricio.chess.dynamics.Move;
import com.mauricio.chess.dynamics.MovingPieceFinder;
import com.mauricio.chess.dynamics.NotationParser;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Board {

    private static final int BOARD_LENGTH = 8;
    private Game game;
    //    private final Map<PieceColor, Map<PieceType, List<Piece>>> pieces = new HashMap<>();
    private final Map<String, Cell> cells = new TreeMap<>();

    public Board(){} // TODO remove after refactor and change game to final
    public Board(Game game) {
        this.game = game;
        // build all board cells
        for (int fileNumber = 1; fileNumber <= BOARD_LENGTH; fileNumber++) {
            for (int rank = 1; rank <= BOARD_LENGTH; rank++) {
                String file = FileMapping.fileNumberToFile.get(fileNumber);
                Cell cell = new Cell(file, rank);
                cells.put(cell.toString(), cell);
            }
        }

        // build all pieces
        // iterate over piece colors
        for (Map.Entry<PieceColor, Map<PieceType, List<String>>> sameColorPieces : InitialSetup.setup.entrySet()) {
            PieceColor pieceColor = sameColorPieces.getKey();
//            pieces.put(pieceColor, new HashMap<>());
            Player player = game.getPlayer(pieceColor);
            // iterate over piece types
            for (Map.Entry<PieceType, List<String>> sameTypePieces : sameColorPieces.getValue().entrySet()) {
                PieceType pieceType = sameTypePieces.getKey();
                List<Piece> sameColorTypePieces = player.getPiecesOfType(pieceType);
                List<String> cellCodesForPieceType = sameTypePieces.getValue();

                for (int i = 0; i < cellCodesForPieceType.size(); i++) {
                    String cellCode = cellCodesForPieceType.get(i);
                    Cell cell = cells.get(cellCode);
                    sameColorTypePieces.get(i).move(cell);
                }

//                for (String cellCode : sameTypePieces.getValue()) {
//                    Piece piece;
//                    switch(pieceType) {
//                        case Pawn:
//                            piece = new Pawn(this, cells.get(cellCode), pieceColor);
//                            break;
//                        case Rook:
//                            piece = new Rook(this, cells.get(cellCode), pieceColor);
//                            break;
//                        case Knight:
//                            piece = new Knight(this, cells.get(cellCode), pieceColor);
//                            break;
//                        case Bishop:
//                            piece = new Bishop(this, cells.get(cellCode), pieceColor);
//                            break;
//                        case Queen:
//                            piece = new Queen(this, cells.get(cellCode), pieceColor);
//                            break;
//                        case King:
//                            piece = new King(this, cells.get(cellCode), pieceColor);
//                            break;
//                        default:
//                            throw new IllegalStateException("piece type is invalid");
//                    }
//                    sameColorTypePieces.add(piece);
//                }
//                pieces.get(pieceColor).put(pieceType, sameColorTypePieces);
            }
        }
    }

    public void move(String moveStr, PieceColor pieceColor) {

        // validate move
        Move move = NotationParser.parseMove(moveStr, pieceColor, this);

        // validate move
        MovingPieceFinder movingPieceFinder = new MovingPieceFinder(this, move);
        Piece piece = movingPieceFinder.find();
        Cell moveTo = cells.get(move.getMoveTo().getId());
        if (moveTo.hasPiece()) {
            game.pieceCaptured(moveTo.getPiece());
        }
        piece.move(moveTo);

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

    public Player getPieces(PieceColor color) {
        return game.getPlayer(color);
    }

    public Cell getCell(String cellCode) {
        return cells.get(cellCode);
    }

    private boolean isCheck(PieceColor color) {
        return Math.random() > 0.5;
    }

    private boolean isCheckMate(PieceColor color) {
        return Math.random() > 0.5;
    }
}
