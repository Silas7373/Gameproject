package com.example.idleplanet;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class StartController {
    @FXML
    GridPane gridPane1;
    @FXML
    Button planet;
    @FXML
    public Label points;
    @FXML
    AnchorPane slider;
    @FXML
    Label upgradeMenu;
    @FXML
    AnchorPane basePane;
    @FXML
    StackPane myStackPane;
    @FXML
    VBox vbox;
    @FXML
    ImageView myimageView;
    @FXML
    ImageView planetImage;
    @FXML
    Button b1, b2, b3, b4, b5, b6, b7;
    @FXML
    VBox infoContainer;
    @FXML
    Label infoText;

    int index = 0;

    MiniGame game = new MiniGame();
    ArrayList<Image> imagelist = new ArrayList<Image>();
    Planet p = new Planet();
    MenuAnimation mAnimation = new MenuAnimation();
    private static final DecimalFormat df = new DecimalFormat("0");

    @FXML
    public void initialize() {
        mAnimation.openMenu(slider, gridPane1);
        mAnimation.closeInfo(infoContainer);
        p.autoMoney();
        Autoclick1();
    }

    public void startGame(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        game.setPoints(Double.parseDouble(points.getText()));
        stage.setScene(new Scene(game.createContent()));
        stage.show();
    }

    public void openMenu(){
        mAnimation.openMenu(slider, gridPane1);
    }
    public void buttonClicked(){
        p.planetClicked(planetImage);
    }
    public void buttonReleased(){
           p.planetReleased(planetImage);
    }


    public void menuPressed(){
        myimageView.setImage(new Image(getClass().getResourceAsStream("menu_icon_grey.png")));
    }

    public void menuReleased(){
        myimageView.setImage(new Image(getClass().getResourceAsStream("menu_icon.png")));
    }


    public void nextPlanet(){
        if(index+2 < imagelist.size()) {
            index = index + 2;
            planetImage.setImage(imagelist.get(index));
            planetImage.setFitHeight(128);
            planetImage.setFitWidth(149);

        }
    }

    public void btn1(){

        mAnimation.openInfo(1, infoText, infoContainer);
    }

    public void btn2(){

        mAnimation.openInfo(2, infoText, infoContainer);
    }

    public void btn3(){

        mAnimation.openInfo(3, infoText, infoContainer);
    }

    public void btn4(){
        mAnimation.openInfo(4, infoText, infoContainer);
    }
    public void btn5(){
        mAnimation.openInfo(5, infoText, infoContainer);
    }
    public void btn6(){
        mAnimation.openInfo(6, infoText, infoContainer);
    }
    public void btn7(){
        mAnimation.openInfo(7, infoText, infoContainer);
    }
    public void closeInfo(){
        mAnimation.closeInfo(infoContainer);
    }

    public void buyUpMoreCpC(){
        p.unlockUpgradeMoreCpC();
    }
    public void buyUpAstonautBase(){
        p.unlockUpAstonautBase();
    }
    public void buyUpMineralMine(){
        p.unlockUpMineralMine();
    }
    public void buyUpFactory(){
        p.unlockUpFactory();
    }
    public void buyUpLaboratory(){
        p.unlockUpLaboratory();
    }
    public void buyUpBank(){
        p.unlockUpBank();
    }
    public void buyUpTeleporter(){
        p.unlockUpTeleporter();
    }
    public void Autoclick1() {
        Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    update(p.getMoney());
                }
            },0,1);
    }
    public void update(double value) {
        Platform.runLater(() -> {
            points.setText(String.valueOf(df.format(value)));
        });
    }
    public void onClick(){
        p.click();
    }

    public void setMoney(double currency){p.setMoney(currency);}

}


