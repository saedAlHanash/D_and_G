package GUI.view;
import GUI.Controller;
import GUI.Main;
import StoreGui.*;
import GUI.model.InfoLabel;
import animatefx.animation.FadeIn;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import GUI.model.UiButtonInterface;
import GUI.model.DestroyOrDefendSubScene;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ViewManager  {
    private AnchorPane mainPain;
    private Scene mainScene;
    private Stage mainStage;
    private Stage menuStage;

    private final int menu_buttons_startX =100;
    private final int menu_buttons_startY =150;
    private List<UiButtonInterface> menuButtons;

    private DestroyOrDefendSubScene creditSubscene;
    private DestroyOrDefendSubScene scoreSubscene;
    private DestroyOrDefendSubScene helpSubscene;
    private DestroyOrDefendSubScene sceneToHide;
    protected String musicFile = "src/music.mp3";
    protected Media sound = new Media(new File(musicFile).toURI().toString());
    protected MediaPlayer mediaPlayer = new MediaPlayer(sound);

    public ViewManager() {
        mainPain = new AnchorPane();
        menuButtons = new ArrayList<>();
        mainScene = new Scene(mainPain,800,600);
        mainStage = new Stage();
        mainStage.setScene(mainScene);
//        mainStage.setFullScreen(true);
        createBackground();
        createButtons();
        createSubscene();
        createLogo();
        animation();
        createCreditSubscene();
        createHelpSubscene();
        mediaPlayer.setVolume(0.2);
        mediaPlayer.play();


    }
    private void animation(){
        new FadeIn(mainPain).play();
    }

    private void showSubscene(DestroyOrDefendSubScene subScene){
        if (sceneToHide != null){
            sceneToHide.moveSubscene();
        }

        subScene.moveSubscene();
        sceneToHide = subScene;
    }
    private void createSubscene(){
        creditSubscene = new DestroyOrDefendSubScene();
        mainPain.getChildren().add(creditSubscene);

        scoreSubscene = new DestroyOrDefendSubScene();
        mainPain.getChildren().add(scoreSubscene);

        helpSubscene = new DestroyOrDefendSubScene();
        mainPain.getChildren().add(helpSubscene);


    }

    public Stage getMainStage() {
        return mainStage;
    }
    private void createButtons(){
        createStartButton();
        createHelpButton();
        creatScoresButton();
        createCreditbutton();
        createExitButton();
    }
    public void createNewGame(Stage menuStage) {
        this.menuStage = menuStage;
        this.menuStage.hide();
        mainStage.show();
    }


        private void createStartButton(){
        UiButtonInterface button = new UiButtonInterface("Play");
        addMenuButton(button);
         button.setOnAction(new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent event) {
              StoreGui storeGui = new StoreGui();
//              GameViewManager gameViewManager = new GameViewManager();
              try {

                  storeGui.start(mainStage);
              } catch (Exception exception) {
                  System.err.println("wrong");
              }
//              gameViewManager.createNewGame(mainStage);

//              Controller ctrl = new Controller(new Game.Main(),gameViewManager);
              mediaPlayer.stop();
//              ctrl.start();
          }
      });


    }
    private void creatScoresButton(){
        UiButtonInterface button = new UiButtonInterface("Scores");
        addMenuButton(button);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showSubscene(scoreSubscene);


            }
        });
    }
    private void createHelpButton(){
        UiButtonInterface button = new UiButtonInterface("help");
        addMenuButton(button);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {

                showSubscene(helpSubscene);
            }
        });
    }
    private void createCreditbutton(){
        UiButtonInterface button = new UiButtonInterface("credit");
        addMenuButton(button);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                showSubscene(creditSubscene);
            }
        });
    }
    private void createExitButton(){
        UiButtonInterface button = new UiButtonInterface("Exit");
        addMenuButton(button);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                mainStage.close();

            }
        });
    }
    private void addMenuButton(UiButtonInterface button){
        button.setLayoutX(menu_buttons_startX);
        button.setLayoutY(menu_buttons_startY + menuButtons.size()*75);
        menuButtons.add(button);
        mainPain.getChildren().add(button);

    }
    private void createHelpSubscene(){
        helpSubscene = new DestroyOrDefendSubScene();
        mainPain.getChildren().add(helpSubscene);
        InfoLabel label = new InfoLabel("It's a game of two teams an attacking and defencing team\n" +
                "each player choose to be an attacker or defence \n" +
                "the job of the attacker is to attack the base of the defence player" +
                "\nand destroy it. \n" +
                "and the job of the defence is defend his base \n" +
                "each player has certian amount of points to buy army units and towers");
        label.setFont(new Font("Arial", 12));
        label.setLayoutX(-20);
        helpSubscene.getpane().getChildren().add(label);
    }
    private void createCreditSubscene(){
        creditSubscene = new DestroyOrDefendSubScene();
        mainPain.getChildren().add(creditSubscene);
        InfoLabel label = new InfoLabel("Created by : \nFeras Alsaedi\nJihad alkadi\nYara Ramadan\nSaeed alhanash\nShahed ghanem");
        label.setFont(new Font("Arial", 30));
        creditSubscene.getpane().getChildren().add(label);
    }

    private void createBackground(){
        Image backgroundImage = new Image("background.jpg",800,600,false,true);
        BackgroundImage background = new BackgroundImage(backgroundImage,BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT,BackgroundPosition.DEFAULT,null);
//        mainPain.setBackground(new Background(background));
        mainPain.setStyle("-fx-background-image: url('/background.jpg');" +
                "-fx-background-size: cover;" +
                "-fx-background-repeat: no-repeat;" +
                "-fx-background-position: center;");


    }
    private void createLogo(){
        ImageView logo = new ImageView("logo.png");
        logo.setLayoutX(550);
        logo.setLayoutY(-20);
        logo.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                logo.setEffect(new DropShadow());

            }
        });
        logo.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                logo.setEffect(null);
            }
        });
        mainPain.getChildren().add(logo);



    }

}
