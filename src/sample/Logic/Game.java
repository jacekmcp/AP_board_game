package sample.Logic;

import sample.Logic.States.AwaitBeginningState;
import sample.Logic.States.GameState;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Ship ship;

    private List<CrewMember> crewMembers;

    private CrewMember crewMember1;
    private CrewMember crewMember2;

    private Integer health;
    private Integer inspirationPoints;

    private Integer sealedRoomsTokens = 0;
    private Integer PD = 0;
    private Integer OD = 0;
    private Integer AP = 0;

    private GameState gameState;

    public Game(){
        this.crewMembers = this.readCrewMembers();
        this.ship = new Ship();
        this.gameState = new AwaitBeginningState();
        this.gameState.handleActions(this);
    }


    public GameState getGameState() {
        return gameState;
    }

    public void getInitWindowScreen() {

    }

    public void triggerStateActions(){
        this.gameState.handleActions(this);
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public CrewMember getCrewMember1() {
        return crewMember1;
    }

    public void setCrewMember1(CrewMember crewMember1) {
        this.crewMember1 = crewMember1;
    }

    public CrewMember getCrewMember2() {
        return crewMember2;
    }

    public void setCrewMember2(CrewMember crewMember2) {
        this.crewMember2 = crewMember2;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getInspirationPoints() {
        return inspirationPoints;
    }

    public void setInspirationPoints(Integer inspirationPoints) {
        this.inspirationPoints = inspirationPoints;
    }

    public Integer getSealedRoomsTokens() {
        return sealedRoomsTokens;
    }

    public void setSaledRoomsTokens(Integer sealedRoomsTokens) {
        this.sealedRoomsTokens = sealedRoomsTokens;
    }

    public Integer getPD() {
        return PD;
    }

    public void setPD(Integer PD) {
        this.PD = PD;
    }

    public Integer getOD() {
        return OD;
    }

    public void setOD(Integer OD) {
        this.OD = OD;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    private List<CrewMember> readCrewMembers() {

        List<CrewMember> crewMembers = new ArrayList<>();

        CrewMember crewMember = new CrewMember("Doctor",1,1,"Can heal 2 Health for 1 IP when resting.\n Can heal 1 Health for 1 AP.\nCan heal 1 Health per round for free if in Sickbay.");
        crewMembers.add(crewMember);
        crewMember = new CrewMember("Comms Officer",1,1,"Before an alien attacks this crew member, roll 1D6, on a 1 or 2 that alien misses their attack.");
        crewMembers.add(crewMember);
        crewMember = new CrewMember("Red Shirt",1,1,"Can be sacrificed to gain 5 Health at any time. If you do, you play with only the other crew memeber.");
        crewMembers.add(crewMember);
        crewMember = new CrewMember("Science Officer",1,1,"Can perform ranged attacks into adjacent rooms. Can only attack through open doors.");
        crewMembers.add(crewMember);
        crewMember = new CrewMember("Engineer",1,1,"Can fix 2 Hull for 1 AP when resting.\nCan fix 1 Hull for 1 AP.\nCan fix 1 Hull per round for free if in Engineering.");
        crewMembers.add(crewMember);
        crewMember = new CrewMember("Captain",1,1,"Can attack on a 3+.");
        crewMembers.add(crewMember);
        crewMember = new CrewMember("Commander",1,1,"6 AP per turn instead of 5.");
        crewMembers.add(crewMember);
        crewMember = new CrewMember("Transporter Chief",1,1,"Can teleport to any room for 1 AP.");
        crewMembers.add(crewMember);
        crewMember = new CrewMember("Moral Officer",1,1,"Starts with 5 IP.");
        crewMembers.add(crewMember);
        crewMember = new CrewMember("Security Officer",1,2,"Starts with 2D6 for attack.");
        crewMembers.add(crewMember);
        crewMember = new CrewMember("Navigation Officer",2,1,"Can move 2 rooms for 1 AP.");
        crewMembers.add(crewMember);
        crewMember = new CrewMember("Shuttle Pilot",1,1,"Starts with 4 extra Health.");
        crewMembers.add(crewMember);


        return crewMembers;
    }

    public List<CrewMember> getCrewMembers() {
        return crewMembers;
    }


    public void setPlaceForCM1(int selectPlacementForCrewMember) {
        this.getShip().putObjectIntoRoom(selectPlacementForCrewMember, this.crewMember1);

    }

    public void setPlaceForCM2(int selectPlacementForCrewMember) {
        this.getShip().putObjectIntoRoom(selectPlacementForCrewMember, this.crewMember2);
    }

    public Integer getAP() {
        return AP;
    }

    public void setAP(Integer AP) {
        this.AP = AP;
    }
}
