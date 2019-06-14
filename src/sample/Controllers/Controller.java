package sample.Controllers;

import sample.Logic.*;
import sample.Logic.Traps.Trap;

import java.util.List;
import java.util.Scanner;

public class Controller {

    private Scanner scanner = new Scanner(System.in);


    public CrewMember selectCrewMember(List<CrewMember> crewMembers) {

        System.out.println("Select member : ");
        int i = 1;
        for (CrewMember crewMember: crewMembers) {
            System.out.println(Integer.toString(i) + ". " +crewMember.toString());
            i++;
        }

        Scanner scanner = new Scanner(System.in);
        return crewMembers.get(scanner.nextInt() -1);
    }

    public int selectPlacementForCrewMember() {
        System.out.println("Select room for crew member : ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void printAlienSpawnResult(int i) {
        System.out.println("Warning! Warning! Alien appeared at room number" + Integer.toString(i));
    }

    public int handlePlayerAction(boolean isDoctor, boolean isEngineer) {
        System.out.println("Possible actions: \n" +
                "1. Attack \n" +
                "2. Trap Menu \n" +
                "3. Seal room \n" +
                "4. Move \n");
        if(isDoctor) System.out.println("5. Heal health");
        if(isEngineer) System.out.println("6. Fix hull");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();

    }

    public int selectCrewMember(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select the crew member number: [1|2]");
        return scanner.nextInt();
    }

    public Room selectRoom(List<Room> rooms) {
        System.out.println("Select room (just number): ");

        for (Room room: rooms) {
            if(!room.isSealed()) System.out.println(room);
        }

        while(true){
            int choose = this.scanner.nextInt();
            if(!rooms.get(choose + 1).isSealed())return rooms.get(choose + 1);
            System.out.println("Chosen room is sealed");
        }
    }

    public int printTrapMenu(Game game) {
        while(true){
            System.out.println("1. place Organic Detonator");
            System.out.println("2. place Particle Disperser");

            if(game.getShip().particleDisperserExists()){
                System.out.println("3. Detonate Particle Disperser");
            }

            int option = this.scanner.nextInt();
            if(option < 4 && option > 0) return option;
        }


    }

    public Room whereToPlaceTrap(Game game) {
        System.out.println("Where u wanna place trap (Select only number)?");

        for(Room room: game.getShip().getRooms()){
            System.out.println(room);
        }

        int roomNr = this.scanner.nextInt();

        for(Room room: game.getShip().getRooms()){
            if(room.getNumber() == roomNr) return room;
        }

        return null;
    }

    public Room showDetonateMenu(Game game) {
        System.out.println("Select room where Particle Disperser is placed to be detonated(Select only number)");

        for(Room room: game.getShip().getRooms()){
            for (ShipObject shipObject: room.getShipObjects()) {
                if(shipObject.sayType().equals("Trap")){
                    Trap trap = (Trap) shipObject;
                    if(trap.getTrapType() == Trap.type.PARTICLE_DISPERSER) {
                        System.out.println(room);
                    }
                }
            }
        }

        int roomNr = this.scanner.nextInt();

        for(Room room: game.getShip().getRooms()){
            if(room.getNumber() == roomNr) return room;
        }
        return null;
    }


    public Room selectNewRoomForAlien(Alien alien, List<Room> rooms) {
        System.out.println("New room for ");
        System.out.println(alien);

        return this.selectRoom(rooms);
    }
}
