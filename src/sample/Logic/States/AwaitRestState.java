package sample.Logic.States;

import sample.Logic.Game;

public class AwaitRestState implements GameState {
    @Override
    public void printDialogWindow(Game game) {

    }

    @Override
    public void printState(Game game) {

    }

    @Override
    public void handleActions(Game game) {
        game.getShip().removeAllAliens();

        game.setGameState(new AwaitDieRollingState());
    }
}
