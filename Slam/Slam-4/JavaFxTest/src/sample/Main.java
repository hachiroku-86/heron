package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Java FX Test");
        Group root = new Group();
        Scene scene = new Scene(root, 1000, 700, Color.LIGHTBLUE);
        Button btn = new Button();
        btn.setLayoutX(475);
        btn.setLayoutY(300);
        btn.setText("Bouton");
        btn.setOnAction(new EventHandler<ActionEvent>() {


            public void handle(ActionEvent event) {
                System.out.println("Hello World");
            }

        });
        root.getChildren().add(btn);
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    public static void main(String[] args) {
        Main.launch(args);
    }
}