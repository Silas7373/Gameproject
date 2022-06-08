package com.example.idleplanet;
abstract class Upgrade {

    protected String name = "";
    protected double cost = 0;
    protected double plusMoney =0;
    protected int upgradeLvL = 0;
    public String getName() {
        return name;
    }
    public double getCost() {
        return cost;
    }
    public double getPlusMoney() {
        return plusMoney;
    }
    public boolean testBuyalbe(double cost){
        if (this.cost > cost) {
            return true;
        }else {
            return false;
        }
    }       //currency.getMoneyInt übergeben

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setPlusMoney(double plusMoney) {
        this.plusMoney = plusMoney;
    }

    public void setUpgradeLvL(int upgradeLvL) {
        this.upgradeLvL = upgradeLvL;
    }
}