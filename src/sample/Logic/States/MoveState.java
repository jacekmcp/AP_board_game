package sample.Logic.States;

import sample.Controllers.Controller;
import sample.Logic.CrewMember;
import sample.Logic.Game;
import sample.Logic.Room;

import java.util.ArrayList;
import java.util.List;

public class MoveState implements GameState {
    @Override
    public void printDialogWindow(Game game) {

    }

    @Override
    public void printState(Game game) {

    }

    @Override
    public void handleActions(Game game) {
        Controller controller = new Controller();

        List<CrewMember> crewMembers = new ArrayList<>();
        crewMembers.add(game.getCrewMember1());
        crewMembers.add(game.getCrewMember2());
        CrewMember chosenCrewMember = controller.selectCrewMember(crewMembers); //TODO Returns crew member. Handle it

        Room room1 = game.getShip().findCrewMember(chosenCrewMember);
//        if(room1 == null) TODO warning the above line can return null. Handle nullable exception

        Room room2 = controller.selectRoom(game.getShip().getRooms());

        game.getShip().replaceCrewMember(chosenCrewMember, game.getShip().getRooms().indexOf(room1), game.getShip().getRooms().indexOf(room2));

        game.setAP(game.getAP() -1);
        game.setGameState(new AwaitPlayerActionState());
    }
}
