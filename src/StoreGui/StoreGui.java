package StoreGui;

import GUI.Controller;
import GUI.model.UiButtonInterface;
import GUI.view.GameViewManager;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.geometry.Insets;
import javafx.stage.StageStyle;
import java.awt.*;
import java.io.FileInputStream;
import java.security.PublicKey;
import java.util.Random;


public class StoreGui extends Application {


    TEAM t;

    Text text1=new Text("attacker team");
    Text text2=new Text("defender team");

    static String buttonFreeStyle = "-fx-background-color: transparent; -fx-background-image: url('/GUI/model/resources/yellow_button01.png');";
    static String buttonPressed = "-fx-background-color: transparent; -fx-background-image: url('/GUI/model/resources/yellow_button02.png');";

    static  TextArea label3=new TextArea();
    static TextArea label4=new TextArea();
    static int check;


    static UiButtonInterface button=new UiButtonInterface("ADD");
   static   UiButtonInterface button1= new UiButtonInterface("ADD");
    static   UiButtonInterface button2= new UiButtonInterface("START");




    @Override

        public void start(Stage Stage4) throws Exception {

        text1.setTranslateX(110);
        text1.setTranslateY(50);
        text1.setFont(new Font("Cambria",40));
        text1.setFill(Color.WHITE);
        text1.setStrokeWidth(1);
        text1.setStroke(Color.BLACK);

        text2.setTranslateX(450);
        text2.setTranslateY(50);
        text2.setFont(new Font("Cambria",40));
        text2.setFill(Color.WHITE);
        text2.setStrokeWidth(1);
        text2.setStroke(Color.BLACK);

        button.setTranslateX(150);
        button.setTranslateY(400);
        button1.setTranslateX(450);
        button1.setTranslateY(400);
        button2.setTranslateX(300);
        button2.setTranslateY(500);

        button.setPrefSize(190,20);
        button1.setPrefSize(190,20);
        button2.setPrefSize(190,30);





        button.setTextFill(Color.BLACK);
        button1.setTextFill(Color.BLACK);
        button2.setTextFill(Color.BLACK);
        label3.setTranslateX(140);
        label3.setTranslateY(70);
        label3.setPrefSize(200,300);
        label3.setFont(new Font("cambria",20));


        label4.setTranslateX(450);
        label4.setTranslateY(70);
        label4.setPrefSize(200,300);
        label4.setFont(new Font("cambria",20));

        label3.setStyle("-fx-opacity: 0.1");
        label4.setStyle("-fx-opacity: 0.1");





        Image image5= new Image("StoreGui/image/coin.jpg");
            ImageView imageView1=new ImageView(image5);

            Pane pane = new Pane(imageView1);
            imageView1.fitHeightProperty().bind(pane.heightProperty());
            imageView1.fitWidthProperty().bind(pane.widthProperty());
            pane.getChildren().addAll(text1,text2,button,button1,button2,label3,label4);
            Scene scene = new Scene(pane, 800, 600);
            Stage4.setTitle("NEW GAME");
            Stage4.setScene(scene);
            Stage4.show();

            TEAM team=new TEAM();
            //ADD THE FIRST TEAM
            button.setOnAction((ActionEvent e)->{
                try {
                    team.start(Stage4);
                    check=1;
                } catch (Exception exception) {
                    System.err.println("wrong");
                }
            });
        //ADD THE SECOND TEAM
        button1.setOnAction((ActionEvent e)->{
            try {
                team.start(Stage4);
                check=2;
            } catch (Exception exception) {
                System.err.println("wrong");
            }
        });
        button2.setOnAction(e ->{
            GameViewManager gameViewManager = new GameViewManager();
            Controller ctrl = new Controller(new Game.Main(),gameViewManager);
            gameViewManager.createNewGame(Stage4);
            ctrl.start();
        });
            }

        }














