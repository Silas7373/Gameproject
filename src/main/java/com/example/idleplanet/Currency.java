package com.example.idleplanet;

public class Currency {
    int money;
    int[] lvlstage = new int[10];
    int[] planetstage = new int[10];

    Currency(int money){
        planetstage[0] = 1;
        this.money = money;
    }

    public int getPlanetstage() {
        return planetstage[0];
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getMoney() {
        return String.valueOf(money);
    }
}
