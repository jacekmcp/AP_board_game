package sample.Controllers;

import sample.Logic.CrewMember;
import sample.Logic.Room;

import java.util.List;
import java.util.Random;
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
}
