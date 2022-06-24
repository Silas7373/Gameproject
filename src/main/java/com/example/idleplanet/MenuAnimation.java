package com.example.idleplanet;

import javafx.animation.TranslateTransition;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class MenuAnimation {
    boolean menuSwitch = true;
    public static int i = 0;
    public static int i2 = 0;


    public void openMenu(AnchorPane slider, GridPane gridPane1){
        if (menuSwitch == false && i !=0)
        {
                TranslateTransition slide = new TranslateTransition();
                slide.setDuration(Duration.seconds(0.4));
                slide.setNode(slider);
                slide.setToX(-165.6);
                slide.play();

            slider.setTranslateX(0);
            gridPane1.setTranslateX(-80);
            menuSwitch = true;
        }
        else if(menuSwitch == true&& i !=0) {

            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);
            slide.setToX(0);
            slide.play();

            slider.setTranslateX(-165.6);
            gridPane1.setTranslateX(0);
            menuSwitch = false;
        }
        else if(i == 0){
            slider.setTranslateX(-165.6);
            gridPane1.setTranslateX(-80);
            i++;
        }

    }

    public void openInfo(int b, Label infoText, VBox infoContainer){
        if (b == 1)
        {
            infoText.setText(1 *Math.pow(StartController.instance.p.getMorecpsUp() + 1,3) *1.2 + "\nMit diesem Upgrade\nwird zählt dein Klick\n um eines mehr.");
        }
        else if (b == 2)
        {
            infoText.setText(10 *Math.pow(StartController.instance.p.getMoreAstronautBaseUp() + 1,3) *1.2+ "\nMit diesem Upgrade\n wird für dich\n automatisch geklickt");
        }
        else if (b == 3)
        {
            infoText.setText(100 *Math.pow(StartController.instance.p.getMoreMineralMineUp() + 1,3) * 1.2 + "\nMit diesem Upgrade\n bekommest du\n automatisch mehr");
        }
        else if (b == 4)
        {
            infoText.setText(1000 *Math.pow(StartController.instance.p.getMoreFactoryUp() + 1,3) * 1.2 + "\nWenn du dieses \nUpgrade kaufst, \nbekommst du einen \nneuen Planeten.");
        }
        else if (b == 5){
            infoText.setText(10000 *Math.pow(StartController.instance.p.getMoreLaboratoryUp() + 1,3) * 1.2 + "\nMit diesem Upgrade\nbekommest du\n automatisch noch\n mehr");
        }
        else if (b == 6){
            infoText.setText(100000 *Math.pow(StartController.instance.p.getMoreBankUp() + 1,3) * 1.2 + "\nMit diesem Upgrade\nbekommest du\n automatisch viel\n mehr");
        }
        else if (b == 7){
            infoText.setText(1000000 *Math.pow(StartController.instance.p.getMoreTeleporterUp() + 1,3) * 1.2 + "\nMit diesem Upgrade\nbekommest du\n automatisch sehr\n viel mehr");

        } else if (b == 8) {
            infoText.setText("Mit Safe startest \ndu das \nautomatische sichern");
        }
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.3));
        slide.setNode(infoContainer);
        slide.setToY(0);
        slide.play();
        infoContainer.setTranslateY(0);
    }

    public void closeInfo(VBox infoContainer){
        if(i2 != 0){
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.3));
        slide.setNode(infoContainer);
        slide.setToY(122.4);
        slide.play();
        infoContainer.setTranslateY(122.4);
        }
        if(i2 == 0){
            infoContainer.setTranslateY(122.4);
            i2++;
        }
    }
}

