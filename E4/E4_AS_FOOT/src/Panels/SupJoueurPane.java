package Panels;

import DAO.LicencieDAO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import Class.Entraineur;
import javafx.scene.text.Text;
import javafx.scene.control.Label;



public class SupJoueurPane extends GridPane {

    private Entraineur entraineur = new Entraineur();
    private LicencieDAO lDAO = new LicencieDAO();
    private Text titre = new Text("");
    private Label textId = new Label();
    private TextField textFieldId = new TextField();


    public Entraineur getEntraineur() {
        return entraineur;
    }

    public void setEntraineur(Entraineur entraineur){
        this.entraineur = entraineur;
        exe();
    }


    public void exe(){

        titre.setText("Bienvenue " + entraineur.getPrenom() + " " + entraineur.getNom() + " !");

    }

    public SupJoueurPane(){

        Text scenetitle = new Text("SupJoueurPane");
        scenetitle.setId("scene-title-text");
        this.add(scenetitle, 0, 0);

        Button btnDel = new Button("Valider");
        this.add(btnDel,1,3);

        textId.setId("text_id");
        this.add(textId, 0, 2);
        this.add(textFieldId, 1, 2);


        btnDel.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {

                suppressionJoueur();

            }
        });

    }

    public void suppressionJoueur(){

        int id = Integer.valueOf(textFieldId.getText());

        lDAO.deleteLicencie(id);

    }

}
