package Panels;

import DAO.JoueurDAO;
import DAO.ExceptionDAO;
import Class.Joueur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class PublicPane extends GridPane{

    private JoueurDAO jDAO = new JoueurDAO();
    private TableView<Joueur> tableJoueur = new TableView();
    private ArrayList listJoueur = new ArrayList();

    public PublicPane(){


        this.setAlignment(Pos.CENTER_LEFT);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(25, 25, 25, 25));

        Button btnJoueurs = new Button("Voir les joueurs professionnels");
        Button btnRet = new Button("Retour");

        this.add(btnJoueurs, 1, 1);
        this.add(btnRet, 1, 2);

        TableColumn<Joueur, String> id = new TableColumn<>("Id");
        TableColumn<Joueur, String> prenom = new TableColumn<>("Prénom");
        TableColumn<Joueur, String> nom = new TableColumn<>("Nom");
        TableColumn<Joueur, String> equipe = new TableColumn<>("Id Equipe");
        TableColumn<Joueur, String> poste = new TableColumn<>("Poste");
        TableColumn<Joueur, String> num = new TableColumn<>("Numéro");
        TableColumn<Joueur, String> dateIns = new TableColumn<>("Date Inscription");
        TableColumn<Joueur, String> dateNaissance = new TableColumn<>("Date Naissance");

        tableJoueur.getColumns().addAll(id, prenom, nom, equipe, poste, num, dateIns, dateNaissance);

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        equipe.setCellValueFactory(new PropertyValueFactory<>("idEquipe"));
        poste.setCellValueFactory(new PropertyValueFactory<>("poste"));
        num.setCellValueFactory(new PropertyValueFactory<>("num"));
        dateIns.setCellValueFactory(new PropertyValueFactory<>("dateInscription"));
        dateNaissance.setCellValueFactory(new PropertyValueFactory<>("dateNaissance"));

        id.setSortType(TableColumn.SortType.DESCENDING);

        try {
            listJoueur = jDAO.getAllJoueur();
            ObservableList listTransi = FXCollections.observableArrayList(listJoueur);
            tableJoueur.setItems(listTransi);
        } catch (ExceptionDAO exceptionDAO) {
            exceptionDAO.printStackTrace();
        }

        this.add(tableJoueur,1,1);

        btnJoueurs.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main.getScene().setRoot(Main.getPanel("publicJoueursProPane"));
            }
        });

        btnRet.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main.getScene().setRoot(Main.getPanel("accueilPane"));
            }
        });
    }
}
