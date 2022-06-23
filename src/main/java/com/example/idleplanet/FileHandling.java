package com.example.idleplanet;

import com.example.idleplanet.Planet;

import javax.swing.*;
import java.io.*;
import java.util.Locale;
import java.util.Scanner;


public class FileHandling {
    public void loadFromFile(Planet planet, boolean testing) throws FileNotFoundException {
        System.out.println("LOADING LEVELS FROM FILE");
        File obj = new File("savedscore.txt");
        Scanner myReader = new Scanner(obj);

        int[] level = new int[8];
        int points = 0;
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            Scanner lineScanner = new Scanner(data);
            lineScanner.useDelimiter(":");
            String type = lineScanner.next();

            switch (type) {
                case "LVLCpC":
                    level[0] = lineScanner.nextInt();
                    System.out.println("CPC:"+level[0]);
                    break;
                case "LVLAstBase":
                    level[1] = lineScanner.nextInt();
                    System.out.println("BASE:"+level[1]);
                    break;
                case "LVLMine":
                    level[2] = lineScanner.nextInt();
                    System.out.println("MINE:"+level[2]);
                    break;
                case "LVLFactory":
                    level[3] = lineScanner.nextInt();
                    System.out.println("FACTORY:"+level[3]);
                    break;
                case "LVLLab":
                    level[4] = lineScanner.nextInt();
                    System.out.println("LAB:"+level[4]);
                    break;
                case "LVLBank":
                    level[5] = lineScanner.nextInt();
                    System.out.println("BANK:"+level[5]);
                    break;
                case "LVLTP":
                    level[6] = lineScanner.nextInt();
                    System.out.println("TP:"+level[6]);
                    break;
                case "Points":
                    points = lineScanner.nextInt();
                    System.out.println("Points"+points);
                    break;
                case "PlanetLvl":
                    level[7] = lineScanner.nextInt();
                    System.out.println("PlanetLvl: "+level[7]);
            }
        }
        planet.setMoreUp(level[0],level[1],level[2],level[3],level[4],level[5],level[6]);
        planet.setPlanetLvl(level[7]);
        if (testing){
            planet.setMoney(points);
        }

        myReader.close();
        System.out.println("FINISHED LOADING LEVELS FROM FILE");
    }

    public void saveToFile(Planet planet) throws IOException {
        System.out.println("Starting Save to File");
        FileWriter file = new FileWriter("savedscore.txt");
        BufferedWriter buffered = new BufferedWriter(file);

        buffered.write("LVLCpC:"+planet.getMorecpsUp());
        buffered.newLine();
        buffered.write("LVLAstBase:"+planet.getMoreAstronautBaseUp());
        buffered.newLine();
        buffered.write("LVLMine:"+planet.getMoreMineralMineUp());
        buffered.newLine();
        buffered.write("LVLFactory:"+planet.getMoreFactoryUp());
        buffered.newLine();
        buffered.write("LVLLab:"+planet.getMoreLaboratoryUp());
        buffered.newLine();
        buffered.write("LVLBank:"+planet.getMoreBankUp());
        buffered.newLine();
        buffered.write("LVLTP:"+planet.getMoreTeleporterUp());
        buffered.newLine();
        buffered.write("Points:"+ (int)planet.currency.getMoneyint());
        buffered.newLine();
        buffered.write("PlanetLvl:"+ planet.getPlanetLvl());
        buffered.newLine();
        buffered.close();
        System.out.println("Finished Save to File");

    }
}