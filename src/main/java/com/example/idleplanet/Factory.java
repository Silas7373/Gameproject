package com.example.idleplanet;
public class Factory extends Upgrade{
    Factory(int setUpgradeLvl, int planetLvl){
        this.upgradeLvl = setUpgradeLvl;
        this.planetLvl = planetLvl;
        cost = 1000 *Math.pow(upgradeLvl,3) * 1.2;
        plusMoney = 10*((double) planetLvl/5);
    }

}
