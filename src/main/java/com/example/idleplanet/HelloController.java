package com.example.idleplanet;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.Timer;


public class HelloController
        implements Serializable {
    @FXML
    private Label welcomeText;
    @FXML
    GridPane gridPane1;
    @FXML
    Button planet;
    @FXML
    Label points;


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
            public void actionPerformed(ActionEvent e) {
                currencyCounter += 1;
                points.setText(String.valueOf(currencyCounter));

            }
        });


    }

    public void Automatic(javafx.event.ActionEvent actionEvent) {
    }
}