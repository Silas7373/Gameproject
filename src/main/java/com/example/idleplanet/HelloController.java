package com.example.idleplanet;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class HelloController {
    @FXML
    GridPane gridPane1;
    @FXML
    Button planet;
    @FXML
    Label points;

    Currency currency;
    public void onButtonClick(){
    currency.setMoney(currency.money + currency.getPlanetstage());
    points.setText(String.valueOf(currency.getMoney()));
    }


}