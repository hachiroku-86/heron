package Panels;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class AccueilPane extends GridPane{

    public AccueilPane(){


        this.setHgap(35);
        this.setVgap(35);
        this.setPadding(new Insets(25, 25, 25, 25));

        MenuBar menuBar = new MenuBar();

        Menu menuPublic = new Menu("Public");
        menuBar.getMenus().add(menuPublic);

        MenuItem menu1Item1 = new MenuItem("Page visiteurs");

        menuPublic.getItems().add(menu1Item1);



        Menu menuLog = new Menu("Connection");
        menuBar.getMenus().add(menuLog);

        MenuItem menuLogItem = new MenuItem("Se connecter");

        menuLog.getItems().add(menuLogItem);


        VBox vBox = new VBox(menuBar);
        this.add(vBox,15,0);

        Text scenetitle = new Text("AccueilPane");
        scenetitle.setId("scene-title-text");
        this.add(scenetitle, 0, 0);


        menu1Item1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                Main.getScene().setRoot(Main.getPanel("publicPane"));
            }

        });


        menuLogItem.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                Main.getScene().setRoot(Main.getPanel("logPane"));
            }

        });

    }
}
