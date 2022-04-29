package com.example.idleplanet;

abstract class Upgrade {

    protected String name;
    protected double cost;
    protected double plusMoney;

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
    /*double upgrades1 = 0;
    double upgrades2 = 0;
    double upgrades3 = 0;
    double upgrades4 = 0;
    double planet1_1 = 0.001;
    double planet1_2 = 0.01;
    double planet1_3 = 0.1;
    double planet1_4 = 1;
    double planet2_1 = 0;
    double planet2_2 = 0;
    double planet2_3 = 0;
    double planet2_4 = 0;
    double upgradelvl1 = 0;
    double upgradelvl2 = 0;
    double upgradelvl3 = 0;
    double upgradelvl4 = 0;

    public void setPlanet2_1(double planet2_1) {
        this.planet2_1 = planet2_1;
    }

    public void setPlanet2_2(double planet2_2) {
        this.planet2_2 = planet2_2;
    }

    public void setPlanet2_3(double planet2_3) {
        this.planet2_3 = planet2_3;
    }

    public void setPlanet2_4(double planet2_4) {
        this.planet2_4 = planet2_4;
    }

    public void setPlanet1_1(double planet1_1) {
        this.planet1_1 = planet1_1;
    }

    public void setPlanet1_2(double planet1_2) {
        this.planet1_2 = planet1_2;
    }

    public void setPlanet1_3(double planet1_3) {
        this.planet1_3 = planet1_3;
    }

    public void setPlanet1_4(double planet1_4) {
        this.planet1_4 = planet1_4;
    }

    public double getUpgradelvl1() {
        return upgradelvl1;
    }
    public double getUpgradelvl2() {
        return upgradelvl2;
    }
    public double getUpgradelvl3() {
        return upgradelvl3;
    }
    public double getUpgradelvl4() {
        return upgradelvl4;
    }
    public void setUpgradelvl1() {
        upgradelvl1 +=planet1_1+planet2_1;
    }
    public void setUpgradelvl2() {
        upgradelvl2 += planet1_2+planet2_2;
    }
    public void setUpgradelvl3() {
        upgradelvl3 += planet1_3+planet2_3;
    }
    public void setUpgradelvl4() {upgradelvl4 += planet1_4+planet2_4;}
    public double getUpgrades1() {
        return upgrades1;
    }
    public double getUpgrades2() {
        return upgrades2;
    }
    public double getUpgrades3() {
        return upgrades3;
    }
    public double getUpgrades4() {
        return upgrades4;
    }
    public void setUpgrades4(double upgrades4) {
        this.upgrades4 = upgrades4;
    }
    public void setUpgrades3(double upgrades3) {
        this.upgrades3 = upgrades3;
    }
    public void setUpgrades2(double upgrades2) {
        this.upgrades2 = upgrades2;
    }
    public void setUpgrades1(double upgrades1) {
        this.upgrades1 = upgrades1;
    }*/
}