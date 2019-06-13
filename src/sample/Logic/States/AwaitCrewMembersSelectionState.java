package sample.Logic.States;

import sample.Controllers.Controller;
import sample.Logic.CrewMember;
import sample.Logic.Game;

public class AwaitCrewMembersSelectionState implements GameState {
    @Override
    public void printDialogWindow(Game game) {

    }

    @Override
    public void printState(Game game) {

    }

    @Override
    public void handleActions(Game game) {
        Controller controller = new Controller();

        game.setCrewMember1(controller.selectCrewMember(game.getCrewMembers()));
        game.setCrewMember2(controller.selectCrewMember(game.getCrewMembers()));

        game.setGameState(new Await3rdTokenPlacementFor1stMrewMemberState());
    }
}
