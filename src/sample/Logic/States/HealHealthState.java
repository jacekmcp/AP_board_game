package sample.Logic.States;

import sample.Logic.Game;

public class HealHealthState implements GameState {
    @Override
    public void printDialogWindow(Game game) {

    }

    @Override
    public void printState(Game game) {

    }

    @Override
    public void handleActions(Game game) {
        game.setHealth(game.getHealth() + 1);
        game.setAP(game.getAP() -1);
        game.setGameState(new AwaitPlayerActionState());
    }
}
