package sample.Logic.States;

import sample.Controllers.Controller;
import sample.Logic.Game;

public class Await3rdTokenPlacementFor1stMrewMemberState implements GameState {


    @Override
    public void printDialogWindow(Game game) {

    }

    @Override
    public void printState(Game game) {

    }

    @Override
    public void handleActions(Game game) {
        Controller controller = new Controller();
        game.setPlaceForCM1(controller.selectPlacementForCrewMember());
        game.setGameState(new Await3rdTokenPlacementFor2ndCrewMemberState());
    }
}
