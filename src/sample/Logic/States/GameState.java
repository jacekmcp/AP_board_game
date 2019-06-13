package sample.Logic.States;

import sample.Logic.Game;

public interface GameState {

    void printDialogWindow(Game game);
    void printState(Game game);
    void handleActions(Game game);
}
