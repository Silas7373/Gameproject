package com.example.idleplanet;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    GridPane gridPane1;
    @FXML
    Button planet;
    @FXML
    Label points;



    Currency currency = new Currency(0);
    public void onButtonClick(){
    currency.setMoney(currency.money + currency.getPlanetstage());
    points.setText(currency.getMoney());
    }


}