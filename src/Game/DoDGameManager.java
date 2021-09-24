package Game;

import Game.AllUnites.MainBais;

import java.io.Serializable;

public class DoDGameManager implements Grid, Serializable {

    public static Unite mainBase;
    public  static double remainingTime;
    public  static String remainTime;
    public static int remainingAttackerUnits;
    public static Boolean chack;
    Team attackerTeam;
    Team DefenderTeam ;
    public static boolean pause;
     public DoDGameManager() {
        attackerTeam = new AttackerTeam();
        DefenderTeam = new DefenderTeam();
         mainBase = new MainBais();
         remainingTime=10;
         remainTime="";
         pause=false;

    }
    public  void gameStart(){
        class EndGame extends Thread{
            public synchronized void std(){
                notify();
            }
            @Override
            public void run() {
                while (true){
                    if (DoDGameManager.pause==true) {
                        synchronized (this){try {
                            wait();
                        } catch (InterruptedException e) {
                            // e.printStackTrace();
                        }}
                    }
                    if (mainBase.unitProperty.health<=0){

                    }
                    if (remainingTime==0 || remainingAttackerUnits==0){

                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
//        class StartGame extends Thread{
//            public synchronized void std(){
//                notify();
//            }
//            @Override
//            public void run() {
//
//                while (true){
//
//
//
//                }
//            }
//        }

//       // EndGame endGame=new EndGame();
//         StartGame startGame=new StartGame();
//        // endGame.start();
//         startGame.start();
//
//        for (int i = 0; i <10 ; i++) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            if (i==5){
//                pause=true;
//            }
//            if (i==9){
//
//                pause=false;
//            //  synchronized (endGame){endGame.std();}
//                synchronized (startGame){startGame.std();}
//            }
//        }






    }
}
