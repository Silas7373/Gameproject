package com.example.idleplanet;
public class AstronautBase extends Upgrade{
    AstronautBase(int setUpgradeLvl, int planetLvl){
        this.upgradeLvl = setUpgradeLvl;
        this.planetLvl = planetLvl;
        cost = 10 *Math.pow(upgradeLvl,3) * 1.2;
        plusMoney = 0.001*((double) planetLvl/5);
    }
}
