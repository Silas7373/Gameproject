package com.example.idleplanet;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
public class Planet {
    //ArrayLists
    ArrayList<Image> imagelist = new ArrayList<Image>();
    ArrayList<MoreCpC> moreCpS = new ArrayList<>();
    ArrayList<MineralMine> mineralMines = new ArrayList<>();
    ArrayList<Factory> factories = new ArrayList<>();
    ArrayList<AstronautBase> astronautBases = new ArrayList<>();
    ArrayList<Laboratory> laboratories = new ArrayList<>();
    ArrayList<Bank> banks = new ArrayList<>();
    ArrayList<Teleporter>teleporters = new ArrayList<>();
    //Images
    Image planet1 = new Image(getClass().getResourceAsStream("planet.png"));
    Image planet1_grey = new Image(getClass().getResourceAsStream("planet_grey.png"));
    Image planet2 = new Image(getClass().getResourceAsStream("planet2.png"));
    Image planet2_grey = new Image(getClass().getResourceAsStream("planet2_grey.png"));
    //Other (int, bool, double,...)
    Timer timer;
    Currency currency = new Currency(0);
    public int upgradeLvlCountC = 1,upgradeLvlCountA = 1,upgradeLvlCountM = 1, upgradeLvlCountF = 1, upgradeLvlCountB = 1, upgradeLvlCountL = 1, upgradeLvlCountT = 1,morecpsUp=0, moreAstronautBaseUp = 0, moreMineralMineUp = 0, moreFactoryUp = 0, moreLaboratoryUp = 0, moreBankUp = 0, moreTeleporterUp = 0, index = 0;
    boolean bool, bool1 = false;
    double plusMoneyC = 1, plusMoneyA = 0, plusMoneyF = 0, plusMoneyM = 0, plusMoneyL = 0, plusMoneyB = 0, plusMoneyT = 0;
    Planet(){
        imagelist.add(planet1);
        imagelist.add(planet1_grey);
        imagelist.add(planet2);
        imagelist.add(planet2_grey);
    }
    public void planetClicked(ImageView planetImage) {
        planetImage.setImage(imagelist.get(index+1));
        planetImage.setFitHeight(130);
        planetImage.setFitWidth(151);
    }
    public void setMoney(double currency){
        this.currency.setMoney(currency);
    }
    public void planetReleased(ImageView planetImage){
        planetImage.setImage(imagelist.get(index));
        planetImage.setFitHeight(128);
        planetImage.setFitWidth(149);
    }
    public Currency getCurrency(){return currency;}
    public double getMoney() {
        return currency.getMoneyint();
    }
    public void click(){
            currency.setMoney(currency.getMoneyint() + plusMoneyC);
    }
    public void autoMoney() {
        System.out.println("funktioniert1");
                timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        currency.setMoney(currency.getMoneyint() + plusMoneyA + plusMoneyF+ plusMoneyM+ plusMoneyL+ plusMoneyB+ plusMoneyT);

                    }
                },0,1);
        }
    public void unlockUpgradeMoreCpC(){
        MoreCpC moreCpC1 = new MoreCpC(upgradeLvlCountC);

        System.out.println(moreCpC1.getCost());
        if (moreCpC1.getCost() <= currency.getMoneyint()) {
            currency.setMoney(currency.getMoneyint() - moreCpC1.getCost());
            moreCpS.add(moreCpC1);
            morecpsUp++;
            calculatePlusMoney(1);
            System.out.println(morecpsUp + ":" + plusMoneyC);
            upgradeLvlCountC++;
        }
    }
    public void unlockUpAstonautBase(){
        AstronautBase astronautBase = new AstronautBase(upgradeLvlCountA);
        System.out.println(astronautBase.getCost());

        if (astronautBase.getCost() <= currency.getMoneyint()) {
            currency.setMoney(currency.getMoneyint() - astronautBase.getCost());
            astronautBases.add(astronautBase);
            moreAstronautBaseUp++;
            calculatePlusMoney(2);
            System.out.println(moreAstronautBaseUp + ":" + plusMoneyA);
            upgradeLvlCountA++;
        }
    }
    public void unlockUpMineralMine(){
        MineralMine mineralMine = new MineralMine(upgradeLvlCountM);
        System.out.println(mineralMine.getCost());

        if (mineralMine.getCost() <= currency.getMoneyint()) {
            currency.setMoney(currency.getMoneyint() - mineralMine.getCost());
            mineralMines.add(mineralMine);
            moreMineralMineUp++;
            calculatePlusMoney(4);
            System.out.println(moreAstronautBaseUp + ":" + plusMoneyA);
            upgradeLvlCountM++;
        }
    }
    public void unlockUpFactory() {
        Factory factory = new Factory(upgradeLvlCountF);
        System.out.println(factory.getCost());

        if (factory.getCost() <= currency.getMoneyint()) {
            currency.setMoney(currency.getMoneyint() - factory.getCost());
            factories.add(factory);
            moreFactoryUp++;
            calculatePlusMoney(3);
            System.out.println(moreAstronautBaseUp + ":" + plusMoneyA);
            upgradeLvlCountF++;
        }

    }
    public void unlockUpLaboratory() {
        Laboratory laboratory = new Laboratory(upgradeLvlCountB);
        System.out.println(laboratory.getCost());

        if (laboratory.getCost() <= currency.getMoneyint()) {
            currency.setMoney(currency.getMoneyint() - laboratory.getCost());
            laboratories.add(laboratory);
            moreLaboratoryUp++;
            calculatePlusMoney(5);
            System.out.println(moreLaboratoryUp + ":" + plusMoneyL);
            upgradeLvlCountL++;
        }

    }
    public void unlockUpBank() {
        Bank bank = new Bank(upgradeLvlCountB);
        System.out.println(bank.getCost());

        if (bank.getCost() <= currency.getMoneyint()) {
            currency.setMoney(currency.getMoneyint() - bank.getCost());
            banks.add(bank);
            moreBankUp++;
            calculatePlusMoney(6);
            System.out.println(moreBankUp + ":" + plusMoneyB);
            upgradeLvlCountB++;
        }

    }
    public void unlockUpTeleporter() {
        Teleporter teleporter = new Teleporter(upgradeLvlCountT);
        System.out.println(teleporter.getCost());

        if (teleporter.getCost() <= currency.getMoneyint()) {
            currency.setMoney(currency.getMoneyint() - teleporter.getCost());
            teleporters.add(teleporter);
            moreTeleporterUp++;
            calculatePlusMoney(7);
            System.out.println(moreTeleporterUp + ":" + plusMoneyT);
            upgradeLvlCountT++;
        }

    }
    public void calculatePlusMoney(int tryout) {
        switch (tryout) {
            case 1 -> {
                if (bool1) {
                    plusMoneyC = 1;
                } else {
                    bool1 = true;
                }
                for (int i = 0; i < morecpsUp; i++) {
                    plusMoneyC += moreCpS.get(i).getPlusMoney();
                    System.out.println("lol");
                }
            }
            case 2 -> {
                plusMoneyA = 0;
                for (int j = 0; j < moreAstronautBaseUp; j++) {
                    plusMoneyA += astronautBases.get(j).getPlusMoney();
                    System.out.println("lol");
                }
            }
            case 3 -> {
                plusMoneyF = 0;
                for (int i = 0; i < moreFactoryUp; i++) {
                    plusMoneyF += factories.get(i).getPlusMoney();
                    System.out.println("lol");
                }
            }
            case 4 -> {
                plusMoneyM = 0;
                for (int i = 0; i < moreMineralMineUp; i++) {
                    plusMoneyM += mineralMines.get(i).getPlusMoney();
                    System.out.println("lol");
                }
            }
            case 5-> {
                plusMoneyL = 0;
                for (int i = 0; i < moreLaboratoryUp; i++) {
                    plusMoneyL += laboratories.get(i).getPlusMoney();
                    System.out.println("lol");
                }
            }
            case 6-> {
                plusMoneyB = 0;
                for (int i = 0; i < moreBankUp; i++) {
                    plusMoneyB += banks.get(i).getPlusMoney();
                    System.out.println("lol");
                }
            }
            case 7-> {
                plusMoneyT = 0;
                for (int i = 0; i < moreTeleporterUp; i++) {
                    plusMoneyT += teleporters.get(i).getPlusMoney();
                    System.out.println("lol");
                }
            }
        }
    }
    public void setMoreUp(int morecpsUp, int moreAstronautBaseUp, int moreMineralMineUp, int moreFactoryUp) {
        this.morecpsUp = morecpsUp;
        this.moreAstronautBaseUp = moreAstronautBaseUp;
        this.moreMineralMineUp = moreMineralMineUp;
        this.moreFactoryUp = moreFactoryUp;
        this.moreLaboratoryUp = moreLaboratoryUp;
        this.moreBankUp = moreBankUp;
        this.moreTeleporterUp = moreTeleporterUp;
    }
    public int getMorecpsUp() {
        return morecpsUp;
    }
    public int getMoreAstronautBaseUp() {
        return moreAstronautBaseUp;
    }
    public int getMoreMineralMineUp() {
        return moreMineralMineUp;
    }
    public int getMoreFactoryUp() {
        return moreFactoryUp;
    }
    public int getMoreLaboratoryUp() {
        return moreLaboratoryUp;
    }
    public int getMoreBankUp() {
        return moreBankUp;
    }
    public int getMoreTeleporterUp() {
        return moreTeleporterUp;
    }
}