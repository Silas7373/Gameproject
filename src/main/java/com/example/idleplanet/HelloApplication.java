package com.example.idleplanet;
import java.util.Timer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.TimerTask;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view2.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("PlanetClicker!");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("planet.png")));
        stage.setScene(scene);
        stage.show();

}

    public static void main(String[] args) {
        launch();
    }

}