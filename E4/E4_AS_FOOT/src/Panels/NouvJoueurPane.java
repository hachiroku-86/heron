package Panels;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import DAO.LicencieDAO;
import Class.Licencie;
import Class.Entraineur;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class NouvJoueurPane extends GridPane {


    private Entraineur entraineur = null;
    private Text titre = new Text("");
    private Label textId = new Label("Identifiant : ");
    private final TextField textFieldId = new TextField();
    private Label textNom = new Label("Nom : ");
    private final TextField textFieldNom = new TextField();
    private Label textPrenom = new Label("Prenom : ");
    private final TextField textFieldPrenom = new TextField();
    private Label textDateN = new Label("Date de naissance : ");
    private final TextField textFieldDateN = new TextField();
    private Label textLogin = new Label("Login : ");
    private final TextField textFieldLogin = new TextField();
    private Label textMdp = new Label("Mot de passe : ");
    private final TextField textFieldMdp = new TextField();
    private Label textLicence = new Label("Licence : ");
    private final TextField textFieldLicence = new TextField();
    private Label textDateI = new Label("Date d'inscription : ");
    private final TextField textFieldDateI = new TextField();
    private Label textType = new Label("Type : ");
    private final TextField textFieldType = new TextField();


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


    public NouvJoueurPane(){

        Text scenetitle = new Text("NouvJoueurPane");
        scenetitle.setId("scene-title-text");
        this.add(scenetitle, 0, 0);

        Button btnAdd = new Button("Valider");
        this.add(btnAdd,1,12);

        Button btnRet = new Button("Retour");
        this.add(btnRet,2,12);

        textId.setId("text_id");
        this.add(textId, 0, 2);
        this.add(textFieldId, 1, 2);

        textNom.setId("text_nom");
        this.add(textNom, 0, 3);
        this.add(textFieldNom, 1, 3);

        textPrenom.setId("text_prenom");
        this.add(textPrenom, 0, 4);
        this.add(textFieldPrenom, 1, 4);

        textDateN.setId("text_daten");
        this.add(textDateN, 0, 5);
        this.add(textFieldDateN, 1, 5);

        textLogin.setId("text_login");
        this.add(textLogin, 0, 6);
        this.add(textFieldLogin, 1, 6);

        textMdp.setId("text_mdp");
        this.add(textMdp, 0, 7);
        this.add(textFieldMdp, 1, 7);

        textLicence.setId("text_licence");
        this.add(textLicence, 0, 8);
        this.add(textFieldLicence, 1, 8);

        textDateI.setId("text_datei");
        this.add(textDateI, 0, 9);
        this.add(textFieldDateI, 1, 9);

        textType.setId("text_type");
        this.add(textType, 0, 10);
        ComboBox type = new ComboBox();
        type.getItems().addAll("Entraineur","Joueur");
        this.add(type, 1, 10);



                btnAdd.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {

                LicencieDAO lDAO = new LicencieDAO();
                Licencie l = new Licencie();


                l.setId(Integer.parseInt(textFieldId.getText()));
                l.setNom(textFieldNom.getText());
                l.setPrenom(textFieldPrenom.getText());
                l.setDateNaissance(java.sql.Date.valueOf(textFieldDateN.getText()));
                l.setLogin(textFieldLogin.getText());
                l.setMdp(textFieldMdp.getText());
                l.setLicence(textFieldLicence.getText());
                l.setDateInscription(java.sql.Date.valueOf(textFieldDateI.getText()));
                l.setType(type.getItems().toString());

                lDAO.insertLicencie(l);

            }
        });

        btnRet.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main.getScene().setRoot(Main.getPanel("accueilDirPane"));
            }
        });

    }

}
