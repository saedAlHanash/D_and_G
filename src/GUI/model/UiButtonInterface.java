package GUI.model;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class UiButtonInterface extends Button {
    private final String fontPath = "src/GUI/model/resources/FORTE.TTF";
    private final String buttonPressed ="-fx-background-color: transparent; -fx-background-image: url('/GUI/model/resources/yellow_button02.png');";
    private final String buttonFreeStyle ="-fx-background-color: transparent; -fx-background-image: url('/GUI/model/resources/yellow_button01.png');";

    public UiButtonInterface(String text){
        setText(text);
        setButtonFont();
        setPrefHeight(45);
        setPrefWidth(190);
        setStyle(buttonFreeStyle);
        initializeButtonListneres();

    }
    private void setButtonFont(){
        try {
            setFont(Font.loadFont(new FileInputStream(fontPath),23));
        } catch (FileNotFoundException e) {
         setFont(Font.font("verdana", 20));
        }
    }
    public void clicksound() {
        String musicFile = "src/click1.mp3";

        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setVolume(200);
        mediaPlayer.play();
    }

    private void setButtonPressedStyle(){
        setStyle(buttonPressed);
        setPrefHeight(45);
        setLayoutY(getLayoutY() + 4);

    }
    private void setButtonReleasedStyle(){
        setStyle(buttonFreeStyle);
        setPrefHeight(45);
        setLayoutY(getLayoutY() - 4);

    }
    private void initializeButtonListneres(){
        setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                clicksound();
                if(event.getButton().equals(MouseButton.PRIMARY)){
                    setButtonPressedStyle();
                }


            }
        });

        setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton().equals(MouseButton.PRIMARY)){
                    setButtonReleasedStyle();
                    initializeButtonListneres();
                }
            }
        });

        setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setEffect(new DropShadow());

            }
        });
        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setEffect(null);

            }
        });



    }
}
