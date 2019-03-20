package Panels;

import DAO.DAO;
import Class.Licencie;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class LogPane extends GridPane {

    String login;
    String password;
    Text actiontargetResult = new Text();
    DAO dao = new DAO();

    public LogPane(){

        this.setHgap(35);
        this.setVgap(35);
        this.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("");
        scenetitle.setId("scene-title-text");
        this.add(scenetitle, 0, 0);

        Label text1 = new Label("Login : ");
        text1.setId("text_1");
        this.add(text1, 0, 2);
        final TextField textField1 = new TextField();
        this.add(textField1,1,2);


        Label text2 = new Label("Mot de passe : ");
        text1.setId("text_2");
        this.add(text2, 0, 3);
        final TextField textField2 = new TextField();
        this.add(textField2,1,3);


        this.add(actiontargetResult,1,4);
        actiontargetResult.setId("actiontargetResult");

        Button btnLog = new Button("Connexion");
        this.add(btnLog, 2,3);



        btnLog.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                login = textField1.getText();
                password = textField2.getText();
                Licencie licencie1 = dao.testLog(login, password);


                if (licencie1.getLogin().equals(login) && licencie1.getMdp().equals(password)) {
                    actiontargetResult.setText("Bienvenue" + " " + licencie1.getPrenom() + " " + licencie1.getNom() + " !");
                    Main.getScene().setRoot(Main.getPanel("logPane"));
                }else{
                    actiontargetResult.setText("Mauvais login ou mot de passe.");
                }


            }
        });

    }
}
