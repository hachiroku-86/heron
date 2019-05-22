package Panels;

import DAO.EquipeDAO;
import DAO.ExceptionDAO;
import Class.Equipe;
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

public class EquipePane extends GridPane{

    private EquipeDAO eDAO = new EquipeDAO();
    private TableView<Equipe> tableEquipe = new TableView();
    private ArrayList listEquipe = new ArrayList();

    public EquipePane(){


        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("EquipePane");
        scenetitle.setId("scene-title-text");
        this.add(scenetitle, 0, 0);

        Button btnRet = new Button("Retour");

        this.add(btnRet, 1, 2);

        TableColumn<Equipe, String> nomEntraineur = new TableColumn<>("Entraineur");
        TableColumn<Equipe, String> categorie = new TableColumn<>("Catégorie");
        TableColumn<Equipe, String> nomClub = new TableColumn<>("Club");


        tableEquipe.getColumns().addAll(nomEntraineur, categorie, nomClub);

        nomEntraineur.setCellValueFactory(new PropertyValueFactory<>("nomEntraineur"));
        categorie.setCellValueFactory(new PropertyValueFactory<>("nomCategorie"));
        nomClub.setCellValueFactory(new PropertyValueFactory<>("nomClub"));


        categorie.setSortType(TableColumn.SortType.DESCENDING);

        try {
            listEquipe = eDAO.getAllEquipe();
            ObservableList listTransi = FXCollections.observableArrayList(listEquipe);
            tableEquipe.setItems(listTransi);
        } catch (ExceptionDAO exceptionDAO) {
            exceptionDAO.printStackTrace();
        }

        this.add(tableEquipe,1,1);

        btnRet.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main.getScene().setRoot(Main.getPanel("publicPane"));
            }
        });
    }
}
