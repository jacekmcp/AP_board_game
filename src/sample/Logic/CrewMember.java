package sample.Logic;

import java.util.Objects;

public class CrewMember implements ShipObject{

    private String type;
    private Integer movement;
    private Integer attack;
    private String special;

    public CrewMember(String type, Integer movement, Integer attack, String special) {
        this.type = type;
        this.movement = movement;
        this.attack = attack;
        this.special = special;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getMovement() {
        return movement;
    }

    public void setMovement(Integer movement) {
        this.movement = movement;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    @Override
    public String toString() {
        return "Name:='" + type + '\'' +
                ", movement=" + movement +
                ", attack=" + attack +
                ", special='" + special + '\'';
    }

    @Override
    public String sayType() {
        return "CM";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CrewMember)) return false;
        CrewMember that = (CrewMember) o;
        return Objects.equals(getType(), that.getType());
    }
}
