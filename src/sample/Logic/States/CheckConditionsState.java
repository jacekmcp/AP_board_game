package sample.Logic.States;

import sample.Logic.Game;

public class CheckConditionsState implements GameState {
    @Override
    public void printDialogWindow(Game game) {

    }

    @Override
    public void printState(Game game) {

    }

    @Override
    public void handleActions(Game game) {

        game.getShip().incrementCurrentJT();
        String currJT = game.getShip().getCurrentJT();

        if(game.getHealth() <1 || game.getShip().getHull() <1) {
            game.setGameState(new GameOverState());
            return;
        }

        if(currJT.equals("E")){
            game.setGameState(new WinState());
            return;
        }
        if(currJT.equals("R")){
            game.setGameState(new AwaitRestState());
            return;
        }

        game.setGameState(new AwaitDieRollingState());

    }
}
