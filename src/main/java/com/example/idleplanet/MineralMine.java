package com.example.idleplanet;
public class MineralMine extends Upgrade{
    MineralMine(int setUpgradeLvl){
        this.upgradeLvL = setUpgradeLvl;
        cost = 10000 *Math.pow(upgradeLvL,3) *1.2;
        plusMoney = 0.1;
    }
}
