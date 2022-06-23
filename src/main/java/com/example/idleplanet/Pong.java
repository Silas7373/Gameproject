package com.example.idleplanet;
import javafx.animation.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;
import java.io.IOException;
public class Pong {
    Pane pane;
    Rectangle player;
    Rectangle bot;
    Circle ball;
    AnimationTimer timer;
    Double points;
    Double bet = 0.0;
    String buttonStyle =
            "-fx-background-color:  #1e1e1e;" +
            "-fx-text-fill: #999999;" +
            "-fx-background-radius: 5px 5px 5px 5px;"+
            "-fx-border-radius: 5px 5px 5px 5px;" ;


    Button exitButton = new Button();
    private final int WIDTH = 600;
    private final int HEIGHT = 400;
    private int speedX = 1;
    private int speedY = 1;
    private int sx = speedX;
    private int sy = speedY;

    public void setPoints(Double points)
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

        Label l = new Label();
        l.setText("Geben Sie einen Betrag ein:");
        l.setLayoutX(WIDTH/2 - 135);
        l.setLayoutY(HEIGHT/2 - 50);
        l.setFont(Font.font("Monospaced", FontWeight.BOLD , 16));
        l.setStyle("-fx-text-fill: white;");

        TextField text = new TextField();
        text.setStyle("-fx-text-fill: white;" + "-fx-background-color: #2e2d2d;");
        text.setFont(Font.font("Monospaced"));
        text.setLayoutX(WIDTH/2 - 60);
        text.setLayoutY(HEIGHT/2 - 20);
        pane.getChildren().addAll(l, text);

                text.setOnAction(event -> {
                    bet = Double.parseDouble(text.getText());

                    if (bet > 0 && bet <= points) {

                        pane.getChildren().removeAll(text, l);
                        pane.getChildren().addAll(bot, player, ball);


                        timer = new AnimationTimer() {
                            @Override
                            public void handle(long l) {
                                update();
                            }
                        };
                        timer.start();
                    }
                });

        return pane;
    }

    private void update() {
        double x = ball.getLayoutX();
        double y = ball.getLayoutY();
            pane.setOnKeyPressed(e -> {
                switch (e.getCode()) {
                    case W:
                        player.setLayoutY(player.getLayoutY() - 30);
                        if (player.getLayoutY() <= -10) {
                            player.setLayoutY(-10);
                        }

                        break;
                    case S:
                        player.setLayoutY(player.getLayoutY() + 30);
                        if (player.getLayoutY() >= 300) {
                            player.setLayoutY(HEIGHT - 80);
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
            bot.setLayoutY(bot.getLayoutY()-3);
        }
        if (x < WIDTH/2 && bot.getLayoutY()+80 < y){
            bot.setLayoutY(bot.getLayoutY()+3);
        }

        if (ball.getLayoutX() > WIDTH + 5)
        {
            Label l = new Label();
            l.setText("You Lost!");
            l.setLayoutX(WIDTH/2 - 67);
            l.setLayoutY(HEIGHT/2 - 50);
            l.setFont(Font.font("Monospaced" ,FontWeight.BOLD, 25));
            l.setStyle("-fx-text-fill: white;");
            pane.getChildren().add(l);
            points = points - bet;
        }

        if (ball.getLayoutX() < -5)
        {
            Label l = new Label();
            l.setText("You Won!");
            l.setLayoutX(WIDTH/2 - 60);
            l.setLayoutY(HEIGHT/2 - 50);
            l.setFont(Font.font("Monospaced" ,FontWeight.BOLD, 25));
            l.setStyle("-fx-text-fill: white;");
            pane.getChildren().add(l);
            points = points + bet;
        }

        if(ball.getLayoutX() > WIDTH + 5 || ball.getLayoutX() < -5){
           timer.stop();
           exitButton.setStyle(buttonStyle);
           exitButton.setMinWidth(80);
           exitButton.setMaxWidth(80);
           exitButton.setText("Exit Game");
           exitButton.setLayoutX(WIDTH/2 - exitButton.getMinWidth()/2);
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root = loader.load();
        StartController controller = loader.getController();
        controller.fileHandling.loadFromFile(controller.p,false);
        controller.setMoney(points);
        controller.Autoclick1();
        controller.startAutomoney();

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
