package StoreGui;
import GUI.model.UiButtonInterface;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TANK {

    public void start(Stage Stage3) throws Exception{
    CheckBox Buttonname=new CheckBox("GRIZZLYTANK");
    CheckBox  Buttonname1=new CheckBox("TESLATANK");
    CheckBox  Buttonname2=new CheckBox("MIRAGETANK");
    CheckBox  Buttonname3=new CheckBox("TANGDESTROYER");
    CheckBox Buttonname4=new CheckBox("PRISMTANK");
    UiButtonInterface ADD= new UiButtonInterface("ADD TANK");
    UiButtonInterface BACK= new UiButtonInterface("BACK");

            Buttonname.setStyle(StoreGui.buttonFreeStyle);
            Buttonname.setStyle(StoreGui.buttonPressed);
            Buttonname1.setStyle(StoreGui.buttonFreeStyle);
            Buttonname1.setStyle(StoreGui.buttonPressed);
            Buttonname2.setStyle(StoreGui.buttonFreeStyle);
            Buttonname2.setStyle(StoreGui.buttonPressed);
            Buttonname3.setStyle(StoreGui.buttonFreeStyle);
            Buttonname3.setStyle(StoreGui.buttonPressed);
            Buttonname4.setStyle(StoreGui.buttonFreeStyle);
            Buttonname4.setStyle(StoreGui.buttonPressed);
//            ADD.setStyle(StoreGui.buttonFreeStyle);
//            ADD.setStyle(StoreGui.buttonPressed);
//            BACK.setStyle(StoreGui.buttonFreeStyle);
//            BACK.setStyle(StoreGui.buttonPressed);
            Image image=new Image("StoreGui/image/t.gif");
            ImageView imageView1=new ImageView(image);
            imageView1.setTranslateX(450);
            imageView1.setTranslateY(350);

            Buttonname.setTranslateX(200);
            Buttonname.setTranslateY(200);
            Buttonname1.setTranslateX(200);
            Buttonname1.setTranslateY(250);
            Buttonname2.setTranslateX(200);
            Buttonname2.setTranslateY(300);
            Buttonname3.setTranslateX(200);
            Buttonname3.setTranslateY(350);
            Buttonname4.setTranslateX(200);
            Buttonname4.setTranslateY(400);
            ADD.setTranslateX(200);
            ADD.setTranslateY(450);
            BACK.setTranslateX(200);
            BACK.setTranslateY(500);

            Buttonname.setPrefSize(190, 30);
            Buttonname1.setPrefSize(190, 30);
            Buttonname2.setPrefSize(190, 30);
            Buttonname3.setPrefSize(190, 30);
            Buttonname4.setPrefSize(190, 30);
            ADD.setPrefSize(190, 20);
            BACK.setPrefSize(190, 20);
            Label label = new Label();
            label.setText(String.valueOf(coins.coins));
            label.setFont(new Font("verdana",20));
            label.setTextFill(Color.YELLOW);
            label.setTranslateX(0);
            label.setTranslateY(-30);

            Buttonname.setFont(new Font("verdana",15));
            Buttonname1.setFont(new Font("verdana",15));
            Buttonname2.setFont(new Font("verdana",15));
            Buttonname3.setFont(new Font("verdana",15));
            Buttonname4.setFont(new Font("verdana",15));


            Buttonname.setTextFill(Color.BLACK);
            Buttonname1.setTextFill(Color.BLACK);
            Buttonname2.setTextFill(Color.BLACK);
            Buttonname3.setTextFill(Color.BLACK);
            Buttonname4.setTextFill(Color.BLACK);


            Tooltip tooltip=new Tooltip("armor=0.4\nattackFrequency=0.6\nmaxhealth=1000\nattackdamge=250\nattackrange=250\nsize=20\nspeed=300\nprice=50\npoint=3000\ncantarget:");
            Tooltip tooltip1=new Tooltip("ormor=0.5\nattackfrequency=0.6\nmaxhealth=1000\nattackdamge=400\nattackrange=150\nsize=20\nspeed=20\nprice=50\npoint=3000\ncontarget");
            Tooltip tooltip2=new Tooltip("ormor=0.5\nattackfrequency=0.6\nmaxhealth=1000\nattackdamge=400\nattackrange=150\nsize=20\nspeed=20\nprice=50\npoint=3000\ncontarget");
            Tooltip tooltip3=new Tooltip("ormor=0.35\nattackfrequency=0.6\nmaxhealth=1000\nattackdamge=300\nattackrange=150\nsize=20\nspeed=20\nprice=60\npoint=3000\ncontarget");
            Buttonname.setTooltip(tooltip);
            Buttonname1.setTooltip(tooltip1);
            Buttonname2.setTooltip(tooltip2);
            Buttonname3.setTooltip(tooltip3);



            GridPane gridPane=new GridPane();
            gridPane.getChildren().addAll(label,Buttonname,Buttonname1,Buttonname2,Buttonname3,Buttonname4,ADD,imageView1,BACK);
            Image image5= new Image("StoreGui/image/coin.jpg");
            ImageView imageView=new ImageView(image5);
            Pane pane = new Pane(imageView);
            imageView.fitHeightProperty().bind(pane.heightProperty());
            imageView.fitWidthProperty().bind(pane.widthProperty());
            pane.getChildren().add(gridPane);
            Scene scene2=new Scene(pane,800,600);
            Stage3.setScene(scene2);
            Stage3.show();
            Store s=new Store();
            TEAM team=new TEAM();
            BACK.setOnAction((Action)->{
                    try {
                          s.start(Stage3);
                    } catch (Exception exception) {
                            System.err.println("wrong");
                    }
            });
            ADD.setOnAction((Action)->{
                    if (coins.coins>=50&& Buttonname.isSelected())
                    {
                            coins.coins-=50;
                    }
                    if (coins.coins>=50&& Buttonname1.isSelected())
                    {
                            coins.coins-=50;
                    }
                    if (coins.coins>=50&& Buttonname2.isSelected())
                    {
                            coins.coins-=50;
                    }
                    if (coins.coins>=60&& Buttonname3.isSelected())
                    {
                            coins.coins-=60;
                    }
                    if (coins.coins>=60&& Buttonname4.isSelected())
                    {
                            coins.coins-=60;
                    }
            });
}}
