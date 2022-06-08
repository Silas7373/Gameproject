package com.example.idleplanet;

public class Labatory extends Upgrade{
    Labatory(int setUpgradeLvl){
        this.upgradeLvL = setUpgradeLvl;
        cost = 100000 *Math.pow(upgradeLvL,3) * 1.2+30000;
        plusMoney = 10;
    }


}
