package com.mauricio.chess.dynamics;

/**
 * After a move, the game can just switch turn, call a check and switch turn, or end by a checkmate
 */
public enum MoveResult {
    CONTINUE, CHECK, CHECK_MATE
}
