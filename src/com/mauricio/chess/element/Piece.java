package com.mauricio.chess.element;

import java.util.List;

public interface Piece {
    List<String> moves();
    void move(String cell);
    boolean allowed(String cell);
}
