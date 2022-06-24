package com.example.idleplanet;

public class MoreCpC extends Upgrade{
    MoreCpC(int setUpgradeLvl,int planetLvl){
        this.upgradeLvl = setUpgradeLvl;
        this.planetLvl = planetLvl;
        cost = 1 *Math.pow(upgradeLvl,3) * 1.2;
        plusMoney = 1*((double) planetLvl/5);
    }
}
