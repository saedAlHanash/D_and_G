package GUI.model;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class InfoLabel extends Label {
    public final static String Font_path = "/GUI/model/resources/kenvector_future.ttf";

    public InfoLabel(String text) {
        setPrefWidth(600);
        setPrefHeight(400);
        setPadding(new Insets(40,40,40,40));
        setText(text);
        setWrapText(true);
        setLabelFont();

    }
    private void setLabelFont(){
        try {
            setFont(Font.loadFont(new FileInputStream(new File(Font_path)),23));
        } catch (FileNotFoundException e) {
            setFont(Font.font("verdana",23));
        }

    }
}
