package com.mauricio.chess.dynamics;

import com.mauricio.chess.element.Board;
import com.mauricio.chess.element.Piece;
import com.mauricio.chess.element.PieceColor;
import com.mauricio.chess.element.Player;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {

    private final Scanner sc = new Scanner(System.in);
    private final Board board;
    private final Map<PieceColor, Player> players = new HashMap<>();

    private boolean gameOnGoing = true;
    private PieceColor winner;

    public Game() {
        Player player = new Player(PieceColor.WHITE);
        players.put(player.getType(), player);
        player = new Player(PieceColor.BLACK);
        players.put(player.getType(), player);
        board = new Board(this);
    }

    public void start() {
        MoveResult moveResult;
        // while there is no winner alternate white and black
        while (gameOnGoing) {
            moveResult = whiteMove();
            if (moveResult == MoveResult.CHECK) {
                check();
            } else if (moveResult == MoveResult.CHECK_MATE) {
                setWinner(PieceColor.WHITE);
                gameOnGoing = false;
                continue;
            }
            moveResult = blackMove();
            if (moveResult == MoveResult.CHECK) {
                check();
            } else if (moveResult == MoveResult.CHECK_MATE) {
                setWinner(PieceColor.BLACK);
                gameOnGoing = false;
            }
        }
    }

    /**
     * Retry while user does not provide valid move
     */
    private MoveResult whiteMove() {
        MoveResult moveResult = null;
        boolean moveOk = false;
        do {
            try {
                // read white move
                System.out.println("White move: ");
                String whiteMove = sc.nextLine();

                // move white piece
                moveResult = board.move(whiteMove, PieceColor.WHITE);
                moveOk = true;
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        } while (!moveOk);
        return moveResult;
    }

    private MoveResult blackMove() {
        MoveResult moveResult = null;
        boolean moveOk = false;
        do {
            try {
                // read black move
                System.out.println("Black move: ");
                String blackMove = sc.nextLine();

                // move black piece
                moveResult = board.move(blackMove, PieceColor.BLACK);
                moveOk = true;
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        } while (!moveOk);
        return moveResult;
    }

    public Player getPlayer(PieceColor pieceColor) {
        return players.get(pieceColor);
    }

    public void check() {
        System.out.println("Check!");
    }

    public void pieceCaptured(Piece piece) {
        System.out.println("Piece captured: " + piece);
    }

    public void end() {
        gameOnGoing = false;
    }

    public PieceColor getWinner() {
        return winner;
    }

    public void setWinner(PieceColor winner) {
        this.winner = winner;
    }
}
