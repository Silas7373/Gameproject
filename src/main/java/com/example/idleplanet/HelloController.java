package com.example.idleplanet;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.io.IOException;
public class HelloController{

    @FXML
    ImageView mainFont;
    @FXML
    GridPane startContainer;


 /*   Rectangle2D primaryScreenBounds = Screen.getPrimary().getBounds();
    double width = primaryScreenBounds.getWidth();
    double height = primaryScreenBounds.getHeight();
*/
    @FXML
    public void initialize() {

    }


    public void startGame(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}