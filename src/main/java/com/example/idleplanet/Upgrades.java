package com.example.idleplanet;

public class Upgrades {

    double upgrades1 = 0;
    double upgrades2 = 0;
    double upgrades3 = 0;
    double upgrades4 = 0;
    double upgradelvl1 = 0;
    double upgradelvl2 = 0;
    double upgradelvl3 = 0;
    double upgradelvl4 = 0;

    public double getUpgradelvl1() {
        return upgradelvl1;
    }
    public void setUpgradelvl1() {
        upgradelvl1 += 0.001;
    }
    public void setUpgradelvl2() {
        upgradelvl2 += 0.01;
    }
    public void setUpgradelvl3() {
        upgradelvl3 += 0.1;
    }
    public void setUpgradelvl4() {upgradelvl4 += 1;}
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
    public void setUpgrades1(double v) {
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
