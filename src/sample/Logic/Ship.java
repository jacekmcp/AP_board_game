package sample.Logic;

import sample.Logic.Traps.Trap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ship {

    private List<Room> rooms = new ArrayList<>();
    private String[] journeyTracker = {"S", "2A", "3A", "4A", "5A*", "R", "4A", "5A", "6A*", "R", "6A", "7A*", "R", "8A", "E"};
    private Integer hull;
    private int currentJT;

    public Ship(){
        this.readRooms();
        this.currentJT = 1;
//        this.readJourneyTracker();
    }

//    private void readJourneyTracker() {
//        this.journeyTracker[] = {"S", "2A", "3A", "4A", "5A*", "R", "4A", "5A", "6A*", "R", "6A", "7A*", "R", "8A", "E"};
//    }



    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public String[] getJourneyTracker() {
        return journeyTracker;
    }

    public void setJourneyTracker(String[] journeyTracker) {
        this.journeyTracker = journeyTracker;
    }

    public Integer getHull() {
        return hull;
    }

    public void setHull(Integer hull) {
        this.hull = hull;
    }

    public int getAmountOfAliensJT(){
        return Character.getNumericValue(this.journeyTracker[this.currentJT].charAt(0));
    }

    public String getCurrentJT() {
        return this.journeyTracker[this.currentJT];
    }

    public void incrementCurrentJT() {
        this.currentJT ++;
    }

    public void putObjectIntoRoom(int roomNr, ShipObject object){
        for (Room room : this.rooms) {
            if(room.getNumber() == roomNr){
                room.addObject(object);
            }
        }
    }

    private void readRooms() {
        Room room = new Room("Bridge",1);
        this.rooms.add(room);
        room = new Room("Sickbay",2);
        this.rooms.add(room);
        room = new Room("Brig",3);
        this.rooms.add(room);
        room = new Room("Crew Quarters",4);
        this.rooms.add(room);
        room = new Room("Conference room",5);
        this.rooms.add(room);
        room = new Room("Shuttle Bay",6);
        this.rooms.add(room);
        room = new Room("Weapons Bay",7);
        this.rooms.add(room);
        room = new Room("Mess Hall",8);
        this.rooms.add(room);
        room = new Room("Engineering",9);
        this.rooms.add(room);
        room = new Room("Astrometrics",10);
        this.rooms.add(room);
        room = new Room("Holodeck",11);
        this.rooms.add(room);
        room = new Room("Hydroponics",12);
        this.rooms.add(room);

    }
    
    public void replaceCrewMember(ShipObject shipObject, int roomIndex1, int roomIndex2){
        this.rooms.get(roomIndex1).getShipObjects().remove(shipObject);
        this.rooms.get(roomIndex2).addObject(shipObject);
    }

    public Room findCrewMember(CrewMember chosenCrewMember) {
        for (Room room: this.rooms) {
            if(room.getShipObjects().contains(chosenCrewMember)) return room;
        }
        return null;
    }

    public boolean particleDisperserExists() {

        for (Room room: this.rooms) {
            for (ShipObject shipObject: room.getShipObjects()) {
                if(shipObject.sayType().equals("Trap")){
                    Trap trap = (Trap) shipObject;
                    if(trap.getTrapType() == Trap.type.PARTICLE_DISPERSER) return true;
                }
            }
        }
        return false;
    }

    public Room findAlien(Alien alien) {
        for (Room room: this.rooms) {
            if(room.getShipObjects().contains(alien)) return room;
        }
        return null;
    }

    public void removeAllAliens() {
        for (Room room : this.rooms){
            room.getShipObjects().removeIf(shipObject -> shipObject.sayType().equals("Alien"));
        }
    }
}
