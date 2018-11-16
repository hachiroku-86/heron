package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    private String a = "";
    private String b = "";
    private String c = "";
    private double result = 0;
    private boolean testop = false;
    private final Text actiontarget1 = new Text();
    private final Text actiontarget2 = new Text();
    private final Text actiontargetSigne = new Text();
    private final Text actiontargetResult = new Text();
    private boolean testadd = false;
    private boolean testsous = false;
    private boolean testmult = false;
    private boolean testdiv = false;
    private boolean testexpo = false;
    private boolean testequal = false;
    private boolean testrac = false;
    private boolean testln = false;
    private boolean testexp = false;

    private void addNombre(Button bouton){
        bouton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(!testop){
                    a = a + bouton.getText();
                    actiontarget1.setText(a);
                }else{
                    c = c + bouton.getText();
                    actiontarget2.setText(c);
                }
            }
        });
    }

    private Operazion grec = new Operazion();

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Machine à calculer");
        primaryStage.show();

        VBox freeBox = new VBox(2);
        GridPane grid = new GridPane();
        GridPane grid2 = new GridPane();

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(80, 35, 25, 25));

        grid2.setAlignment(Pos.CENTER);
        grid2.setHgap(10);
        grid2.setVgap(10);
        grid2.setPadding(new Insets(10, 10, 10, 10));

        freeBox.getChildren().add(grid);
        freeBox.getChildren().add(grid2);

        Scene scene = new Scene(freeBox, 600, 450);
        primaryStage.setScene(scene);

        scene.getStylesheets().add (Main.class.getResource("calculette.css").toExternalForm());


        Button btn1 = new Button("1");
        btn1.setId("btnr");
        grid.add(btn1, 1, 3);

        Button btn2 = new Button("2");
        btn2.setId("btnr");
        grid.add(btn2, 2, 3);

        Button btn3 = new Button("3");
        btn3.setId("btnr");
        grid.add(btn3, 3, 3);

        Button btn4 = new Button("4");
        btn4.setId("btnr");
        grid.add(btn4, 1, 2);

        Button btn5 = new Button("5");
        btn5.setId("btnr");
        grid.add(btn5, 2, 2);

        Button btn6 = new Button("6");
        btn6.setId("btnr");
        grid.add(btn6, 3, 2);

        Button btn7 = new Button("7");
        btn7.setId("btnr");
        grid.add(btn7, 1, 1);

        Button btn8 = new Button("8");
        btn8.setId("btnr");
        grid.add(btn8, 2, 1);

        Button btn9 = new Button("9");
        btn9.setId("btnr");
        grid.add(btn9, 3, 1);

        Button btnC = new Button("C");
        btnC.setId("btns");
        grid.add(btnC, 5, 4);

        Button btn0 = new Button("0");
        btn0.setId("btnr");
        grid.add(btn0, 2, 4);

        Button btnPoint = new Button(".");
        btnPoint.setId("btns");
        grid.add(btnPoint, 3, 4);

        Button btnPlus = new Button("+");
        btnPlus.setId("btns");
        grid.add(btnPlus, 5, 1);

        Button btnMoins = new Button("-");
        btnMoins.setId("btns");
        grid.add(btnMoins, 6, 1);

        Button btnMult = new Button("*");
        btnMult.setId("btns");
        grid.add(btnMult, 5, 2);

        Button btnDivis = new Button("÷");
        btnDivis.setId("btns");
        grid.add(btnDivis, 6, 2);

        Button btnExpo = new Button("^");
        btnExpo.setId("btns");
        grid.add(btnExpo, 5, 3);

        Button btnRac = new Button("√");
        btnRac.setId("btns");
        grid.add(btnRac, 6, 3);

        Button btnLn = new Button("ln");
        btnLn.setId("btns");
        grid.add(btnLn, 7, 1);

        Button btnExp = new Button("e");
        btnExp.setId("btns");
        grid.add(btnExp, 7, 2);

        Button btnEqual = new Button("=");
        btnEqual.setId("btns");
        grid.add(btnEqual, 6, 4);



        grid2.add(actiontarget1, 3, 6);
        actiontarget1.setId("actiontarget1");

        grid2.add(actiontarget2, 5, 6);
        actiontarget2.setId("actiontarget2");

        grid2.add(actiontargetSigne, 4, 6);
        actiontargetSigne.setId("actiontargetSigne");

        grid2.add(actiontargetResult, 3, 7);
        actiontargetResult.setId("actiontargetResult");

        addNombre(btn0);
        addNombre(btn1);
        addNombre(btn2);
        addNombre(btn3);
        addNombre(btn4);
        addNombre(btn5);
        addNombre(btn6);
        addNombre(btn7);
        addNombre(btn8);
        addNombre(btn9);
        addNombre(btnPoint);

        btnC.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                a = "";
                actiontarget1.setText(a);
                b = "";
                actiontargetSigne.setText(b);
                c = "";
                actiontarget2.setText(c);
                testop = false;
                testequal = false;
            }
        });

        btnPlus.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                b = btnPlus.getText();
                actiontargetSigne.setText(b);
                testop = true;
                testadd = true;
                testmult = false;
                testsous = false;
                testdiv = false;
                testexpo =false;
                testrac = false;
                testln = false;
                testexp = false;


                if(testequal){
                    a = String.valueOf(result);
                    actiontarget1.setText(String.valueOf(result));
                    c = "";
                    actiontarget2.setText(c);
                }
            }
        });

        btnMult.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                b = btnMult.getText();
                actiontargetSigne.setText(b);
                testop = true;
                testmult = true;
                testadd = false;
                testsous = false;
                testdiv = false;
                testexpo =false;
                testrac = false;
                testln = false;
                testexp = false;

                if(testequal){
                    a = String.valueOf(result);
                    actiontarget1.setText(String.valueOf(result));
                    c = "";
                    actiontarget2.setText(c);
                }
            }
        });

        btnMoins.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                b = btnMoins.getText();
                actiontargetSigne.setText(b);
                testop = true;
                testsous = true;
                testadd = false;
                testmult = false;
                testdiv = false;
                testexpo =false;
                testrac =false;
                testln = false;
                testexp = false;

                if(testequal){
                    a = String.valueOf(result);
                    actiontarget1.setText(String.valueOf(result));
                    c = "";
                    actiontarget2.setText(c);
                }
            }
        });

        btnDivis.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                b = btnDivis.getText();
                actiontargetSigne.setText(b);
                testop = true;
                testdiv = true;
                testadd = false;
                testsous = false;
                testmult = false;
                testexpo =false;
                testrac = false;
                testln = false;
                testexp = false;

                if(testequal){
                    a = String.valueOf(result);
                    actiontarget1.setText(String.valueOf(result));
                    c = "";
                    actiontarget2.setText(c);
                }
            }
        });

        btnExpo.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                b = btnExpo.getText();
                actiontargetSigne.setText(b);
                testop = true;
                testexpo = true;
                testadd = false;
                testsous = false;
                testmult = false;
                testdiv = false;
                testrac = false;
                testln = false;
                testexp = false;

                if(testequal){
                    a = String.valueOf(result);
                    actiontarget1.setText(String.valueOf(result));
                    c = "";
                    actiontarget2.setText(c);
                }
            }
        });

        btnRac.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                b = btnRac.getText();
                actiontargetSigne.setText(b);
                testop = true;
                testrac = true;
                testexpo = false;
                testadd = false;
                testsous = false;
                testmult = false;
                testdiv = false;
                testln = false;
                testexp = false;

                if(testrac){
                    result = grec.rac(a);
                    actiontargetResult.setText(String.valueOf(result));
                }


            }
        });

        btnLn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                b = btnLn.getText();
                actiontargetSigne.setText(b);
                testop = true;
                testrac = true;
                testln = true;
                testexpo = false;
                testadd = false;
                testsous = false;
                testmult = false;
                testdiv = false;
                testrac = false;
                testexp = false;

                if(testln){
                    result = grec.log(a);
                    actiontargetResult.setText(String.valueOf(result));
                }


            }
        });

        btnExp.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                b = btnExp.getText();
                actiontargetSigne.setText(b);
                testop = true;
                testrac = true;
                testexp = true;
                testexpo = false;
                testadd = false;
                testsous = false;
                testmult = false;
                testdiv = false;
                testrac = false;

                if(testexp){
                    result = grec.exp(a);
                    actiontargetResult.setText(String.valueOf(result));
                }


            }
        });

        btnEqual.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                double stocka = Double.parseDouble(a);
                double stockb = Double.parseDouble(c);
                testequal = true;

                if(testadd){
                    result = grec.add(stocka, stockb);
                }else if(testsous){
                    result = grec.sous(stocka, stockb);
                }else if(testmult){
                    result = grec.mult(stocka, stockb);
                }else if(testdiv){
                    result = grec.div(stocka, stockb);
                }else if(testexpo){
                    result = grec.expo(stocka, stockb);
                }
                actiontargetResult.setText(String.valueOf(result));


            }
        });

    }

    public static void main(String[] args) {
        launch(args);
    }
}