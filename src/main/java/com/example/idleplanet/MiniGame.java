package com.example.idleplanet;


import javafx.animation.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import java.io.IOException;

public class MiniGame {
    Pane pane;
    Rectangle player;
    Rectangle bot;
    Circle ball;
    AnimationTimer timer;
    String points;
    private final int WIDTH = 600;
    private final int HEIGHT = 400;
    private int speedX = 1;
    private int speedY = 1;
    private int sx = speedX;
    private int sy = speedY;

    public void setPoints(String points)
    {
        this.points = points;
    }

    public Parent createContent(){
        pane = new Pane();
        pane.setPrefSize(WIDTH, HEIGHT);
        pane.setStyle("-fx-background-color: black");

        bot = new Rectangle(10, 80, Color.WHITE);
        bot.setLayoutY(HEIGHT/2-40);
        bot.setLayoutX(0);

        player = new Rectangle(10, 80, Color.WHITE);
        player.setLayoutX(WIDTH-10);
        player.setLayoutY(HEIGHT/2-40);

        ball= new Circle(5, Color.WHITE);
        ball.setLayoutX(WIDTH/2);
        ball.setLayoutY(HEIGHT/2);

        pane.getChildren().addAll(bot, player, ball);

        timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                update();
            }
        };

        timer.start();

        return pane;
    }

    private void update() {
        double x = ball.getLayoutX();
        double y = ball.getLayoutY();

        pane.setOnKeyPressed(e ->{
            switch (e.getCode()) {
                case W:
                    player.setLayoutY(player.getLayoutY() - 30);
                    if (player.getLayoutY() <= 0) {
                        player.setLayoutY(10);
                    }

                    break;
                case S:
                    player.setLayoutY(player.getLayoutY() + 30);
                    if (player.getLayoutY() >= HEIGHT) {
                        player.setLayoutY(HEIGHT - 10);
                    }
                    break;
            }
        });
        pane.requestFocus();

        if (x <= 10 && y > bot.getLayoutY() && y < bot.getLayoutY()+80)
        {
            sx = speedX;
        }
        if (x >= WIDTH-12.5 && y > player.getLayoutY() && y < player.getLayoutY()+80) {
            speedX++;
            sx = -speedX;
        }
        if(y <= 0)
        {
            sy = speedY;
        }
        if(y >= HEIGHT-5){
            sy = -speedY;
        }

        ball.setLayoutX(ball.getLayoutX()+sx);
        ball.setLayoutY(ball.getLayoutY()+sy);

        if(x < WIDTH/2 && bot.getLayoutY() > y){
            bot.setLayoutY(bot.getLayoutY()-5);
        }
        if (x < WIDTH/2 && bot.getLayoutY()+80 < y){
            bot.setLayoutY(bot.getLayoutY()+5);
        }

        if(ball.getLayoutX() > WIDTH + 5 || ball.getLayoutX() < -5){
           timer.stop();
           Button exitButton = new Button();
           exitButton.setText("Exit Game");
            System.out.println(exitButton.getPrefWidth());
           exitButton.setLayoutX(WIDTH/2 - 30);
           exitButton.setLayoutY(HEIGHT/2);
           pane.getChildren().addAll(exitButton);
            exitButton.setOnAction(event -> {
                try {
                    exitGame(exitButton);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        }
    }


    public void exitGame(Button exitButton) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene scene = exitButton.getScene();
        root.translateYProperty().set(scene.getHeight());
        Pane parentContainer = (Pane) scene.getRoot();
        parentContainer.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(event1 ->{
            parentContainer.getChildren().remove(pane);
        });
        timeline.play();

    }



}
