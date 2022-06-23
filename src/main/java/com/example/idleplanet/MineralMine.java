package com.example.idleplanet;
public class MineralMine extends Upgrade{
    MineralMine(int setUpgradeLvl, int planetLvl){
        this.upgradeLvl = setUpgradeLvl;
        this.planetLvl = planetLvl;
        cost = 1 *Math.pow(upgradeLvl,3) * 1.2*(planetLvl);
        plusMoney = 0.1;
    }
}
