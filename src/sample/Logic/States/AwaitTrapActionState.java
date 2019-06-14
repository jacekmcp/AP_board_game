package sample.Logic.States;

import sample.Controllers.Controller;
import sample.Logic.Game;
import sample.Logic.Room;
import sample.Logic.Traps.OrganicDetonator;
import sample.Logic.Traps.ParticleDisperser;

public class AwaitTrapActionState implements GameState {
    @Override
    public void printDialogWindow(Game game) {

    }

    @Override
    public void printState(Game game) {

    }

    @Override
    public void handleActions(Game game) {
        Controller controller = new Controller();

        switch (controller.printTrapMenu(game)){
            case 1:
                Room room = controller.whereToPlaceTrap(game);
                room.addObject(new OrganicDetonator());
                break;
            case 2:
                Room room1 = controller.whereToPlaceTrap(game);
                room1.addObject(new ParticleDisperser());
                break;
            case 3:
                Room room3 = controller.showDetonateMenu(game);
                if(room3.detonateTrap()){
                    game.setGameState(new GameOverState());
                }
                break;
        }

        game.setAP(game.getAP() -1);
        game.setGameState(new AwaitPlayerActionState());

    }
}
