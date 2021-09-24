package StoreGui;

import GUI.model.UiButtonInterface;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Store {

    Text text=new Text("STORE");

    UiButtonInterface button= new UiButtonInterface("SOLDIER");
    UiButtonInterface button1= new UiButtonInterface("TANK");
    UiButtonInterface button2= new UiButtonInterface("PLANE");
    UiButtonInterface button3= new UiButtonInterface("STRUCTURE");
    UiButtonInterface button4= new UiButtonInterface("BACK");


    public void start(Stage stage){

        button.setPrefSize(190, 20);
        button1.setPrefSize(190, 20);
        button2.setPrefSize(190, 20);
        button3.setPrefSize(190, 20);
        button4.setPrefSize(190, 20);
        button.setTranslateX(300);
        button.setTranslateY(150);
        button1.setTranslateX(300);
        button1.setTranslateY(200);
        button2.setTranslateX(300);
        button2.setTranslateY(250);
        button3.setTranslateX(300);
        button3.setTranslateY(300);
        button4.setTranslateX(300);
        button4.setTranslateY(350);
        Label label = new Label();
        label.setText(String.valueOf(coins.coins));
        label.setFont(new Font("verdana",20));
        label.setTextFill(Color.YELLOW);
        label.setTranslateX(0);
        label.setTranslateY(-30);

        text.setTranslateX(250);
        text.setTranslateY(50);
        text.setFont(new Font("Cambria",100));
        text.setFill(Color.YELLOW);
        text.setStrokeWidth(1);
        text.setStroke(Color.BLACK);


        GridPane gridPane=new GridPane();
        gridPane.getChildren().addAll(label,button,button1,button2,button3,button4,text);
        Image image5= new Image("StoreGui/image/coin.jpg");
        ImageView imageView=new ImageView(image5);
        Pane pane = new Pane(imageView);
        imageView.fitHeightProperty().bind(pane.heightProperty());
        imageView.fitWidthProperty().bind(pane.widthProperty());
        pane.getChildren().add(gridPane);
        Scene scene=new Scene(pane,800,600);
        stage.setTitle("game");
        stage.setScene(scene);
        stage.show();

        StoreGui main=new StoreGui();
        SOLDIER soldier=new SOLDIER();
        TANK tank=new TANK();
        PLANE plane=new PLANE();
        STRUCTURE structure=new STRUCTURE();



        button.setOnAction((Action)->{



            try {
                soldier.start(stage);
            } catch (Exception exception) {
                System.err.println("wrong");
            }
        });
        button1.setOnAction((Action)->{
            try {
                tank.start(stage);
            } catch (Exception exception) {
                System.err.println("wrong");
            }
        });
        button2.setOnAction((Action)->{
            try {
                plane.start(stage);
            } catch (Exception exception) {
                System.err.println("wrong");
            }
        });
        button3.setOnAction((Action)->{
            try {
                structure.start(stage);
            } catch (Exception exception) {
                System.err.println("wrong");
            }
        });
        button4.setOnAction((Action)->{
           /**/

            try {
                main.start(stage);
            } catch (Exception exception) {
                System.err.println("wrong");
            }
        });

    }
}
