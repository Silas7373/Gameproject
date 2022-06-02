package com.example.idleplanet;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Planet {



    ArrayList<Image> imagelist = new ArrayList<Image>();
    ArrayList<MoreCpC> moreCpS = new ArrayList<>();
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
    int morecpsUp=0;
    boolean bool;
    boolean bool1 = false;
    double plusMoney = 1;
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
    public void setMoney(double currency){
        this.currency.setMoney(currency);
    }
    public void planetReleased(ImageView planetImage){
        planetImage.setImage(imagelist.get(index));
        planetImage.setFitHeight(128);
        planetImage.setFitWidth(149);
    }

    public double getMoney() {
        return currency.getMoneyint();
    }
    public void click(){
            currency.setMoney(currency.getMoneyint() + plusMoney);
    }
    public void autoMoney() {
        if (bool){
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                        currency.setMoney(currency.getMoneyint());
                }
            },0,1);
            bool = false;
        }
        else{
            }
        }
        public void unlockUpgrade(){
            MoreCpC moreCpC1 = new MoreCpC();
            moreCpS.add(moreCpC1);
            morecpsUp ++;
            calculatePlusMoney();

            System.out.println(morecpsUp +":" + plusMoney);

        }
        public void calculatePlusMoney() {

            if (bool1) {
                plusMoney = 0;
                System.out.println("wodk");
            }
            else {
                bool1 = true;
            }
            for (int i = 0; i < morecpsUp ; i++) {
                plusMoney += moreCpS.get(i).getPlusMoney();
                System.out.println("lol");
            }
        }
}