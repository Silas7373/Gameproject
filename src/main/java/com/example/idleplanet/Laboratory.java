package com.example.idleplanet;

public class Laboratory extends Upgrade{
    Laboratory(int setUpgradeLvl, int planetLvl){
        this.upgradeLvl = setUpgradeLvl;
        this.planetLvl = planetLvl;
        cost = 10000 *Math.pow(upgradeLvl,3) * 1.2;
        plusMoney = 10*((double) planetLvl/5);
    }


}
