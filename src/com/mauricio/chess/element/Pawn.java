package com.mauricio.chess.element;

public class Pawn extends Piece {

    private boolean firstMove = true;

    Pawn(Board board, Cell currentCell, PieceColor color) {
        super(board, currentCell, color);
        currentCell.setPiece(this);
    }

    @Override
    public boolean allowed(Cell moveTo) {
        if (pieceColor == PieceColor.WHITE) {
            if (firstMove) {
                firstMove = false;
                return isValidWhiteFirstMove(moveTo) || isWhiteCapture(moveTo);
            } else {
                return isValidWhiteMove(moveTo) || isWhiteCapture(moveTo);
            }
        } else {
            if (firstMove) {
                firstMove = false;
                return isValidBlackFirstMove(moveTo);
            } else {
                return isValidBlackMove(moveTo);
            }
        }
    }


    @Override
    protected PieceType getType() {
        return PieceType.Pawn;
    }

    private boolean isValidWhiteFirstMove(Cell moveTo) {
        return isWhiteMoveForward(moveTo, 1) || isWhiteMoveForward(moveTo, 2);
    }

    private boolean isValidWhiteMove(Cell moveTo) {
        return isWhiteMoveForward(moveTo, 1);
    }

    private boolean isWhiteMoveForward(Cell moveTo, int step) {
        return moveTo.getRank() == currentCell.getRank() + step && moveTo.getFile().equals(currentCell.getFile());
    }

    private boolean isWhiteCapture(Cell moveTo) {
        // TODO
        //moveTo.getRank() == currentCell.getRank() + 1 && isNeighborFile(moveTo) && isCellOccupied(moveTo);
        return true;
    }

    private boolean isNeighborFile(Cell moveTo) {
        int moveToFileNumber =  FileMapping.fileToFileNumber.get(moveTo.getFile());
        int currentCellFileNumber = FileMapping.fileToFileNumber.get(currentCell.getFile());
        return Math.abs(moveToFileNumber - currentCellFileNumber) == 1;
    }

    private boolean isValidBlackFirstMove(Cell moveTo) {
        return (moveTo.getRank() == currentCell.getRank() - 1 || moveTo.getRank() == currentCell.getRank() - 2)
                && moveTo.getFile().equals(currentCell.getFile());
    }

    private boolean isValidBlackMove(Cell moveTo) {
        // TODO
        return true;
    }

}
