package GUI;

import Game.*;
import Game.AllUnites.BlackEagle;
import Game.AllUnites.GrizzlyTank;
import Game.AllUnites.Infantry;
import Game.AllUnites.PatriotMissileSystem;
import javafx.application.Application;
import javafx.stage.Stage;
import GUI.view.ViewManager;

import java.sql.Time;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class Main extends Application {

    Timer timer = new Timer();


    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            DoDGameManager doDGameManager = new DoDGameManager();
            TimerTask t = new TimerTask() {
                @Override
                public void run() {


                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    DoDGameManager.remainTime = (int) (DoDGameManager.remainingTime / 60) + ":" + (int) (DoDGameManager.remainingTime % 60);
                    DoDGameManager.remainingTime--;
                    if (DoDGameManager.remainingTime == 0) {
                        try {
                            Thread.sleep(100000000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    //System.out.println(DoDGameManager.remainTime);

                }
            };
            timer.schedule(t, 0, 1000);

            DoDGameManager.remainingAttackerUnits = 3;
            Valley v = new Valley(30, 700, "River", 100, 0, 0);
            //System.out.println(Grid.valleyList.get(0).listBridge);
           // new BlackEagle(new Player(0, "saed", 0, 0), 0, 0, new LowestHealthAttackStrategy());
           // new Infantry(new Player(0, "saed", 0, 0), 10, 50, new LowestHealthAttackStrategy());
            new Infantry(new Player(0, "saed", 0, 0), 10, 60, new LowestHealthAttackStrategy());
          Unite ss =  new Infantry(new Player(1, "saed", 0, 0), 20, 20, new HighestDamageAttackStrategy());
           // new GrizzlyTank(new Player(1, "saed", 0, 0), 300, 1, new LowestHealthAttackStrategy());
            ss.unitProperty.health+=100;
           new Infantry(new Player(1, "saed", 0, 0), 30, 30, new LowestHealthAttackStrategy());
           new PatriotMissileSystem(new Player(1, "saed", 0, 0), 200, 200, new RandomAttackStrategy());
            ViewManager manager = new ViewManager();
            primaryStage = manager.getMainStage();
            primaryStage.show();


        } catch (Exception e) {
        }

    }


    public static void main(String[] args) {
        launch(args);
    }
}
