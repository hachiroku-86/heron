package Panels;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Hashtable;

public class Main extends Application {

    private static Scene scene;

    private static Hashtable<String, Pane> vues = new Hashtable<>();

    private static void HtabPane(){
        vues.put("logPane", new LogPane());
    }

    public static Pane getPanel(String s){
        return vues.get(s);
    }

    public static Scene getScene(){
        return scene;
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        HtabPane();
        scene = new Scene(getPanel("logPane"),500,500);
        primaryStage.setTitle("E4 AS Foot");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
