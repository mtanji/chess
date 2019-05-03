package com.mauricio;

import com.mauricio.chess.dynamics.Game;

public class Main {

    public static void main(String[] args) {
        // setup board
        Game game = new Game();
        // start game
        game.start();

        System.out.println(game.getWinner() + " is the winner");
    }
}
