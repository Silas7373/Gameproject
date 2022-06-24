package com.example.idleplanet;

public class Bank extends Upgrade{
    Bank(int setUpgradeLvl, int planetLvl){
        this.upgradeLvl = setUpgradeLvl;
        this.planetLvl = planetLvl;
        cost = 100000 *Math.pow(upgradeLvl,3) * 1.2;
        plusMoney = 20*((double) planetLvl/5);
    }
}
