package com.example.idleplanet;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class StartController {
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
    Button b1;
    @FXML
    Button b2;
    @FXML
    Button b3;
    @FXML
    Button b4;
    @FXML
    VBox infoContainer;
    @FXML
    Label infoText;

    int index = 0;

    ArrayList<Image> imagelist = new ArrayList<Image>();
    Planet p = new Planet();
    MenuAnimation mAnimation = new MenuAnimation();
    private static final DecimalFormat df = new DecimalFormat("0");
    @FXML
    public void initialize() {
        mAnimation.openMenu(slider, gridPane1);
        mAnimation.closeInfo(infoContainer);
        p.autoMoney();
        Autoclick1();
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


    public void nextPlanet(){
        if(index+2 < imagelist.size()) {
            index = index + 2;
            planetImage.setImage(imagelist.get(index));
            planetImage.setFitHeight(128);
            planetImage.setFitWidth(149);

        }
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

    public void closeInfo(){
        mAnimation.closeInfo(infoContainer);
    }

    public void buyUp(){
        p.buyUpgrade();
    }

/*

    double geld = currency.getMoneyint();
    public static int lol = 0;
    boolean bool = true;
    Upgrades upgrades = new Upgrades();


    public void onButtonClick() {
        currency.setMoney(currency.money + currency.getPlanetstage());
        points.setText(String.valueOf(df.format(currency.getMoneyint())));
    }

    */
    public void Autoclick1() {

        Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    update(p.getMoney());
                }
            },0,1);

    }
    public void update(double value) {
        Platform.runLater(() -> {
            points.setText(String.valueOf(df.format(value)));
        });
    }
    public void onClick(){
        p.click();
    }
}


