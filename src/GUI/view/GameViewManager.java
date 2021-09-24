package GUI.view;

import Game.*;
import Game.AllUnites.*;
import animatefx.animation.*;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Pair;

import javax.swing.text.FlowView;
import javax.swing.text.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CancellationException;


public class GameViewManager {
    protected Main game;
    private Stage menuStage;
    private ScrollPane scrollPane;
    public Scene gameScene;
    public AnchorPane root;
    private Stage gameStage;
    private static final int MIN_PIXELS = 10;


    double scaleValue = 0.7;
    double zoomIntensity = 0.02;
    Node target;
    Node zoomNode;

    //    private final static String TANK_IMAGE = "tank.png";
    private final static String River_Image = "oposite pictures\\Bridg.png";
    private final static String bridg_Image = "Bridg.png";
    private final static String MirageTAnk_Image = "tank.png";
    private final static String MirageTAnk_Image_Def = "/oposite pictures/Miragetankdef.png";
    private final static String Infanry_IMAGE = "soldier1.png";
    private final static String Infanry_IMAGE_Def = "/oposite pictures/soldierde.png";
    private final static String Sniper_IMAGE = "/oposite pictures/Sniper.png";
    private final static String Sniper_IMAGE_Def = "/oposite pictures/SniperDef.png";
    private final static String NavySeal_IMAGE = "/oposite pictures/NavySeal.png";
    private final static String NavySeal_IMAGE_Def = "/oposite pictures/NavySealDef.png";
    private final static String GrizlyTank_IMAGE = "/oposite pictures/GrizlyTank.png";
    private final static String GrizlyTank_IMAGE_Def = "/oposite pictures/GrizlyTankDef.png";
    private final static String TeslaTank_IMAGE = "/oposite pictures/TeslaTank.png.png";
    private final static String TeslaTank_IMAGE_Def = "/oposite pictures/TeslaTankDef.png";
    private final static String PrismTank_IMAGE = "/oposite pictures/PrismTank.png";
    private final static String PrismTank_IMAGE_Def = "/oposite pictures/PrismTankDef.png";
    private final static String TankDestroyer_IMAGE = "/oposite pictures/TankDestroyer.png";
    private final static String TankDestroyer_IMAGE_Def = "/oposite pictures/TankDestroyerDef.png";
    private final static String Plane_IMAGE = "/oposite pictures/Plane.png";
    private final static String Plane_IMAGE_Def = "/oposite pictures/PlaneDef.png";
    private final static String Patriotmissile_IMAGE = "/oposite pictures/PatriotMissileSystem.png";
    private final static String Patriotmissile_IMAGE_Def = "/oposite pictures/PatriotMissileSystemDef.png";
    private final static String PrismTower_IMAGE = "/oposite pictures/PrismTower.png";
    private final static String PrismTower_IMAGE_Def = "/oposite pictures/PrismTowerDef.png";
    private final static String GrandCannon_IMAGE = "/oposite pictures/GrandCannon.png";
    private final static String GrandCannon_IMAGE_Def = "/oposite pictures/GrandCannonDef.png";
    private final static String Pillbox_IMAGE = "/oposite pictures/Pillbox.png";
    private final static String Pillbox_IMAGE_Def = "/oposite pictures/PillboxDef.png";
    private final static String UFOBLUE_IMAGE = "ufoBlue.png";
    private final static String MainBase_Image = "castle_grey.png";
    private Label titleLabel;
    private Label timelabel;
    private Label mainBais;


    public GameViewManager() {
        initializeStage();

        animation();
        createBackground();
//        zoom();
//        ArrayList<ArrayList<Unite>> list = game.init();
//        showUnits(list);
//        zoom2();
//        zoom3();
//            showunits();
//            createButtons();

        zoom();
//            zoom4();


    }

    private void createtime() {

        StackPane left = new StackPane();
        Label label = new Label("hhjhhhhh");
        left.getChildren().add(label);
        Scene scene = new Scene(left, 100, 100);


    }

    private void animation() {
        new FadeIn(root).play();
    }


    private void initializeStage() {
        root = new AnchorPane();
//        gameScene = new Scene(scrollPane, 800, 600);
        gameStage = new Stage();
        gameStage.setScene(gameScene);
        game = new Main();
//        showUnits(list);


    }



    public void createNewGame(Stage menuStage) {
        this.menuStage = menuStage;
        this.menuStage.hide();
        gameStage.show();
        createBackground();
        createtime();
    }


