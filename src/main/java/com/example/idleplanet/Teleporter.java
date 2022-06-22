package com.example.idleplanet;

public class Teleporter extends Upgrade{
    Teleporter(int setUpgradeLvl){
        this.upgradeLvL = setUpgradeLvl;
        cost = 1 *Math.pow(upgradeLvL,3) * 1.2+3;
        plusMoney = 20;
    }
}
