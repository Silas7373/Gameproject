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

    int index = 0;

    ArrayList<Image> imagelist = new ArrayList<Image>();

    Image planet1 = new Image(getClass().getResourceAsStream("planet.png"));
    Image planet1_grey = new Image(getClass().getResourceAsStream("planet_grey.png"));
    Image planet2 = new Image(getClass().getResourceAsStream("planet2.png"));
    Image planet2_grey = new Image(getClass().getResourceAsStream("planet2_grey.png"));



    @FXML
    public void initialize() {
        imagelist.add(planet1);
        imagelist.add(planet1_grey);
        imagelist.add(planet2);
        imagelist.add(planet2_grey);

        slider.setTranslateX(-165.6);
        gridPane1.setTranslateX(-80);


        upgradeMenu.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);
            slide.setToX(0);
            slide.play();

            slider.setTranslateX(-165.6);
            gridPane1.setTranslateX(0);

            slide.setOnFinished((ActionEvent e) -> {
                upgradeMenu.setVisible(false);
                menuExit.setVisible(true);
            });
        });


            menuExit.setOnMouseClicked(event -> {
                TranslateTransition slide = new TranslateTransition();
                slide.setDuration(Duration.seconds(0.4));
                slide.setNode(slider);
                slide.setToX(-165.6);
                slide.play();

                slider.setTranslateX(0);
                gridPane1.setTranslateX(-80);

                slide.setOnFinished((ActionEvent e) -> {
                    upgradeMenu.setVisible(true);
                    menuExit.setVisible(false);
                });
            });


        upgradeMenu.setOnMousePressed(event -> {
            myimageView.setImage(new Image(getClass().getResourceAsStream("menu_icon_grey.png")));
        });

        upgradeMenu.setOnMouseReleased(event -> {
            myimageView.setImage(new Image(getClass().getResourceAsStream("menu_icon.png")));
        });

        menuExit.setOnMousePressed(event -> {
            myimageView1.setImage(new Image(getClass().getResourceAsStream("menu_icon_grey.png")));
        });

        menuExit.setOnMouseReleased(event -> {
            myimageView1.setImage(new Image(getClass().getResourceAsStream("menu_icon.png")));
        });

    }

    public void buttonClicked(){

        planetImage.setImage(imagelist.get(index+1));
        planetImage.setFitHeight(130);
        planetImage.setFitWidth(151);
    }


   public void buttonReleased(){

           planetImage.setImage(imagelist.get(index));
           planetImage.setFitHeight(128);
           planetImage.setFitWidth(149);

    }

    public void nextPlanet(){
        if(index+2 < imagelist.size()) {
            index = index + 2;
            planetImage.setImage(imagelist.get(index));
            planetImage.setFitHeight(128);
            planetImage.setFitWidth(149);
        }
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


