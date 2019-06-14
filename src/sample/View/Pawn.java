package sample.View;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Pawn extends Circle {
    public Pawn(int positionX,int positionY,boolean isPownOne){
        super(positionX,positionY,20);
        if(isPownOne)
            this.setFill(Color.RED);
        else
            this.setFill(Color.BLUE);
        this.positionY = positionY;
        this.positionX = positionX;

    }
    private int positionX,positionY;
    public Circle show(){
        return this;
    }
    public void move(double x, double y){
        this.setLayoutX(x);
        this.setCenterY(y);
    }
}
