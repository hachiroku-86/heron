package Panels;

import DAO.JoueurDAO;
import DAO.ExceptionDAO;
import Class.Joueur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class MesJoueurPane extends GridPane{

    private Joueur j = new Joueur();
    private JoueurDAO jDAO = new JoueurDAO();
    private TableView<Joueur> tableJoueur = new TableView();
    private ArrayList listJoueur = new ArrayList();

    public MesJoueurPane(){


        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("MesJoueurPane");
        scenetitle.setId("scene-title-text");
        this.add(scenetitle, 0, 0);

        Label text1 = new Label("IdEquipe : ");
        text1.setId("text_1");
        this.add(text1, 0, 2);
        final TextField textField1 = new TextField();
        this.add(textField1,1,2);

        Button btnRet = new Button("Accueil");

        this.add(btnRet, 1, 3);

        String idEquipe = textField1.getText();
        int result = Integer.parseInt(idEquipe);


        TableColumn<Joueur, String> id = new TableColumn<>("Id");
        TableColumn<Joueur, String> prenom = new TableColumn<>("Prénom");
        TableColumn<Joueur, String> nom = new TableColumn<>("Nom");
        TableColumn<Joueur, String> equipe = new TableColumn<>("Id Equipe");
        TableColumn<Joueur, String> poste = new TableColumn<>("Poste");
        TableColumn<Joueur, String> num = new TableColumn<>("Numéro");
        TableColumn<Joueur, String> dateIns = new TableColumn<>("Date Inscription");

        tableJoueur.getColumns().addAll(id, prenom, nom, equipe, poste, num, dateIns);

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        equipe.setCellValueFactory(new PropertyValueFactory<>("idEquipe"));
        poste.setCellValueFactory(new PropertyValueFactory<>("poste"));
        num.setCellValueFactory(new PropertyValueFactory<>("num"));
        dateIns.setCellValueFactory(new PropertyValueFactory<>("dateInscription"));

        id.setSortType(TableColumn.SortType.DESCENDING);

        try {
            listJoueur = jDAO.getJoueurByEquipe(result);
            ObservableList listTransi = FXCollections.observableArrayList(listJoueur);
            tableJoueur.setItems(listTransi);
        } catch (ExceptionDAO exceptionDAO) {
            exceptionDAO.printStackTrace();
        }

        this.add(tableJoueur,1,1);


        btnRet.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main.getScene().setRoot(Main.getPanel("accueilPane"));
            }
        });
    }
}
