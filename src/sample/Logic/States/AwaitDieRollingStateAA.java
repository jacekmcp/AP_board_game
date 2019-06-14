package sample.Logic.States;

import sample.Controllers.Controller;
import sample.Logic.CrewMember;
import sample.Logic.Game;
import sample.Logic.Room;
import sample.Logic.ShipObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AwaitDieRollingStateAA implements GameState {
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
        CrewMember crewMember = controller.selectCrewMember(crewMembers);

        Random rand = new Random();
        int count = rand.nextInt(12) + 1;

        if(count > 5){
            Room room = game.getShip().findCrewMember(crewMember);
            for(ShipObject shipObject : room.getShipObjects()){
                if(shipObject.sayType().equals("Alien")){
                    room.getShipObjects().remove(shipObject);
                    game.setInspirationPoints(game.getInspirationPoints() + 1);
                    break;
                }
            }
        }
        game.setAP(game.getAP() -1);
        game.setGameState(new AwaitPlayerActionState());
    }
}
