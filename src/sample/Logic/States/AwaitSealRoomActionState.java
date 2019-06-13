package sample.Logic.States;

import sample.Controllers.Controller;
import sample.Logic.Game;
import sample.Logic.Room;

public class AwaitSealRoomActionState implements GameState {
    @Override
    public void printDialogWindow(Game game) {

    }

    @Override
    public void printState(Game game) {

    }

    @Override
    public void handleActions(Game game) {
        Controller controller = new Controller();

        Room room = controller.selectRoom(game.getShip().getRooms());
        room.setSealed(true);
        game.setAP(game.getAP() -1);
        game.setGameState(new AwaitPlayerActionState());
    }
}
