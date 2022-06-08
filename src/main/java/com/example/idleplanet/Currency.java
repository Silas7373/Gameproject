package com.example.idleplanet;
public class Currency {
    double money;
    int[] lvlstage = new int[10];
    int[] planetstage = new int[10];


    Currency(int money){
        planetstage[0] = 1;
        this.money = money;
    }


    public double getPlanetstage() {
        return planetstage[0];
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getMoneyint(){
        return money;
    }

    public String getMoney() {
        return String.valueOf(money);
    }
}
