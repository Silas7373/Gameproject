package com.example.idleplanet;

public class Upgrades {

    double upgrades1 = 0;
    double upgrades2 = 0;
    double upgrades3 = 0;
    double upgrades4 = 0;
    double upgradelvl = 0;

    public double getUpgradelvl() {
        return upgradelvl;
    }
    public void setUpgradelvl() {
        upgradelvl += 0.001;
    }
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
    public void setUpgrades1() {
        upgrades1 += 0.001;
    }
    public void setUpgrades2() {
        upgrades2 += 0.01;
    }
    public void setUpgrades3() {
        upgrades3 += 0.1;
    }
    public void setUpgrades4() {
        upgrades4 += 1;
    }
}
