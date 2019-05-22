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
import javafx.util.Callback;

import java.util.ArrayList;

public class JoueurPane extends GridPane{

    private JoueurDAO jDAO = new JoueurDAO();
    private TableView<Joueur> tableJoueur = new TableView();
    private ArrayList listJoueur = new ArrayList();

    public JoueurPane(){


        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("JoueurPane");
        scenetitle.setId("scene-title-text");
        this.add(scenetitle, 0, 0);

        Button btnRet = new Button("Retour");

        this.add(btnRet, 1, 2);

        TableColumn<Joueur, String> prenom = new TableColumn<>("Prénom");
        TableColumn<Joueur, String> nom = new TableColumn<>("Nom");
        TableColumn<Joueur, String> equipe = new TableColumn<>("Id Equipe");
        TableColumn<Joueur, String> poste = new TableColumn<>("Poste");
        TableColumn<Joueur, String> num = new TableColumn<>("Numéro");
        TableColumn<Joueur, String> dateIns = new TableColumn<>("Date Inscription");

        tableJoueur.getColumns().addAll(prenom, nom, equipe, poste, num, dateIns);

        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        equipe.setCellValueFactory(new PropertyValueFactory<>("idEquipe"));
        poste.setCellValueFactory(new PropertyValueFactory<>("poste"));
        num.setCellValueFactory(new PropertyValueFactory<>("num"));
        dateIns.setCellValueFactory(new PropertyValueFactory<>("dateInscription"));

        nom.setSortType(TableColumn.SortType.DESCENDING);

        try {
            listJoueur = jDAO.getAllJoueur();
            ObservableList listTransi = FXCollections.observableArrayList(listJoueur);
            tableJoueur.setItems(listTransi);
        } catch (ExceptionDAO exceptionDAO) {
            exceptionDAO.printStackTrace();
        }

        this.add(tableJoueur,1,1);


        tableJoueur.setColumnResizePolicy(new Callback<TableView.ResizeFeatures, Boolean>() {
            @Override
            public Boolean call(TableView.ResizeFeatures param) {
                return true;
            }
        });

        btnRet.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main.getScene().setRoot(Main.getPanel("publicPane"));
            }
        });
    }
}
