package com.mauricio.chess.dynamics;

import com.mauricio.chess.element.Board;
import com.mauricio.chess.element.PieceColor;
import java.util.Scanner;

public class Game {

    private final Scanner sc = new Scanner(System.in);
    private final Board board;

    private boolean gameOnGoing = true;
    private PieceColor winner;

    public Game() {
        board = new Board(this);
    }

    public void start() {

        // while there is no winner
        // alternate white and black
        while (gameOnGoing) {
            whiteMove();
            blackMove();
        }
    }

    /**
     * Retry while user does not provide valid move
     */
    private void whiteMove() {
        boolean moveOk = false;
        do {
            try {
                // read white move
                System.out.println("White move: ");
                String whiteMove = sc.nextLine();

                // move white piece
                board.move(whiteMove, PieceColor.WHITE);
                moveOk = true;
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        } while (!moveOk);
    }

    private void blackMove() {
        boolean moveOk = false;
        do {
            try {
                // read black move
                System.out.println("Black move: ");
                String blackMove = sc.nextLine();

                // move black piece
                board.move(blackMove, PieceColor.BLACK);
                moveOk = true;
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        } while(!moveOk);
    }


    public void check() {
        System.out.println("Check!");
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
