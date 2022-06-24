package com.example.idleplanet;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;

public class StartController {

    public static StartController instance;

    public StartController(){
        if (instance == null){
            instance = this;
        }
    }

    @FXML
    GridPane gridPane1;
    @FXML
    Button planet;
    @FXML
    public Label points;
    @FXML
    AnchorPane slider;
    @FXML
    Label upgradeMenu;
    @FXML
    AnchorPane basePane;
    @FXML
    StackPane myStackPane;
    @FXML
    VBox vbox;
    @FXML
    ImageView myimageView;
    @FXML
    ImageView planetImage;
    @FXML
    public Button b1, b2, b3, b4, b5, b6, b7, save;
    @FXML
    VBox infoContainer;
    @FXML
    Label infoText;
    @FXML
    TextField filename;

    Pong game = new Pong();

    Planet p = new Planet();

    MenuAnimation mAnimation = new MenuAnimation();

    FileHandling fileHandling = new FileHandling();

    boolean alreadySaving = false;

    private static final DecimalFormat df = new DecimalFormat("0");

    @FXML
    public void initialize() throws FileNotFoundException {
        mAnimation.openMenu(slider, gridPane1);
        mAnimation.closeInfo(infoContainer);
        p.autoMoney();
        Autoclick1();
        fileHandling.loadFromFile(p,true);

    }

    public void startGame(ActionEvent event) throws IOException {
        fileHandling.saveToFile(p);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        game.setPoints(Double.parseDouble(points.getText()));
        stage.setScene(new Scene(game.createContent()));
        stage.show();
    }

    public void openMenu(){
        mAnimation.openMenu(slider, gridPane1);
    }

    public void buttonClicked(){
        p.planetClicked(planetImage);
    }

    public void buttonReleased(){
           p.planetReleased(planetImage);
    }

    public void menuPressed(){
        myimageView.setImage(new Image(getClass().getResourceAsStream("menu_icon_grey.png")));
    }

    public void menuReleased(){
        myimageView.setImage(new Image(getClass().getResourceAsStream("menu_icon.png")));
    }

    public void nextPlanet() throws FileNotFoundException {


            if (p.getCurrency().getMoneyint() >= p.getNextplanetcost()){
                p.nextPlanet();
            }


    }

    public void setPlanetImage(ImageView PlanetImage){
        planetImage = PlanetImage;
    }

    public void btn1(){

        mAnimation.openInfo(1, infoText, infoContainer);
    }

    public void btn2(){

        mAnimation.openInfo(2, infoText, infoContainer);
    }

    public void btn3(){

        mAnimation.openInfo(3, infoText, infoContainer);
    }

    public void btn4(){
        mAnimation.openInfo(4, infoText, infoContainer);
    }

    public void btn5(){
        mAnimation.openInfo(5, infoText, infoContainer);
    }

    public void btn6(){
        mAnimation.openInfo(6, infoText, infoContainer);
    }

    public void btn7(){
        mAnimation.openInfo(7, infoText, infoContainer);
    }

    public void saveInfo(){mAnimation.openInfo(8, infoText, infoContainer);}

    public void closeInfo(){
        mAnimation.closeInfo(infoContainer);
    }

    public void buyUpMoreCpC(){
        p.unlockUpgradeMoreCpC(false);
    }

    public void buyUpAstonautBase(){
        p.unlockUpAstonautBase(false);
    }

    public void buyUpMineralMine(){
        p.unlockUpMineralMine(false);
    }

    public void buyUpFactory(){
        p.unlockUpFactory(false);
    }

    public void buyUpLaboratory(){
        p.unlockUpLaboratory(false);
    }

    public void buyUpBank(){
        p.unlockUpBank(false);
    }
    public void buyUpTeleporter(){
        p.unlockUpTeleporter(false);
    }

    public void Autoclick1() {
        Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    update(p.getMoney());
                }
            },0,1);
    }
    public void startAutomoney(){
        p.autoMoney();
    }
    public void update(double value) {
        Platform.runLater(() -> {
            points.setText(String.valueOf(df.format(value)));
        });
    }

    public void onClick(){
        p.click();
    }

    public void setMoney(double currency){p.setMoney(currency);}

    public void SavetoFile() throws IOException {
        fileHandling.saveToFile(p);

        if (!alreadySaving){
            alreadySaving = true;
            autoSave();
        }
    }

    public void LoadFile() throws FileNotFoundException {
        fileHandling.loadFromFile(p,false);
    }

    public void autoSave(){
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {

                    fileHandling.saveToFile( p);
                    System.out.println("Score saved");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        },0,40000);

    }
}