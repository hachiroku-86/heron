package Panels;

import DAO.EntraineurDAO;
import DAO.ExceptionDAO;
import Class.Entraineur;
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

public class EntraineurPane extends GridPane{

    private EntraineurDAO eDAO = new EntraineurDAO();
    private TableView<Entraineur> tableEntraineur = new TableView();
    private ArrayList listEntraineur = new ArrayList();

    public EntraineurPane(){


        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("EntraineurPane");
        scenetitle.setId("scene-title-text");
        this.add(scenetitle, 0, 0);

        Button btnRet = new Button("Retour");

        this.add(btnRet, 1, 2);

        TableColumn<Entraineur, String> prenom = new TableColumn<>("Prénom");
        TableColumn<Entraineur, String> nom = new TableColumn<>("Nom");
        TableColumn<Entraineur, String> equipe = new TableColumn<>("Id Equipe");
        TableColumn<Entraineur, String> dateIns = new TableColumn<>("Date Inscription");

        tableEntraineur.getColumns().addAll(prenom, nom, equipe, dateIns);

        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        equipe.setCellValueFactory(new PropertyValueFactory<>("idEquipe"));
        dateIns.setCellValueFactory(new PropertyValueFactory<>("dateInscription"));

        nom.setSortType(TableColumn.SortType.DESCENDING);

        try {
            listEntraineur = eDAO.getAllEntraineur();
            ObservableList listTransi = FXCollections.observableArrayList(listEntraineur);
            tableEntraineur.setItems(listTransi);
        } catch (ExceptionDAO exceptionDAO) {
            exceptionDAO.printStackTrace();
        }

        this.add(tableEntraineur,1,1);


        tableEntraineur.setColumnResizePolicy(new Callback<TableView.ResizeFeatures, Boolean>() {
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
