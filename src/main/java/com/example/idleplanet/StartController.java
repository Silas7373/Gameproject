package com.example.idleplanet;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

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
    Label points;
    @FXML
    AnchorPane slider;
    @FXML
    Label menuExit;
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
    ImageView myimageView1;
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


    int check;
    int index = 0;
    boolean menuSwitch = true;

    ArrayList<Image> imagelist = new ArrayList<Image>();
    PlanetAnimation pAnimation = new PlanetAnimation();


    public void openMenu(){
        infoContainer.setTranslateY(250);
        slider.setTranslateX(-165.6);
        gridPane1.setTranslateX(-80);

        if(menuSwitch == true) {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);
            slide.setToX(0);
            slide.play();

            slider.setTranslateX(-165.6);
            gridPane1.setTranslateX(0);
            menuSwitch = false;
        }
        else if (menuSwitch == false)
        {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);
            slide.setToX(-165.6);
            slide.play();

            slider.setTranslateX(0);
            gridPane1.setTranslateX(-80);
            menuSwitch = true;
        }
    }


    public void buttonClicked(){
        pAnimation.planetClicked(planetImage);
    }


   public void buttonReleased(){
           pAnimation.planetReleased(planetImage);
    }

    public void menuPressed(){
        myimageView.setImage(new Image(getClass().getResourceAsStream("menu_icon_grey.png")));
    }

    public void menuReleased(){
        myimageView.setImage(new Image(getClass().getResourceAsStream("menu_icon.png")));
    }

    public void menuExitPressed(){
        myimageView1.setImage(new Image(getClass().getResourceAsStream("menu_icon_grey.png")));
    }

    public void menuExitReleased(){
        myimageView1.setImage(new Image(getClass().getResourceAsStream("menu_icon.png")));
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
        check = 1;
        openInfo(check);
    }

    public void btn2(){
        check = 2;
        openInfo(check);
    }

    public void btn3(){
        check = 3;
        openInfo(check);
    }

    public void btn4(){
        check = 4;
        openInfo(check);
    }

    public void openInfo(int b){
        if (b == 1)
        {
            infoText.setText("Mit diesem Upgrade\nwird automatisch für\ndich geclickt.");
        }
        else if (b == 2)
        {
            infoText.setText("upgrade");
        }
        else if (b == 3)
        {
            infoText.setText("");
        }
        else if (b == 4)
        {
            infoText.setText("Wenn du dieses \nUpgrade kaufst, \nbekommst du einen \nneuen Planeten.");
        }

        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.3));
        slide.setNode(infoContainer);
        slide.setToY(0);
        slide.play();
        infoContainer.setTranslateY(0);
    }

    public void closeInfo(){
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.3));
        slide.setNode(infoContainer);
        slide.setToY(122.4);
        slide.play();
        infoContainer.setTranslateY(122.4);
    }


    Timer timer;

    Currency currency = new Currency(0);
    double geld = currency.getMoneyint();
    public static int lol = 0;
    boolean bool = true;
    Upgrades upgrades = new Upgrades();
    private static final DecimalFormat df = new DecimalFormat("0");

    public void onButtonClick() {
        currency.setMoney(currency.money + currency.getPlanetstage());
        points.setText(String.valueOf(df.format(currency.getMoneyint())));
    }
    public void Autoclick1() {
        if (bool){
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    currency.setMoney(currency.getMoneyint()+ upgrades.getUpgrades1()+upgrades.getUpgrades2() + upgrades.getUpgrades3() + upgrades.getUpgrades4());
                    update(currency.getMoneyint());
                }
            },0,1);
            bool = false;
        }
        else{

            if (upgrades.getUpgradelvl1() < 0.099 ){
                upgrades.setUpgradelvl1();
                upgrades.setUpgrades1(upgrades.getUpgrades1() + upgrades.getUpgradelvl1());
            }
        }
    }
    public void update(double value) {
        Platform.runLater(() -> {
            points.setText(String.valueOf(df.format(value)));
        });
    }
}


