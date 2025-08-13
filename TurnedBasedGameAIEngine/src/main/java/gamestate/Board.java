package main.java.gamestate;

import main.java.gamestate.Move;

public interface Board {
    void move(Move move);

    Board copy();

}
