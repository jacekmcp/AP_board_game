package sample.Controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import org.w3c.dom.events.Event;
import sample.Logic.CrewMember;
import sample.Logic.Game;
import sample.Logic.Room;
import javafx.scene.control.TextArea;
import java.awt.*;
import java.io.FileInputStream;
import java.util.*;
import java.util.List;

import  javafx.scene.control.*;
import sample.Logic.ShipObject;

public class Controller {

    @FXML
    void initialize(){
        game = new Game();
        game.triggerStateActions();
        }
    @FXML
    private TextArea output;

    @FXML
    private TextField input;

    @FXML
    private Circle crewMemberOne;

    @FXML
    private Circle crewMemberTwo;

    @FXML
    private AnchorPane mainBoard;

    private Game game;

    public final static Map<Integer,RoomCoordinates> roomCoordinates = new HashMap<>(){{
         put(1,new RoomCoordinates(360,130));
         put(2,new RoomCoordinates(415,530));
         put(3,new RoomCoordinates(415,520));
         put(4,new RoomCoordinates(518,270));
         put(5,new RoomCoordinates(310,270));
         put(6,new RoomCoordinates(360,700));
         put(7,new RoomCoordinates(520,540));
         put(8,new RoomCoordinates(400,300));
         put(9,new RoomCoordinates(200,400));
         put(10,new RoomCoordinates(317,517));
         put(11,new RoomCoordinates(520,400));
         put(12,new RoomCoordinates(200,540));
    }
    };
    private void addCrewMember(boolean moveCrewMemberOne,int roomNumber){
        RoomCoordinates temp = roomCoordinates.get(roomNumber);
        Circle alien = new Circle(temp.getX(),temp.getY() - 30,25);
        try{
            //Image alienImg = new Image(new FileInputStream("src/alien.png"));
            //alien.setFill(new ImagePattern(alienImg));
        }catch (Exception x){System.out.println("error not loading alien image");}

        mainBoard.getChildren().add(alien);

    }
    private void addAlien(int roomNumber){
        RoomCoordinates temp = roomCoordinates.get(roomNumber);
        Circle alien = new Circle(temp.getX(),temp.getY() - 30,25);
        try{
            Image alienImg = new Image(new FileInputStream("src/alien.png"));
            alien.setFill(new ImagePattern(alienImg));
        }catch (Exception x){System.out.println("error not loading alien image");}

        mainBoard.getChildren().add(alien);
        }
    private void addTrap(int roomNumber){
        RoomCoordinates temp = roomCoordinates.get(roomNumber);
        Circle trap = new Circle(temp.getX(),temp.getY() + 30,25);
        try{
            Image alienImg = new Image(new FileInputStream("src/trap.jpg"));
            trap.setFill(new ImagePattern(alienImg));
        }catch (Exception x){System.out.println("error not loading alien image");}

        mainBoard.getChildren().add(trap);

    }



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
        Integer output = scanner.nextInt();
        return output;
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
    @FXML
    void exit(){
        Platform.exit();
    }
    @FXML
    void action(){
        game.triggerStateActions();
        showGameObjects();
    }
    @FXML
    void movement(KeyEvent event){
        switch (event.getCode()){
            case A:
                addAlien(1);
                addTrap(1);
                break;
            case D:
                addAlien(2);
                addTrap(2);
                break;
            case W:
                addAlien(3);addTrap(4);
                break;
            case S:
                addAlien(4);addTrap(10);
                break;

         }

    }
    public void showGameObjects(){
        Iterator iterator = game.getShip().getRooms().iterator();
        while (iterator.hasNext()){
            Room room = (Room)iterator.next();
            Iterator iterator1 = room.getShipObjects().iterator();
            while (iterator1.hasNext()){
                ShipObject shipObject = (ShipObject)iterator1.next();
                switch (shipObject.sayType()){
                    case "CM":
                        addCrewMember(true,room.getNumber());
                        break;
                    case "Alien":
                        addAlien(room.getNumber());
                        break;
                    case "Trap":
                        addTrap(room.getNumber());
                        break;
                }
            }
        }
    }

}
