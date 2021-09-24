package GUI.model;

import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.*;
import javafx.util.Duration;

public class DestroyOrDefendSubScene extends SubScene {
      private final static String fontPath = "GUI/model/resources/kenvector_future.ttf";
      private final static String backgroundImage = "GUI/model/resources/yellow_panel.png";
        private boolean isHidden;

    public DestroyOrDefendSubScene() {
        super(new AnchorPane(), 400, 400);
        prefHeight(400);
        prefWidth(400);

        BackgroundImage image = new BackgroundImage(new Image(backgroundImage,400,400,false,true)
                ,BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT,BackgroundPosition.DEFAULT,null);
        AnchorPane root2 = (AnchorPane)this.getRoot();
        root2.setBackground(new Background(image));
        setLayoutX(1400);
        setLayoutY(125);
        isHidden = true;
    }
    public void moveSubscene(){
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.seconds(0.3));
        translateTransition.setNode(this);

        if (isHidden) {
            translateTransition.setToX(-1000);
            isHidden = false;
        }else{
            translateTransition.setToX(0);
            isHidden = true;
        }

        translateTransition.play();
    }
public AnchorPane getpane(){
     return (AnchorPane)this.getRoot();
}
}
