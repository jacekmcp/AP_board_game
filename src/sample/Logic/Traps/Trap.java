package sample.Logic.Traps;

import sample.Logic.ShipObject;

import java.util.Objects;

public abstract class Trap implements ShipObject {

    private static int pointer = 1;

    private int identifier;

    public enum type {ORGANIC_DETONATOR, PARTICLE_DISPERSER};

    public abstract type getTrapType();

    public Trap() {
        this.identifier = pointer;
        pointer++;
    }

    @Override
    public String sayType(){
        return "Trap";
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trap)) return false;
        Trap trap = (Trap) o;
        return getIdentifier() == trap.getIdentifier();
    }
}
