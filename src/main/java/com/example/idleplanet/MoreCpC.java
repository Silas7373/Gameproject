package com.example.idleplanet;

public class MoreCpC extends Upgrade{


    MoreCpC(int setUpgradeLvl){
        this.upgradeLvL = setUpgradeLvl;
        cost = 10 *Math.pow(upgradeLvL,3) * 1.2;
        plusMoney = 1;
    }

    /*@Override
    public void setCost(double cost) {
        super.setCost(cost = 100);
    }

    @Override
    public void setPlusMoney(double plusMoney) {
        super.setPlusMoney(plusMoney+1);
    }*/

}
