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

    Currency currency = new Currency(0);
    public void onButtonClick(){
    currency.setMoney(currency.money + currency.getPlanetstage());
    points.setText(currency.getMoney());
    }


}