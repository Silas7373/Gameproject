package com.example.idleplanet;

public class MoreCpC extends Upgrade{
    MoreCpC(int setUpgradeLvl){
        this.upgradeLvL = setUpgradeLvl;
        cost = 10 *Math.pow(upgradeLvL,3) * 1.2;
        plusMoney = 1;
    }
}
