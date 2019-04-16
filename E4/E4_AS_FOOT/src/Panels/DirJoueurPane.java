package Panels;

import DAO.ExceptionDAO;
import DAO.DirigeantDAO;
import Class.Dirigeant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class DirJoueurPane extends GridPane{

    private DirigeantDAO dDAO = new DirigeantDAO();
    private TableView<Dirigeant> tableDirigeant = new TableView();
    private ArrayList listDirigeant = new ArrayList();

    public DirJoueurPane(){

        this.setAlignment(Pos.CENTER_LEFT);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(25, 25, 25, 25));

        Button btnJoueurs = new Button("Voir les joueurs professionnels");
        Button btnRet = new Button("Retour");

        this.add(btnJoueurs, 1, 1);
        this.add(btnRet, 1, 2);

        TableColumn<Dirigeant, String> id = new TableColumn<>("Id");
        TableColumn<Dirigeant, String> type = new TableColumn<>("Type");
        TableColumn<Dirigeant, String> nom = new TableColumn<>("Nom");
        TableColumn<Dirigeant, String> prenom = new TableColumn<>("Prénom");
        TableColumn<Dirigeant, String> dateNaissance = new TableColumn<>("Date Naissance");
        TableColumn< Dirigeant, String> dateIns = new TableColumn<>("Date Inscription");

        tableDirigeant.getColumns().addAll(id, type, prenom, nom, dateNaissance, dateIns);

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        dateNaissance.setCellValueFactory(new PropertyValueFactory<>("dateNaissance"));
        dateIns.setCellValueFactory(new PropertyValueFactory<>("dateInscription"));

        id.setSortType(TableColumn.SortType.DESCENDING);

        try {
            listDirigeant = dDAO.getAllDirigeant();
            ObservableList listTransi = FXCollections.observableArrayList(listDirigeant);
            tableDirigeant.setItems(listTransi);
        } catch (ExceptionDAO exceptionDAO) {
            exceptionDAO.printStackTrace();
        }

        this.add(tableDirigeant,1,1);

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