    private void createBackground() {
        Image backgroundImage = new Image("element2.png");
        ImageView imageView = new ImageView(backgroundImage);
        BackgroundImage background = new BackgroundImage(backgroundImage,
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO,
                        true, true, true, true));
        root.setBackground(new Background(background));
    }

    public void showUnits(ArrayList<ArrayList<Unite>> list) {

//        ViewManager viewManager = new ViewManager();
//            viewManager.createNewGame(gameStage);
        synchronized (list) {
            root.getChildren().clear();
            String imageURL = "";
            ImageView view = null;
            Image img;
            Rectangle r = new Rectangle();
            Rectangle[] r1 = new Rectangle[50];
            Group rr = new Group();
            for (int i = 0; i <Grid.valleyList.size() ; i++) {
                r.setX(Grid.valleyList.get(i).x);
                r.setY(Grid.valleyList.get(i).y);
                r.setWidth(Grid.valleyList.get(i).sizX);
                r.setHeight(Grid.valleyList.get(i).sizY);
                if(Grid.valleyList.get(i).type=="River"){
                    r.setFill(Paint.valueOf("Blue"));
                }else {
                    r.setFill(Paint.valueOf("Black"));
                }
                root.getChildren().add(r);
                for (int j = 0; j <Grid.valleyList.get(i).listBridge.size() ; j++) {
                    r1[j]=new Rectangle();
                    r1[j].setX(Grid.valleyList.get(i).listBridge.get(j).xBridge);
                    r1[j].setY(Grid.valleyList.get(i).listBridge.get(j).yBridge);
                    r1[j].setWidth(Grid.valleyList.get(i).listBridge.get(j).sizBridgeX);
                    r1[j].setHeight(Grid.valleyList.get(i).listBridge.get(j).sizBridgeY);
                    r1[j].setStyle("-fx-background-color:WHITE");
                    root.getChildren().add(r1[j]);
                }

            }
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < list.get(i).size(); j++) {
                    Unite unite = list.get(i).get(j);

//                if (unite instanceof GrizzlyTank) {
//                    if (unite.owner.teamID==0)
//                        imageURL = TANK_IMAGE;
//                }
                    if (unite instanceof MainBais) {
                        imageURL = MainBase_Image;
                    }
                    if (unite instanceof Infantry) {
                        if (unite.owner.teamID == 0)
                            imageURL = Infanry_IMAGE;
                        else
                            imageURL = Infanry_IMAGE_Def;
                    }
                    if (unite instanceof MirageTank) {
                        if (unite.owner.teamID == 0)
                            imageURL = MirageTAnk_Image;
                        else
                            imageURL = MirageTAnk_Image_Def;
                    }
                    if (unite instanceof Sniper) {
                        if (unite.owner.teamID == 0)
                            imageURL = Sniper_IMAGE;
                        else
                            imageURL = Sniper_IMAGE_Def;
                    }
                    if (unite instanceof NavySEAL) {
                        if (unite.owner.teamID == 0)
                            imageURL = NavySeal_IMAGE;
                        else
                            imageURL = NavySeal_IMAGE_Def;

                    }
                    if (unite instanceof TeslaTank) {
                        if (unite.owner.teamID == 0)
                            imageURL = TeslaTank_IMAGE;
                        else
                            imageURL = TeslaTank_IMAGE_Def;
                    }
                    if (unite instanceof TankDestroyer) {
                        if (unite.owner.teamID == 0)
                            imageURL = TankDestroyer_IMAGE;
                        else
                            imageURL = TankDestroyer_IMAGE_Def;
                    }
                    if (unite instanceof PrismTank) {
                        if (unite.owner.teamID == 0)
                            imageURL = PrismTank_IMAGE;
                        else
                            imageURL = PrismTank_IMAGE_Def;
                    }
                    if (unite instanceof GrizzlyTank) {
                        if (unite.owner.teamID == 0)
                            imageURL = GrizlyTank_IMAGE;
                        else
                            imageURL = GrizlyTank_IMAGE_Def;
                    }
                    if (unite instanceof BlackEagle) {
                        if (unite.owner.teamID == 0)
                            imageURL = Plane_IMAGE;
                        else
                            imageURL = Plane_IMAGE_Def;
                    }
                    if (unite instanceof PatriotMissileSystem) {
                        if (unite.owner.teamID == 0)
                            imageURL = Patriotmissile_IMAGE;
                        else
                            imageURL = Patriotmissile_IMAGE_Def;
                    }
                    if (unite instanceof Pillbox) {
                        if (unite.owner.teamID == 0)
                            imageURL = Pillbox_IMAGE;
                        else
                            imageURL = Pillbox_IMAGE_Def;
                    }
                    if (unite instanceof GrandCannon) {
                        if (unite.owner.teamID == 0)
                            imageURL = GrandCannon_IMAGE;
                        else
                            imageURL = GrandCannon_IMAGE_Def;
                    }
                    if (unite instanceof PrismTower) {
                        if (unite.owner.teamID == 0)
                            imageURL = PrismTower_IMAGE;
                        else
                            imageURL = PrismTower_IMAGE_Def;
                    }

                     img = new Image(imageURL);
                     view = new ImageView(img);
                    view.setPreserveRatio(true);

                    if (imageURL == MainBase_Image) {
                        view.setFitHeight(50);
                        view.setFitWidth(50);
                    }
                    if (imageURL == Infanry_IMAGE || imageURL == Infanry_IMAGE_Def) {
                        view.setFitHeight(3);
                        view.setFitWidth(3);
                    }
                    if (imageURL == Sniper_IMAGE || imageURL == Sniper_IMAGE_Def) {
                        view.setFitHeight(3);
                        view.setFitWidth(3);
                    }
                    if (imageURL == NavySeal_IMAGE || imageURL == NavySeal_IMAGE_Def) {
                        view.setFitHeight(3);
                        view.setFitWidth(3);
                    }
                    if (imageURL == TeslaTank_IMAGE || imageURL == TeslaTank_IMAGE_Def) {
                        view.setFitHeight(20);
                        view.setFitWidth(20);
                    }
                    if (imageURL == MirageTAnk_Image || imageURL == MirageTAnk_Image_Def) {
                        view.setFitHeight(15);
                        view.setFitWidth(15);
                    }
                    if (imageURL == GrizlyTank_IMAGE || imageURL == GrizlyTank_IMAGE_Def) {
                        view.setFitHeight(20);
                        view.setFitWidth(20);
                    }
                    if (imageURL == TankDestroyer_IMAGE || imageURL == TankDestroyer_IMAGE_Def) {
                        view.setFitHeight(20);
                        view.setFitWidth(20);
                    }
                    if (imageURL == PrismTank_IMAGE || imageURL == PrismTank_IMAGE_Def) {
                        view.setFitHeight(20);
                        view.setFitWidth(20);
                    }
                    if (imageURL == Pillbox_IMAGE || imageURL == Pillbox_IMAGE_Def) {
                        view.setFitHeight(40);
                        view.setFitWidth(40);
                    }
                    if (imageURL == PrismTower_IMAGE || imageURL == PrismTower_IMAGE_Def) {
                        view.setFitHeight(30);
                        view.setFitWidth(30);
                    }
                    if (imageURL == GrandCannon_IMAGE || imageURL == GrandCannon_IMAGE_Def) {
                        view.setFitHeight(40);
                        view.setFitWidth(40);
                    }
                    if (imageURL == Patriotmissile_IMAGE || imageURL == Patriotmissile_IMAGE_Def) {
                        view.setFitHeight(40);
                        view.setFitWidth(40);
                    }
                    if (imageURL == Plane_IMAGE || imageURL == Plane_IMAGE_Def) {
                        view.setFitHeight(10);
                        view.setFitWidth(10);
                    }
                    view.setLayoutX(list.get(i).get(j).unitPosition.x);
                    view.setLayoutY(list.get(i).get(j).unitPosition.y);
                    root.getChildren().add(view);


                }
            }

            mainBais.setText("Main Bais: "+DoDGameManager.mainBase.unitProperty.health);
            titleLabel.setText("remain players: "+DoDGameManager.remainingAttackerUnits);
            timelabel.setText("Time : "+DoDGameManager.remainTime);
        }
