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

public class PLANE {

    public void start(Stage Stage3) throws Exception{
        CheckBox  Buttonname=new CheckBox("BLACK EAGLE");
        UiButtonInterface ADD= new UiButtonInterface("ADD PLANE");
        UiButtonInterface BACK= new UiButtonInterface("BACK");

        Image image=new Image("StoreGui/image/ppl.gif");
        ImageView imageView1=new ImageView(image);
        imageView1.setTranslateX(300);
        imageView1.setTranslateY(200);

        Buttonname.setStyle(StoreGui.buttonFreeStyle);
        Buttonname.setStyle(StoreGui.buttonPressed);
        Label label = new Label();
        label.setText(String.valueOf(coins.coins));
        label.setFont(new Font("verdana",20));
        label.setTextFill(Color.YELLOW);
        label.setTranslateX(0);
        label.setTranslateY(-20);


        Buttonname.setTranslateX(300);
        Buttonname.setTranslateY(350);
        ADD.setTranslateX(300);
        ADD.setTranslateY(400);
        BACK.setTranslateX(300);
        BACK.setTranslateY(450);

        Buttonname.setFont(new Font("cambria",20));


        Buttonname.setPrefSize(190, 20);
        ADD.setPrefSize(190, 20);
        BACK.setPrefSize(190, 20);

        Buttonname.setTextFill(Color.BLACK);



        Tooltip tooltip=new Tooltip("armor=0.0\n attackFrequency=..\n maxhealth=1500\n attackdamge=0\n attackrange=0\n size=3\n speed=100\n price=75\n point=3000\n cantarget: main base");
        Buttonname.setTooltip(tooltip);

        GridPane gridPane=new GridPane();
        gridPane.getChildren().add(label);
        gridPane.getChildren().add(Buttonname);
        gridPane.getChildren().add(ADD);
        gridPane.getChildren().add(BACK);
        gridPane.getChildren().add(imageView1);



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
        Store stor=new Store();
        BACK.setOnAction((Action)->{
            try {
                stor.start(Stage3);
            } catch (Exception exception) {
                System.err.println("wrong");
            }
        });
        ADD.setOnAction((Action)->{
            if (coins.coins>=75&& Buttonname.isSelected())
            {
                coins.coins-=75;
            }
        });

    }
}
