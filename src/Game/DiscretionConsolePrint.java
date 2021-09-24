package Game;

import java.io.Serializable;
import java.util.Scanner;

public class DiscretionConsolePrint implements Grid, Serializable {
    public void printUnites() {
        System.out.println("TeslaTank : { MaxHealth 1000 ,Armor 0.5 ,AttackDamage 300 ,AttackRange 250 ,AttackFrequency 0.6S ,Speed 30 ,UnitPrice 50 }\n");
        System.out.println("Sniper : { MaxHealth 250 ,Armor 0.1 ,AttackDamage 70 ,AttackRange 700 ,AttackFrequency 0.4S ,Speed 10 ,UnitPrice 5 }\n");
        System.out.println("Mirage tank : { MaxHealth 750 ,Armor 0.1 ,AttackDamage 1000 ,AttackRange 10 ,AttackFrequency 1S ,Speed 60 ,UnitPrice 70 }\n");
        System.out.println("Infantry solder : { MaxHealth 250 ,Armor 0.2 ,AttackDamage 50 ,AttackRange 50 ,AttackFrequency 1.5S ,Speed 10 ,UnitPrice 3 }\n");
        System.out.println("Grizzly Tank : { MaxHealth 1000 ,Armor 0.4 ,AttackDamage 250 ,AttackRange 250 ,AttackFrequency 0.6S ,Speed 30 ,UnitPrice 50 }\n");
        System.out.println("Navy Solder : { MaxHealth 400 ,Armor 0.2 ,AttackDamage 60 ,AttackRange 50 ,AttackFrequency 2S ,Speed 20 ,UnitPrice 10 }\n");
    }


    public void printGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("get the zoom =");
        int zoom = scanner.nextInt();
        System.out.println("get the lime x=");
        int limX = scanner.nextInt();
        System.out.println("get the lime y=");
        int limY = scanner.nextInt();
        Unite[][] saed = new Unite[zoom][zoom];
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get(0).unitPosition.x > limX - zoom && list.get(i).get(0).unitPosition.x < limX) {
                for (int j = 0; j < list.get(i).size(); j++) {
                    if (list.get(i).get(j).unitPosition.y > limY - zoom && list.get(i).get(0).unitPosition.y < limY) {
                        System.out.println(list.get(i).get(j));
                        saed[limX - list.get(i).get(0).unitPosition.x][limY - list.get(i).get(j).unitPosition.y] = list.get(i).get(j);
                    }
                }
            }
        }
//        for (int i = 0; i < zoom; i++) {
//            System.out.println();
//            for (int j = 0; j < zoom; j++) {
//                if (saed[j][i] == null)
//                    System.out.print("_ ");
//                else
//                    System.out.print(saed[j][i] + " ");
//            }
//        }



        /*
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get(0).unitPosition.x < 20) {
                for (int j = 0; j < list.get(i).size(); j++) {
                    if (list.get(i).get(j).unitPosition.y < 20)
                        saed[list.get(i).get(0).unitPosition.x][list.get(i).get(j).unitPosition.y] = list.get(i).get(j);
                    else
                        break;
                }
            }
        }


        for (int i = 0; i < 20; i++) {
            System.out.println();
            for (int j = 0; j < 20; j++) {
                if (saed[i][j] == null) {
                    saed[i][j] = "_";
                }
                System.out.print(saed[i][j] + " ");
            }
        }*/
    }

}

