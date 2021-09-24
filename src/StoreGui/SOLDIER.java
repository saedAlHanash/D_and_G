package StoreGui;

import GUI.model.UiButtonInterface;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.CheckBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class SOLDIER {
    CheckBox Buttonname=new CheckBox("SNIPER");
    CheckBox Buttonname1 = new CheckBox("INFANTRY");
    CheckBox Buttonname2 = new CheckBox("NAVY SEAL");


    public void start(Stage Stage3) throws Exception {

        UiButtonInterface ADD = new UiButtonInterface("add soldier");
        UiButtonInterface BACK = new UiButtonInterface("BACK");

        Image image=new Image("StoreGui/image/s.gif");
        ImageView imageView1=new ImageView(image);
        imageView1.setTranslateX(450);
        imageView1.setTranslateY(200);
        Buttonname.setStyle(StoreGui.buttonFreeStyle);
        Buttonname.setStyle(StoreGui.buttonPressed);
        Buttonname1.setStyle(StoreGui.buttonFreeStyle);
        Buttonname1.setStyle(StoreGui.buttonPressed);
        Buttonname2.setStyle(StoreGui.buttonFreeStyle);
        Buttonname2.setStyle(StoreGui.buttonPressed);

        Buttonname.setTranslateX(200);
        Buttonname.setTranslateY(100);
        Buttonname1.setTranslateX(200);
        Buttonname1.setTranslateY(150);
        Buttonname2.setTranslateY(200);
        Buttonname2.setTranslateX(200);


        ADD.setTranslateX(200);
        ADD.setTranslateY(250);
        BACK.setTranslateX(200);
        BACK.setTranslateY(300);

        ADD.setPrefSize(190, 20);
        BACK.setPrefSize(190, 20);
        Buttonname.setPrefSize(190, 20);
        Buttonname1.setPrefSize(190, 20);
        Buttonname2.setPrefSize(190, 20);


        Label label = new Label();
        label.setText(String.valueOf(coins.coins));
        label.setFont(new Font("verdana",20));
        label.setTextFill(Color.YELLOW);
        label.setTranslateX(0);
        label.setTranslateY(-140);


        Buttonname.setFont(new Font("verdana", 20));
        Buttonname1.setFont(new Font("verdana", 20));
        Buttonname2.setFont(new Font("verdana", 20));


        Buttonname.setTextFill(Color.BLACK);
        Buttonname1.setTextFill(Color.BLACK);
        Buttonname2.setTextFill(Color.BLACK);


        GridPane gridPane = new GridPane();
        Tooltip tooltip=new Tooltip("armor=0.10\n attackFrequency=0.4\n maxhealth=250\n attackdamge=75\n attackrange=700\n size=3\n speed=10\n price=5\n point=3000\n cantarget:(soliders)");
        Tooltip tooltip1=new Tooltip("armor=0.20\n attackfrequency=1.5\n maxhealth=250\n attackdamge=50\n attackrange=50\nsize=3\nspeed=10\nprice=3\npoint=3000\n cantarget:soldiers ");
        Tooltip tooltip2=new Tooltip("armor=0.20\nattackfrequency=1.5\nmaxhealth=250\nattackdamge=50\nattackrange=50\nsize=3\nspeed=10\nprice=3\npoint=3000\ncantarget:soldiers and tank");

        Buttonname.setTooltip(tooltip);
        Buttonname1.setTooltip(tooltip1);
        Buttonname2.setTooltip(tooltip1);
        tooltip.setTextAlignment(TextAlignment.LEFT);
        tooltip1.setTextAlignment(TextAlignment.LEFT);
        tooltip2.setTextAlignment(TextAlignment.LEFT);

        gridPane.getChildren().addAll(label,Buttonname, Buttonname1, Buttonname2, ADD,BACK,imageView1);
        Image image5 = new Image("StoreGui/image/coin.jpg");
        ImageView imageView = new ImageView(image5);
        Pane pane = new Pane(imageView);
        imageView.fitHeightProperty().bind(pane.heightProperty());
        imageView.fitWidthProperty().bind(pane.widthProperty());
        pane.getChildren().add(gridPane);
        Scene scene2 = new Scene(pane, 800, 600);
        Stage3.setScene(scene2);
        Stage3.show();
        TEAM team=new TEAM();
        Store s=new Store();
        SOLDIER soldier=new SOLDIER();
        BACK.setOnAction((Action)->{
            try {
                s.start(Stage3);

            } catch (Exception exception) {
                System.err.println("wrong");
            }
        });
        ADD.setOnAction((Action)->{
            if (coins.coins>=5&& Buttonname.isSelected())
            {
              coins.coins-=5;
            }
            if (coins.coins>=3&& Buttonname1.isSelected())
            {
                coins.coins-=3;
            }
            if (coins.coins>=3&& Buttonname2.isSelected())
            {
                coins.coins-=3;
            }



        });



    }}

