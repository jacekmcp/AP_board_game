package sample.View;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardSetUp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("BoardGame");
        primaryStage.setScene(setUpScene());
        primaryStage.show();
    }
    Pawn playerOne = new Pawn(100,10,true);
    Pawn playerTwo = new Pawn(200,20,false);



    public Scene setUpScene(){
        Pane board = new AnchorPane();
        board.setOnKeyPressed(e ->{
            switch (e.getCode()){
                case A:
                    playerOne.move(200,200);
                    break;
                case B:
                    playerOne.move(300,200);
                    break;
                case C:
                    playerOne.move(400,200);
                    break;
            }
        });
        Scene mainScene = new Scene(board,1200,900);
        board.getChildren().addAll(setUpBackground());
        board.getChildren().add(playerOne);
        return mainScene;
    }

    List<Node> setUpBackground(){
        List<Node> background = new ArrayList<>();
        background.add(setUpExitButton());
        background.add(setUpInformationBoard());
        background.add(setUpShipBoard());
        return background;
    }
    ImageView setUpShipBoard(){
        ImageView shipBoard = new ImageView();
        shipBoard.setImage(new Image("file:mainBoard.png"));
        shipBoard.setTranslateX(100);
        shipBoard.setTranslateY(0);
        shipBoard.setPreserveRatio(true);
        shipBoard.setFitWidth(600);
        return shipBoard;
    }
    ImageView setUpInformationBoard(){
        ImageView informationBoard = new ImageView(new Image("file:gui.png"));
        informationBoard.setPreserveRatio(true);
        informationBoard.setFitWidth(500);
        informationBoard.setTranslateX(700);
        informationBoard.setTranslateY(0);
        return informationBoard;
    }

    Button setUpExitButton(){
        Button exitButton = new Button("Exit");
        exitButton.setOnAction(e -> Platform.exit());
        exitButton.setPrefWidth(100);
        exitButton.setMaxHeight(20);
        exitButton.setTranslateX(0);
        exitButton.setTranslateY(0);
        return exitButton;
    }
}
