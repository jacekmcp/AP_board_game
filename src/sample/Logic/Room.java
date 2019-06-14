package sample.Logic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Room {

    private String name;
    private Integer number;
    private List<ShipObject> shipObjects = new ArrayList<>();
    private boolean sealed;

    public Room(String name, Integer number) {
        this.name = name;
        this.number = number;
        this.sealed = false;
    }

    public boolean isSealed() {
        return sealed;
    }

    public void setSealed(boolean sealed) {
        this.sealed = sealed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public List<ShipObject> getShipObjects() {
        return shipObjects;
    }


//    public boolean consistShipObject(ShipObject shipObject){
//        for (ShipObject so: this.shipObjects) {
//            so.sayType().equals(shipObject.sayType());
//        }
//    }

    public void addObject(ShipObject shipObject){
        this.shipObjects.add(shipObject);
    }
//
//    @Override
//    public String toString() {
//        return number + ". " + name;
//    }


    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", shipObjects=" + shipObjects +
                ", sealed=" + sealed +
                '}';
    }
}
