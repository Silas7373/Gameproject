package com.example.idleplanet;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ResourceBundle;

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
    public void initialize() {
        slider.setTranslateX(-165);
        gridPane1.setTranslateX(-80);

       upgradeMenu.setOnMouseClicked(event -> {
           TranslateTransition slide = new TranslateTransition();
           slide.setDuration(Duration.seconds(0.4));
           slide.setNode(slider);
           slide.setToX(0);
           slide.play();

           slider.setTranslateX(-165);
           gridPane1.setTranslateX(0);


       });

        menuExit.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);
            slide.setToX(-165);
            slide.play();

            slider.setTranslateX(0);
            gridPane1.setTranslateX(-80);


        });
    }

    Timer timer;

    Currency currency = new Currency(0);
    int currencyCounter = 0;
    int geld = currency.getMoneyint();

    public void onButtonClick() {
        currency.setMoney(currency.money + currency.getPlanetstage());
        points.setText(currency.getMoney());

    }

    public void Start() {
        setTimer();
        timer.start();

    }

    /*public void Automatic(){
        for(int i = 0; 1<3;i++){
            currency.setMoney(currency.getMoneyint()+currency.getPlanetstage());
            points.setText(currency.getMoney());

        }
    }*/
    public void setTimer() {
        currencyCounter = currency.getMoneyint();


        timer = new Timer(1000, new ActionListener() {


            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                currencyCounter += 1;
                points.setText(String.valueOf(currencyCounter));

            }
        });


    }

    public void Automatic(javafx.event.ActionEvent actionEvent) {
    }
}