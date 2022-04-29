package com.example.idleplanet;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Planet {


    ArrayList<Image> imagelist = new ArrayList<Image>();
    ArrayList<MoreCpC> moreCpCS = new ArrayList<>();
    ArrayList<MineralMine> mineralMines = new ArrayList<>();
    ArrayList<Factory> factories = new ArrayList<>();
    ArrayList<AstronautBase> astronautBases = new ArrayList<>();
    int index = 0;
    double money;
    public static int morecpccount = 0;
    Image planet1 = new Image(getClass().getResourceAsStream("planet.png"));
    Image planet1_grey = new Image(getClass().getResourceAsStream("planet_grey.png"));
    Image planet2 = new Image(getClass().getResourceAsStream("planet2.png"));
    Image planet2_grey = new Image(getClass().getResourceAsStream("planet2_grey.png"));
    Timer timer;
    Currency currency = new Currency(0);
    int morecps=0;
    boolean bool;

    Planet(){
        imagelist.add(planet1);
        imagelist.add(planet1_grey);
        imagelist.add(planet2);
        imagelist.add(planet2_grey);
    }

    public void planetClicked(ImageView planetImage) {
        planetImage.setImage(imagelist.get(index+1));
        planetImage.setFitHeight(130);
        planetImage.setFitWidth(151);
    }

    public void planetReleased(ImageView planetImage){
        planetImage.setImage(imagelist.get(index));
        planetImage.setFitHeight(128);
        planetImage.setFitWidth(149);
    }

    public double getMoney() {
        return currency.getMoneyint();
    }

    public void autoMoney() {
        if (bool){
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    currency.setMoney(currency.getMoneyint()+);
                }
            },0,1);
            bool = false;
        }
        else{
            }
        }
        public void buyUpgrade(){
            for (int j = 0;j<=99;j++){
                MoreCpC moreCpC1 = new MoreCpC();
                moreCpCS.add(moreCpC1);
                if (j == morecpccount){
                    morecpccount++;
                }
            }
            for (int i = 0; i< moreCpCS.size();i++){
                morecps = morecps + moreCpCS.get(i);
            }
        }
}