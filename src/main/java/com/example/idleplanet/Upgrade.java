package com.example.idleplanet;
abstract class Upgrade {

    protected String name = "";
    protected double cost = 0;
    protected double plusMoney =0;
    protected int upgradeLvl = 0;
    protected int planetLvl = 0;
    public String getName() {
        return name;
    }
    public double getCost() {
        return cost;
    }
    public double getPlusMoney() {
        return plusMoney;
    }
          //currency.getMoneyInt übergeben
    public void setPlusMoney(double plusMoney) {
        this.plusMoney = plusMoney;
    }
    public void setUpgradeLvl(int upgradeLvl) {
        this.upgradeLvl = upgradeLvl;
    }
    public void setPlanetLvl(int planetLvl) {
        this.planetLvl = planetLvl;
    }
}