package com.example.idleplanet;

public class Bank extends Upgrade{
    Bank(int setUpgradeLvl, int planetLvl){
        this.upgradeLvl = setUpgradeLvl;
        this.planetLvl = planetLvl;
        cost = 1 *Math.pow(upgradeLvl,3) * 1.2*(planetLvl);
        plusMoney = 20;
    }
}
