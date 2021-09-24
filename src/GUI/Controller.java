package GUI;

import GUI.model.DestroyOrDefendSubScene;
import GUI.model.InfoLabel;
import GUI.model.UiButtonInterface;
import GUI.view.GameViewManager;
import GUI.view.ViewManager;
import Game.DoDGameManager;
import Game.Unite;
import Game.Main;
import javafx.application.Platform;

import javax.net.ssl.ManagerFactoryParameters;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    protected GameViewManager gameViewManager;
    protected ViewManager viewManager;
    protected DestroyOrDefendSubScene destroyOrDefendSubScene;
    protected InfoLabel infoLabel;
    protected UiButtonInterface uiButtonInterface;
    protected Main game;

    public Controller(Main game, GameViewManager gameViewManager){
        this.game = game;
        this.gameViewManager = gameViewManager;
    }

    public void start(){
        gameViewManager.showUnits(DoDGameManager.list);
        new Thread(new UpdateService(DoDGameManager.list)).start();
    }

    private class UpdateService implements Runnable {

        ArrayList<ArrayList<Unite>> list;

        UpdateService(ArrayList<ArrayList<Unite>> list) {
            super();
            this.list = list;
        }

        @Override
        public void run() {

            try {
                while (true) {
                    Thread.sleep(10);


                    try {
                        if (DoDGameManager.mainBase.unitProperty.health>0||DoDGameManager.remainingTime>2|| DoDGameManager.remainingAttackerUnits>0) {
                            game.init();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Platform.runLater(() -> {
                        gameViewManager.showUnits(list);
                    });
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

