package com.example.idleplanet;
public class AstronautBase extends Upgrade{
    AstronautBase(int setUpgradeLvl, int planetLvl){
        this.upgradeLvl = setUpgradeLvl;
        this.planetLvl = planetLvl;
        cost = 1 *Math.pow(upgradeLvl,3) * 1.2*(planetLvl);
        plusMoney = 0.001;
    }
}
