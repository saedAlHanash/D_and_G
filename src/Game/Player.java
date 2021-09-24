package Game;

import java.io.Serializable;
import java.util.Scanner;

public class Player implements Grid, Serializable {
    DiscretionConsolePrint print = new DiscretionConsolePrint();
    public int teamID;
    public String name;
    public int squareX;
    public int squareY;
    int coins = 3000;

    public Player(int teamID, String name, int squareX, int squareY) {
        this.teamID = teamID;
        this.name = name;
        this.squareX = squareX;
        this.squareY = squareY;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }

    public void newGame() {
        puyUnite();
    }

    public void lodeGame() {

    }

    public void puyUnite() {
        int x, y;
        print.printUnites();
        Scanner scanner = new Scanner(System.in);
        while (coins > 0) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                   // new TeslaTank( this, new LowestHealthAttackStrategy());
                    coins -=50;
                    break;
                case 2:
                  //  new Sniper( this, new LowestHealthAttackStrategy());
                    coins -= 10;
                    break;
                case 3:

            }
        }
    }
}
