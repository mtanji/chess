package com.mauricio.chess.element;

import com.mauricio.chess.dynamics.Game;
import com.mauricio.chess.dynamics.Move;
import com.mauricio.chess.dynamics.MoveResult;
import com.mauricio.chess.dynamics.MovingPieceFinder;
import com.mauricio.chess.dynamics.NotationParser;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Board {

    private static final int BOARD_LENGTH = 8;
    private final Game game;
    // use TreeMap to ease debugging
    private final Map<String, Cell> cells = new TreeMap<>();

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

        // position all pieces on the board
        // iterate over piece colors
        for (Map.Entry<PieceColor, Map<PieceType, List<String>>> sameColorPieces : InitialSetup.setup.entrySet()) {
            PieceColor pieceColor = sameColorPieces.getKey();
            Player player = game.getPlayer(pieceColor);
            // iterate over piece types
            for (Map.Entry<PieceType, List<String>> sameTypePieces : sameColorPieces.getValue().entrySet()) {
                PieceType pieceType = sameTypePieces.getKey();
                List<Piece> sameColorTypePieces = player.getPiecesOfType(pieceType);
                List<String> cellCodesForPieceType = sameTypePieces.getValue();
                // iterate over pieces of same type
                for (int i = 0; i < cellCodesForPieceType.size(); i++) {
                    String cellCode = cellCodesForPieceType.get(i);
                    Cell cell = cells.get(cellCode);
                    sameColorTypePieces.get(i).move(cell);
                }
            }
        }
    }

    public MoveResult move(String moveStr, PieceColor pieceColor) {
        // validate move
        Move move = NotationParser.parseMove(moveStr, pieceColor, this);

        // move
        MovingPieceFinder movingPieceFinder = new MovingPieceFinder(this, move);
        Piece piece = movingPieceFinder.find();
        Cell moveTo = cells.get(move.getMoveTo().getId());
        if (moveTo.hasPiece()) {
            game.pieceCaptured(moveTo.getPiece());
        }
        piece.move(moveTo);

        // verify check or checkmate
        if (isCheck(pieceColor)) {
            if (canEscape(pieceColor)) {
                return MoveResult.CHECK;
            } else {
                return MoveResult.CHECK_MATE;
            }
        }
        return MoveResult.CONTINUE;
    }

    public Player getPieces(PieceColor color) {
        return game.getPlayer(color);
    }

    public Cell getCell(String cellCode) {
        Cell cell = cells.get(cellCode);
        if (cell == null) {
            throw new NoSuchElementException("Cell with code " + cellCode + " was not found");
        }
        return cell;
    }

    private boolean isCheck(PieceColor justMovedColor) {
        // verify if King of opponent is at check
        Piece opponentKing = getOpponentKing(justMovedColor);
        Cell opponentKingCell = opponentKing.getCell();

        return isCheckAt(justMovedColor, opponentKingCell);
    }

    private boolean isCheckAt(PieceColor justMovedColor, Cell opponentKingCell) {
        Player checkingPlayer = getPieces(justMovedColor);
        List<Piece> checkingPieces = checkingPlayer.getAllPieces().stream()
                .filter(piece -> piece.getCell() != null)
                .collect(Collectors.toList());
        boolean isCheck = false;
        for (Piece piece : checkingPieces) {
            isCheck = piece.canMove(opponentKingCell);
            if (isCheck) {
                break;
            }
        }
        return isCheck;
    }

    private Piece getOpponentKing(PieceColor justMovedColor) {
        Player player;
        if (justMovedColor == PieceColor.WHITE) {
            player = getPieces(PieceColor.BLACK);
        } else {
            player = getPieces(PieceColor.WHITE);
        }
        return player.getPiecesOfType(PieceType.King).get(0);
    }

    private boolean canEscape(PieceColor justMovedColor) {
        // verify if King of opponent can escape
        // King cannot escape if after any possible move, he is on check
        boolean canEscape = false;

        Piece opponentKing = getOpponentKing(justMovedColor);
        List<Cell> kingNeighborhood = getFreeKingNeighborhood(opponentKing);

        for (Cell cell : kingNeighborhood) {
            if (!isCheckAt(justMovedColor, cell)) {
                canEscape = true;
                break;
            }
        }
        return canEscape;
    }

    private List<Cell> getFreeKingNeighborhood(Piece king) {
        List<Cell> neighborhood = new ArrayList<>();
        int kingRank = king.getCell().getRank();
        int kingFile = FileMapping.fileToFileNumber.get(king.getCell().getFile());
        for (int rank = kingRank - 1; rank <= kingRank + 1; rank++) {
            for (int fileNumb = kingFile - 1; fileNumb <= kingFile + 1; fileNumb++) {
                String file = FileMapping.fileNumberToFile.get(fileNumb);
                String cellKey = file + rank;
                neighborhood.add(cells.get(cellKey));
            }
        }
        neighborhood = neighborhood.stream()
                .filter(cell -> cell != null)
                .filter(cell -> !cell.hasPiece())
                .collect(Collectors.toList());
        return neighborhood;
    }
}
