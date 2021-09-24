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

public class STRUCTURE {


    public void start(Stage Stage3) throws Exception{

        CheckBox Buttonname=new CheckBox("Pillbox");
        CheckBox  Buttonname1=new CheckBox("Prism Tower");
        CheckBox  Buttonname2=new CheckBox("Grand Cannon");
        CheckBox Buttonname3=new CheckBox("Patriot MissileSystem");

        UiButtonInterface ADD= new UiButtonInterface("ADD");
        UiButtonInterface BACK= new UiButtonInterface("BACK");
        Image image=new Image("StoreGui/image/st.gif");
        ImageView imageView1=new ImageView(image);
        imageView1.setTranslateX(475);
        imageView1.setTranslateY(275);

        Buttonname.setTranslateX(250);
        Buttonname.setTranslateY(150);
        Buttonname1.setTranslateX(250);
        Buttonname1.setTranslateY(200);
        Buttonname2.setTranslateX(250);
        Buttonname2.setTranslateY(250);
        Buttonname3.setTranslateX(250);
        Buttonname3.setTranslateY(300);
        ADD.setTranslateX(250);
        ADD.setTranslateY(350);
        BACK.setTranslateX(250);
        BACK.setTranslateY(400);

        Buttonname.setPrefSize(190, 20);
        Buttonname1.setPrefSize(190, 20);
        Buttonname2.setPrefSize(190, 20);
        Buttonname3.setPrefSize(190, 30);

        ADD.setPrefSize(190, 20);
        BACK.setPrefSize(190, 20);

        Buttonname.setStyle(StoreGui.buttonFreeStyle);
        Buttonname.setStyle(StoreGui.buttonPressed);
        Buttonname1.setStyle(StoreGui.buttonFreeStyle);
        Buttonname1.setStyle(StoreGui.buttonPressed);
        Buttonname2.setStyle(StoreGui.buttonFreeStyle);
        Buttonname2.setStyle(StoreGui.buttonPressed);
        Buttonname3.setStyle(StoreGui.buttonFreeStyle);
        Buttonname3.setStyle(StoreGui.buttonPressed);


        Buttonname.setFont(new Font("cambria",20));
        Buttonname1.setFont(new Font("cambria",20));
        Buttonname2.setFont(new Font("cambria",20));
        Buttonname3.setFont(new Font("cambria",16));


        Buttonname.setTextFill(Color.BLACK);
        Buttonname1.setTextFill(Color.BLACK);
        Buttonname2.setTextFill(Color.BLACK);
        Buttonname3.setTextFill(Color.BLACK);



        Tooltip tooltip=new Tooltip("armor=0.70\n attackFrequency=0.70\nmaxhealth=4000\n attackdamge=100\nattackrange=200\nsize=40\nspeed=0\nprice=150\npoint=3000\ncantarget:(soliders)");
        Tooltip tooltip1=new Tooltip("armor=0.70\nattackfrequency=0.50\nmaxhealth=4000\nattackdamge=100\nattackrange=200\nsize=30\nspeed=0\nprice=150\npoint=3000\ncantarget:(soliders and tank");
        Tooltip tooltip2=new Tooltip("armor=0.30\nattackfrequency=0.90\nmaxhealth=6500\nattackdamge=150\nattackrange=400\nsize=40\nspeed=0\nprice=200\npoint=3000\ncantarget:(solidersand tank");
        Tooltip tooltip4=new Tooltip("ormor=0.00\nattackfrequency=0.0\nmaxhealth=1000\nattackdamge=0\nattackrange=0\nsize=50\nspeed=0\nprice=175\npoint=3000\ncantarget----");
        Buttonname.setTooltip(tooltip);
        Buttonname1.setTooltip(tooltip1);
        Buttonname2.setTooltip(tooltip2);
        Label label = new Label();
        label.setText(String.valueOf(coins.coins));
        label.setFont(new Font("verdana",20));
        label.setTextFill(Color.YELLOW);
        label.setTranslateX(0);
        label.setTranslateY(-100);


        GridPane gridPane=new GridPane();
        gridPane.getChildren().addAll(label,Buttonname,Buttonname1,Buttonname2,Buttonname3,ADD,BACK,imageView1);
        Image image5= new Image("StoreGui/image/coin.jpg");
        ImageView imageView=new ImageView(image5);

        Pane pane = new Pane(imageView);
        imageView.fitHeightProperty().bind(pane.heightProperty());
        imageView.fitWidthProperty().bind(pane.widthProperty());
        pane.getChildren().add(gridPane);
        Scene scene2=new Scene(pane,800,600);
        Stage3.setScene(scene2);
        Stage3.show();
        TEAM team=new TEAM();
        Store s =new Store();
        BACK.setOnAction((Action)->
        {
            try {
                s.start(Stage3);
            } catch (Exception exception) {
                System.err.println("wrong");
            }
        });
        ADD.setOnAction((Action)->{
            if (coins.coins>=150&& Buttonname.isSelected())
            {
                coins.coins-=150;
            }
            if (coins.coins>=150&& Buttonname1.isSelected())
            {
                coins.coins-=150;
            }
            if (coins.coins>=200&& Buttonname2.isSelected())
            {
                coins.coins-=200;
            }
            if (coins.coins>=175&& Buttonname3.isSelected())
            {
                coins.coins-=175;
            }
        });

}}
