package com.example.idleplanet;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.util.Duration;
import java.util.Timer;
import java.util.TimerTask;

public class HelloController {
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
    Button button1;


    @FXML
    public void initialize() {
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



       });

        menuExit.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);
            slide.setToX(-165.6);
            slide.play();

            slider.setTranslateX(0);
            gridPane1.setTranslateX(-80);


        });
    }

    Timer timer;

    Currency currency = new Currency(0);
    int geld = currency.getMoneyint();

    public void onButtonClick() {
        currency.setMoney(currency.money + currency.getPlanetstage());
        points.setText(currency.getMoney());
    }
    public void Autoclick1() {

        timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                currency.setMoney(currency.getMoneyint()+1 /*+ currency.getUpgrades()*/);
                update(currency.getMoneyint());
            }
        },0,1000);

    }
    public void update(int value) {
        Platform.runLater(() -> {
            points.setText(String.valueOf(value));
        });
    }
}