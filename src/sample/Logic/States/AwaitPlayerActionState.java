package sample.Logic.States;

import sample.Controllers.Controller;
import sample.Logic.*;
import sample.Logic.Traps.Trap;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
                    game.setGameState(new AwaitDieRollingStateAA());
                    break;
                case 2:
                    game.setGameState(new AwaitTrapActionState());
                    break;
                case 3:
                    game.setGameState(new AwaitSealRoomActionState());
                    break;
                case 4:
                    //TODO handle move FIX
                    game.setGameState(new MoveState());
                    break;
                case 5:
                    game.setGameState(new HealHealthState());

                    break;
                case 6:
                    game.setGameState(new FixHullState());
                    break;
                default:
                    System.out.println("bad input");
            }


        }else{
            //TODO Alien turn
            this.processAlienTurn(game);
            game.setGameState(new CheckConditionsState());
        }

    }

    private void processAlienTurn(Game game){
        for(Room room: game.getShip().getRooms()){
            for(ShipObject shipObject : room.getShipObjects()){
                if(shipObject.sayType().equals("Alien")) this.processAlienMove((Alien) shipObject, game);
            }
        }


    }

    private void processAlienMove(Alien alien, Game game){
        if(this.tryToHit(alien, game)) return;
        this.moveAlien(alien, game);

        if(!this.alienInRoomWithOrganicDetonator(alien, game)){
            if(this.tryToHit(alien, game)) return;
            game.getShip().setHull(game.getShip().getHull() - 1);
        }
    }

    private boolean alienInRoomWithOrganicDetonator(Alien alien, Game game) {
        Room room = game.getShip().findAlien(alien);
        for(ShipObject shipObject : room.getShipObjects()){
            if(shipObject.sayType().equals("Trap")){
                Trap trap = (Trap) shipObject;
                if(trap.getTrapType() == Trap.type.ORGANIC_DETONATOR){
                    room.getShipObjects().remove(shipObject);
                    room.getShipObjects().remove(alien);
                    return true;
                }

            }
        }
        return false;
    }

    private boolean tryToHit(Alien alien, Game game){
        Room room = game.getShip().findAlien(alien);
        for(ShipObject shipObject : room.getShipObjects()){
            if(shipObject.sayType().equals("CM")){
                Random rand = new Random();
                int count = rand.nextInt(12) + 1;

                if (count > 5) game.setHealth(game.getHealth() - 1);
                return true;
            }
        }
        return false;
    }

    private void moveAlien(Alien alien, Game game){
        Room currRoom = game.getShip().findAlien(alien);
        Controller controller = new Controller();

        Room newRoom = controller.selectNewRoomForAlien(alien, game.getShip().getRooms());

        game.getShip().replaceCrewMember(alien, game.getShip().getRooms().indexOf(currRoom), game.getShip().getRooms().indexOf(newRoom));
    }
}
