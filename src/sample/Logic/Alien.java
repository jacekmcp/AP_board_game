package sample.Logic;

public class Alien implements ShipObject {

    private static int pointer = 1;

    private int identifier;

    public Alien() {
        this.identifier = pointer;
        pointer++;
    }

    @Override
    public String sayType() {
        return "Alien";
    }

    @Override
    public String toString() {
        return "Alien " +  identifier;
    }
}
