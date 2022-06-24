package com.example.idleplanet;

public class Teleporter extends Upgrade{
    Teleporter(int setUpgradeLvl, int planetLvl){
        this.upgradeLvl = setUpgradeLvl;
        this.planetLvl = planetLvl;
        cost = 1000000 *Math.pow(upgradeLvl,3) * 1.2;
        plusMoney = 20*((double) planetLvl/5);
    }
}
