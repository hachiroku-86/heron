package sample;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("JavaFX Welcome");
        primaryStage.show();
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        Scene scene = new Scene(grid, 600, 450);
        primaryStage.setScene(scene);
        Text scenetitle = new Text("Welcome");
        scenetitle.setId("welcome-text");
        grid.add(scenetitle, 0, 0, 2, 1);
        Label text = new Label("Text : ");
        grid.add(text, 0, 1);
        TextField textField = new TextField();
        grid.add(textField, 1, 1);
        Button btnMaj = new Button("Maj");
        Button btnMin = new Button("Min");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btnMaj);
        hbBtn.getChildren().add(btnMin);
        grid.add(hbBtn, 1, 4);
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        actiontarget.setId("actiontarget");

        scene.getStylesheets().add (Main.class.getResource("FX.css").toExternalForm());


        btnMaj.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                actiontarget.setFill(Color.BLACK);
                actiontarget.setText(textField.getText().toUpperCase());
            }
        });

        btnMin.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                actiontarget.setFill(Color.BLACK);
                actiontarget.setText(textField.getText().toLowerCase());
            }
        });


    }




    public static void main(String[] args) {
        launch(args);
    }
}