//        private void showValey () {
//            for (int i = 0; i < Grid.valleyList.size(); i++) {
//                if (Grid.valleyList.get(i).type == "") {
//
//                } else {
//
//                }
//            }
        }


        private void createButtons () {
            GridPane gridPane = new GridPane();
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 2; j++) {
                    Button button = new Button();
                    button.setPrefWidth(400);
                    button.setPrefHeight(400);
                    button.setStyle("-fx-background-color:transparent;");
                    gridPane.add(button, i, j);
                }
            }
            root.getChildren().add(gridPane);
        }


        public void zoom () {
            double width = 8000;
            double height = 8000;

            Canvas canvas = new Canvas(width, height);
            GraphicsContext gc = canvas.getGraphicsContext2D();
            StackPane result = new StackPane(canvas, root);
            Region zoomTarget = result;
            zoomTarget.setPrefSize(50, 50);
            zoomTarget.setOnDragDetected(evt -> {
                Node target = (Node) evt.getTarget();
                while (target != zoomTarget && target != null) {
                    target = target.getParent();
                }
                if (target != null) {
                    target.startFullDrag();
                }
            });

            Group group = new Group(zoomTarget);

            // stackpane for centering the content, in case the ScrollPane viewport
            // is larget than zoomTarget
            StackPane content = new StackPane(group);
            group.layoutBoundsProperty().addListener((observable, oldBounds, newBounds) -> {
                // keep it at least as large as the content
                content.setMinWidth(newBounds.getWidth());
                content.setMinHeight(newBounds.getHeight());
            });

            ScrollPane scrollPane = new ScrollPane(content);
            scrollPane.setPannable(true);
            scrollPane.viewportBoundsProperty().addListener((observable, oldBounds, newBounds) -> {
                // use vieport size, if not too small for zoomTarget
                content.setPrefSize(newBounds.getWidth(), newBounds.getHeight());
            });

            content.setOnScroll(evt -> {
                if (evt.isControlDown()) {
                    evt.consume();

                    final double zoomFactor = evt.getDeltaY() > 0 ? 1.2 : 1 / 1.2;

                    Bounds groupBounds = group.getLayoutBounds();
                    final Bounds viewportBounds = scrollPane.getViewportBounds();

                    // calculate pixel offsets from [0, 1] range
                    double valX = scrollPane.getHvalue() * (groupBounds.getWidth() - viewportBounds.getWidth());
                    double valY = scrollPane.getVvalue() * (groupBounds.getHeight() - viewportBounds.getHeight());

                    // convert content coordinates to zoomTarget coordinates
                    Point2D posInZoomTarget = zoomTarget.parentToLocal(group.parentToLocal(new Point2D(evt.getX(), evt.getY())));

                    // calculate adjustment of scroll position (pixels)
                    Point2D adjustment = zoomTarget.getLocalToParentTransform().deltaTransform(posInZoomTarget.multiply(zoomFactor - 1));

                    // do the resizing
                    double x = zoomTarget.getScaleX();
                    double y = zoomTarget.getScaleY();
//                if (x>0.3||y>0.3) {
//                    x = 0.3;
//                    y = 0.3;
//
//                    zoomTarget.setScaleX(zoomFactor *x);
//                    zoomTarget.setScaleY(zoomFactor *y);
//                }
                    if (x < 1 || y < 1) {
                        x = 1;
                        y = 1;

                        zoomTarget.setScaleX(zoomFactor * x);
                        zoomTarget.setScaleY(zoomFactor * y);
                    }
                    zoomTarget.setScaleX(zoomFactor * zoomTarget.getScaleX());
                    zoomTarget.setScaleY(zoomFactor * zoomTarget.getScaleY());

                    // refresh ScrollPane scroll positions & content bounds
                    scrollPane.layout();

                    // convert back to [0, 1] range
                    // (too large/small values are automatically corrected by ScrollPane)
                    groupBounds = group.getLayoutBounds();
                    scrollPane.setHvalue((valX + adjustment.getX()) / (groupBounds.getWidth() - viewportBounds.getWidth()));
                    scrollPane.setVvalue((valY + adjustment.getY()) / (groupBounds.getHeight() - viewportBounds.getHeight()));
                }
            });
//        StackPane left = new StackPane(new Label("soldiers : "+DoDGameManager.remainingAttackerUnits));
//        SplitPane splitPane = new SplitPane(left, scrollPane);


            titleLabel = new Label("-");
            timelabel=new Label("-");
            mainBais=new Label("-");
            VBox anchor = new VBox(titleLabel, timelabel,mainBais);
            anchor.setAlignment(Pos.CENTER);
            anchor.setPadding(new Insets(0,10,0,0));
            anchor.setMaxSize(150, 80);
            anchor.setMinSize(150, 80);
            anchor.setPrefSize(150, 80);
//            anchor.setBackground(new Background(new BackgroundFill(Color.color(0.8,0.2,0.0),CornerRadii.EMPTY, Insets.EMPTY)));



            StackPane pane = new StackPane(scrollPane,anchor);
            pane.setAlignment(Pos.TOP_RIGHT);

            gameScene = new Scene(pane, 800, 600);
            gameStage.setScene(gameScene);

        }


    }









