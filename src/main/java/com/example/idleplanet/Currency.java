package com.example.idleplanet;

public class Currency {
    int money;
    int[] lvlstage = new int[10];
    int[] planetstage = new int[10];
    int [] upgrades = new int[100];

    Currency(int money){
        planetstage[0] = 1;
        this.money = money;
    }

    public void setUpgrades(int[] upgrades) {

        this.upgrades = upgrades;
    }

    public int getUpgrades() {
        for (int i = 0; i<100;i++){
            if (upgrades[0] == 0){
                return 0;
            }
            else if(upgrades[i]==0){
                return upgrades[i-1];
            }
        }
        return 0;
    }

    public int getPlanetstage() {
        return planetstage[0];
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoneyint(){return money;}
    public String getMoney() {
        return String.valueOf(money);
    }
}
