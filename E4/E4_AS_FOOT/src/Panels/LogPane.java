package Panels;

import DAO.DAO;
import DAO.EntraineurDAO;
import DAO.JoueurDAO;
import Class.Licencie;
import Class.Joueur;
import Class.Entraineur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class LogPane extends GridPane {

    private String login = null;
    private String password = null;
    private Text actiontargetResult = new Text();
    private DAO dao = new DAO();

    public LogPane(){

        this.setHgap(35);
        this.setVgap(35);
        this.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("LogPane");
        scenetitle.setId("scene-title-text");
        this.add(scenetitle, 0, 0);

        Label text1 = new Label("Login : ");
        text1.setId("text_1");
        this.add(text1, 0, 2);
        final TextField textField1 = new TextField();
        this.add(textField1,1,2);


        Label text2 = new Label("Mot de passe : ");
        text2.setId("text_2");
        this.add(text2, 0, 3);
        final TextField textField2 = new TextField();
        this.add(textField2,1,3);


        this.add(actiontargetResult,1,4);
        actiontargetResult.setId("actiontargetResult");

        Button btnLog = new Button("Connexion");
        this.add(btnLog, 2,3);

        Button btnRet = new Button("Accueil");
        this.add(btnRet, 2,5);


        /*try {
            ArrayList<Joueur> listIdJoueur = jDAO.getAllJoueur();
            for(Joueur j:listIdJoueur){
                comboBox.getItems().addAll(j.getNom());
                Text infoJoueur = new Text(j.getNom());
                infoJoueur.setId("infonJoueur");
                this.add(scenetitle, 3 , 1);
            }
        } catch (ExceptionDAO exceptionDAO) {
            exceptionDAO.printStackTrace();
        }*/


        btnLog.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                login = textField1.getText();
                password = textField2.getText();
                Licencie licencie1 = dao.testLog(login, password);
                System.out.println(licencie1);


                /*if (licencie1.getLogin() != login || licencie1.getMdp() != password){
                    actiontargetResult.setText("Mauvais login ou mot de passe.");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erreur !");
                    alert.setHeaderText("Erreur lors de l'autentification.");
                    alert.setContentText("Le login ou le mot de passe que vous avez entré est incorect.");

                    alert.showAndWait();
                }


                else*/ if (licencie1.getLogin().equals(login) && licencie1.getMdp().equals(password)) {
                    actiontargetResult.setText("Bienvenue" + " " + licencie1.getPrenom() + " " + licencie1.getNom() + " !");


                    if (licencie1.getType().equals("Joueur")) {
                        JoueurDAO jDao = new JoueurDAO();
                        Joueur joueur = jDao.getJoueurById(String.valueOf(licencie1.getId()));
                        AccueilJoueurPane jPane = (AccueilJoueurPane) Main.getPanel("accueilJoueurPane");
                        jPane.setJoueur(joueur);
                        Main.getScene().setRoot(Main.getPanel("accueilJoueurPane"));
                    }

                    if (licencie1.getType().equals("Entraineur")) {
                        EntraineurDAO eDAO = new EntraineurDAO();
                        Entraineur entraineur = eDAO.getEntraineurById(String.valueOf(licencie1.getId()));
                        AccueilDirPane jPane = (AccueilDirPane) Main.getPanel("accueilDirPane");
                        jPane.setEntraineur(entraineur);
                        Main.getScene().setRoot(Main.getPanel("accueilDirPane"));
                    }

                }

                //

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
