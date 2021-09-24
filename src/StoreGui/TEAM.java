package StoreGui;
import GUI.model.UiButtonInterface;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.Scene;

import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;



public class TEAM {

    Label label=new Label(" Name");
    Label label1=new Label("position x");
    Label label2=new Label("Position y");

   static TextField textField=new TextField();
   static TextField textField1=new TextField();
   static TextField textField2=new TextField();
   static UiButtonInterface NEXT= new UiButtonInterface("NEXT");



   static  String s1;
   static  String s2;
    public void start(Stage primaryStage) throws Exception{
//        NEXT.setStyle(StoreGui.buttonFreeStyle);
//        NEXT.setStyle(StoreGui.buttonPressed);


        NEXT.setPrefSize(190, 20);



        label2.setTextFill(Color.WHITE );
        label1.setTextFill(Color.WHITE );
        label.setTextFill(Color.WHITE );


        label.setFont(new Font("verdana",20));
        label1.setFont(new Font("verdana",20));
        label2.setFont(new Font("verdana",20));

        label.setTranslateX(200);
        label.setTranslateY(200);
        label1.setTranslateX(150);
        label1.setTranslateY(250);
        label2.setTranslateX(150);
        label2.setTranslateY(300);
        textField.setTranslateX(300);
        textField.setTranslateY(200);
        textField1.setTranslateX(300);
        textField1.setTranslateY(250);
        textField2.setTranslateX(300);
        textField2.setTranslateY(300);
        NEXT.setTranslateX(300);
        NEXT.setTranslateY(400);


        GridPane gridPane=new GridPane();
        gridPane.getChildren().addAll(label,label1,label2,textField,textField1,textField2,NEXT);
        Image image5= new Image("StoreGui/image/coin.jpg");
        ImageView imageView=new ImageView(image5);
        Pane pane = new Pane(imageView);
        imageView.fitHeightProperty().bind(pane.heightProperty());
        imageView.fitWidthProperty().bind(pane.widthProperty());
        pane.getChildren().add(gridPane);
        Scene scene=new Scene(pane,800,600);
        primaryStage.setTitle("game");
        primaryStage.setScene(scene);
        primaryStage.show();
        Store s=new Store();
        // الزر التالي
        NEXT.setOnAction((Action)->{
            if (StoreGui.check==1){
                s1+="\n"+textField.getText();
                StoreGui.label3.setText(s1);}
            else if (StoreGui.check==2)
            {
                s2+="\n"+textField.getText();
                StoreGui.label4.setText(s2);}
          /*  if (textField2.getText().isEmpty()||textField1.getText().isEmpty()||textField.getText().isEmpty()){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("pleas enter the properties");
                alert.showAndWait();*/

            try {

                s.start(primaryStage);
            } catch (Exception exception) {
                System.err.println("wrong");
            }

        });

       /* textField.setEventDispatcher((event, tail) -> {
            if (StoreGui.check==1){
                s1+="\n"+textField.getText();
                StoreGui.label3.setText(s1);}
            else if (StoreGui.check==2)
            {
                s2+="\n"+textField.getText();
                StoreGui.label4.setText(s2);}

            return event;
        });*/

}}



