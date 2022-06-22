package com.example.idleplanet;

public class Laboratory extends Upgrade{
    Laboratory(int setUpgradeLvl){
        this.upgradeLvL = setUpgradeLvl;
        cost = 1 *Math.pow(upgradeLvL,3) * 1.2;
        plusMoney = 10;
    }


}
