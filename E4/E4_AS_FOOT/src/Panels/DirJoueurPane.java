package Panels;

import DAO.EntraineurDAO;
import DAO.ExceptionDAO;
import Class.Entraineur;
import DAO.JoueurDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class DirJoueurPane extends GridPane{

    private JoueurDAO jDAO = new JoueurDAO();
    private TableView<Entraineur> tableEntraineur = new TableView();
    private ArrayList listEntraineur = new ArrayList();
    private Entraineur entraineur = null;

    private Text titre = new Text("");


    public Entraineur getEntraineur() {
        return entraineur;
    }

    public void setEntraineur(Entraineur entraineur){
        this.entraineur = entraineur;
        exe();
    }


    public void exe(){

        titre.setText("Bienvenue " + entraineur.getPrenom() + " " + entraineur.getNom() + " !");

        VBox vbox = new VBox();
        this.add(vbox, 0, 1);

        vbox.getChildren().add(titre);


        TableColumn<Entraineur, String> nom = new TableColumn<>("Nom");
        TableColumn<Entraineur, String> prenom = new TableColumn<>("Prénom");
        TableColumn<Entraineur, String> num = new TableColumn<>("Numéro");
        TableColumn<Entraineur, String> poste = new TableColumn<>("Poste");
        TableColumn<Entraineur, String> dateInscription = new TableColumn<>("Inscription");

        tableEntraineur.getColumns().addAll(prenom, nom, num, poste, dateInscription);

        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        num.setCellValueFactory(new PropertyValueFactory<>("num"));
        poste.setCellValueFactory(new PropertyValueFactory<>("poste"));
        dateInscription.setCellValueFactory(new PropertyValueFactory<>("dateInscription"));

        nom.setSortType(TableColumn.SortType.DESCENDING);

        try {
            listEntraineur = jDAO.getJoueurByEntraineur(entraineur.getId());
            ObservableList listTransi = FXCollections.observableArrayList(listEntraineur);
            tableEntraineur.setItems(listTransi);
        } catch (ExceptionDAO exceptionDAO) {
            exceptionDAO.printStackTrace();
        }

        this.add(tableEntraineur,1,1);

    }

    public DirJoueurPane(){

        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("DirJoueurPane");
        scenetitle.setId("scene-title-text");
        this.add(scenetitle, 0, 0);

        Button btnAcc = new Button("Accueil");
        Button btnRet = new Button("Retour");

        this.add(btnAcc, 1, 2);
        this.add(btnRet, 2, 2);

        btnAcc.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main.getScene().setRoot(Main.getPanel("accueilPane"));
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
