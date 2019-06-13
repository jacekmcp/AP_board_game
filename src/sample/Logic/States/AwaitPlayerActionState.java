package sample.Logic.States;

import sample.Controllers.Controller;
import sample.Logic.CrewMember;
import sample.Logic.Game;

import java.util.ArrayList;
import java.util.List;

public class AwaitPlayerActionState implements GameState {
    @Override
    public void printDialogWindow(Game game) {

    }

    @Override
    public void printState(Game game) {

    }

    @Override
    public void handleActions(Game game) {
        Controller controller = new Controller();

        boolean isDoctor = false;
        boolean isEngineer = false;

        if(game.getCrewMember1().getType().equals("Engineer") || game.getCrewMember2().getType().equals("Engineer")) isEngineer = true;
        if(game.getCrewMember1().getType().equals("Doctor") || game.getCrewMember2().getType().equals("Doctor")) isDoctor = true;

        if(game.getAP() > 0){
            switch(controller.handlePlayerAction(isDoctor, isEngineer)){
                case 1:
                    //TODO handle attack;

                    break;
                case 2:
                    //TODO handle trap menu
                    game.setGameState(new AwaitTrapActionState());
                    break;
                case 3:
                    //TODO handle seal room
                    game.setGameState(new AwaitSealRoomActionState());
                    break;
                case 4:
                    //TODO handle move
                    game.setGameState(new MoveState());
                    break;
                case 5:
                    //TODO handle heal
                    game.setGameState(new HealHealthState());

                    break;
                case 6:
                    //TODO handle fix hull
                    game.setGameState(new FixHullState());
                    break;
                default:
                    System.out.println("bad input");
            }


        }else{
            game.setGameState(new CheckConditionsState());
        }

    }
}
