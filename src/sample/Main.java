package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Controllers.GameInit;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        GameInit init = new GameInit();
  //      init.run();

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Destination Earth");
        primaryStage.setScene(new Scene(root, 1200, 900));
        primaryStage.show();
    }


    public static void main(String[] args) {


        launch(args);
    }
}
