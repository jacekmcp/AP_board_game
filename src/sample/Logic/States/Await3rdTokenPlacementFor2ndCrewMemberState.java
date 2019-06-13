package sample.Logic.States;

import sample.Controllers.Controller;
import sample.Logic.Game;

public class Await3rdTokenPlacementFor2ndCrewMemberState implements GameState {
    @Override
    public void printDialogWindow(Game game) {

    }

    @Override
    public void printState(Game game) {

    }

    @Override
    public void handleActions(Game game) {
        Controller controller = new Controller();
        game.setPlaceForCM2(controller.selectPlacementForCrewMember());
        if(game.getShip().getCurrentJT().equals("R")){
            game.setGameState(new AwaitRestState());
        } else{
            game.setAP(5);
            game.setGameState(new AwaitDieRollingState());
        }
    }
}
