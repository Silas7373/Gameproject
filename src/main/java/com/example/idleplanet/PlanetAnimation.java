package com.example.idleplanet;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class PlanetAnimation extends Animation{


    ArrayList<Image> imagelist = new ArrayList<Image>();
    int index = 0;
    Image planet1 = new Image(getClass().getResourceAsStream("planet.png"));
    Image planet1_grey = new Image(getClass().getResourceAsStream("planet_grey.png"));
    Image planet2 = new Image(getClass().getResourceAsStream("planet2.png"));
    Image planet2_grey = new Image(getClass().getResourceAsStream("planet2_grey.png"));

    PlanetAnimation(){
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

    public void planetReleased(ImageView planetImage){
        planetImage.setImage(imagelist.get(index));
        planetImage.setFitHeight(128);
        planetImage.setFitWidth(149);
    }
}
