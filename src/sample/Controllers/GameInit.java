package sample.Controllers;

import sample.Logic.CrewMember;
import sample.Logic.Game;

import java.util.List;

public class GameInit {

    private Game game;

    public void run() {
        this.game = new Game();

//        String[] journeyTracker = this.selectJourneyTracker(this.game.getShip().getJourneyTracker());
        while (true) this.game.triggerStateActions();

    }

    private String[] selectJourneyTracker(String[] journeyTracker) {
        //TODO print and select jurneyTracker. Handle default if skip

        return journeyTracker;
    }



}
