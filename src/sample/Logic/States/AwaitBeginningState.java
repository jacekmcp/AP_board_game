package sample.Logic.States;

import sample.Logic.Game;

public class AwaitBeginningState implements GameState {
    @Override
    public void printDialogWindow(Game game) {

    }

    @Override
    public void printState(Game game) {

    }

    @Override
    public void handleActions(Game game) {
        game.setHealth(8);
        game.setInspirationPoints(0);
        game.setAP(0);
        game.getShip().setHull(8);
        game.setGameState(new AwaitCrewMembersSelectionState());
    }
}
