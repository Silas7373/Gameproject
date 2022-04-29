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
            infoText.setText("Mit diesem Upgrade\nwird automatisch für\ndich geclickt.");
        }
        else if (b == 2)
        {
            infoText.setText("upgrade");
        }
        else if (b == 3)
        {
            infoText.setText("");
        }
        else if (b == 4)
        {
            infoText.setText("Wenn du dieses \nUpgrade kaufst, \nbekommst du einen \nneuen Planeten.");
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

