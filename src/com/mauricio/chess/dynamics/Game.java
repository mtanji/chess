package com.mauricio.chess.dynamics;

import com.mauricio.chess.element.Board;
import com.mauricio.chess.element.PieceColor;
import java.util.Scanner;

public class Game {

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

            // read white move
            System.out.println("White move: ");
            Scanner sc = new Scanner(System.in);
            String whiteMove = sc.nextLine();

            // move white piece
            board.move(whiteMove, PieceColor.WHITE);

            // read black move
            System.out.println("Black move: ");
            sc = new Scanner(System.in);
            String blackMove = sc.nextLine();

            // move black piece
            board.move(blackMove, PieceColor.BLACK);
        }
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
