package sample.Logic.States;

import sample.Controllers.Controller;
import sample.Logic.Game;

import java.util.Random;


//This class is dedicated to spawn aliens
public class AwaitDieRollingState implements GameState {
    @Override
    public void printDialogWindow(Game game) {

    }

    @Override
    public void printState(Game game) {

    }

    @Override
    public void handleActions(Game game) {
        Controller controller = new Controller();

        for (int i=0; i < game.getShip().getAmountOfAliensJT(); i++){
            Random rand = new Random();
            int roomNr = rand.nextInt(12) + 1;
            controller.printAlienSpawnResult(roomNr);
        }

        game.setGameState(new AwaitPlayerActionState());
    }
}
