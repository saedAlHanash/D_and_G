package Game;

import Game.AllUnites.BlackEagle;

import java.io.*;

public class Main implements Grid {

    public void init() throws IOException {
        File file = new File("game.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter("game.txt"));
        String z = "";
        boolean chack = false;
        int i1, t = 0;
        int size;
        Unite saed;
        long start, end;
        synchronized (list) {


//                        System.out.println(list);

               writer.write("\n");
            start = System.nanoTime();
            try {

                for (int i = 0; i < list.size(); i++) {
                    i1 = i;
                    for (int j = 0; j < list.get(i).size(); j++) {

                        if (DoDGameManager.pause == true) {
                            synchronized (this) {
                                try {
                                    wait();
                                } catch (InterruptedException e) {
                                    // e.printStackTrace();
                                }
                            }
                        }
                        if (!(list.get(i).get(j) instanceof BlackEagle) && list.get(i).get(j).unitPosition.x == 147 && list.get(i).get(j).unitPosition.y == 147 && list.get(i).get(j).unitProperty.reLodeSpeed == 100)
                            System.out.println("gk");

                        saed = list.get(i).get(j);
                        size = list.get(i).size();
                        try {
                            list.get(i).get(j).attack();
                            if (!(list.get(i).get(j) instanceof BlackEagle))
                                list.get(i).get(j).unitProperty.reLode += 10;
                            else {

                                writer.write(saed.toString() + "\n");
                            }
                        } catch (Exception e) {
                        }

                        // التحقق أذا كان قادر على الحركة
                        if (list.get(i1).get(j).unitProperty.speed != 0 && list.get(i1).get(j).unitProperty.reLodeSpeed >= 1000 / list.get(i1).get(j).unitProperty.speed) {

                            z = list.get(i1).get(j).movement.move(list.get(i1).get(j), i1, j);


                        }
                        //اضافة الوقت لل reLode speed
                        else if (!list.get(i1).get(j).unitProperty.visit) {
                            list.get(i1).get(j).unitProperty.reLodeSpeed += 10;
                            continue;
                        } else {
                            list.get(i1).get(j).unitProperty.visit = false;
                            continue;
                        }

                        if (z.equals("continue") || z.equals("current list"))
                            continue;
                        else {
                            if (z.equals("add lift new list") && i != list.size() - 1)
                                i++;
                            if ((z.equals("add right list priv") || z.equals("add lift list priv")) && size == 1)
                                chack = true;
                            if (j == 0 && size > 1) {
                                j = -1;
                                continue;
                            }
                            if (j != 0 && j != size - 1)
                                j--;
                            if (size == 1)
                                break;
                        }
                    }
                    if (chack) {
                        i--;
                        chack = false;
                    }
                }

                System.out.println(t + "  " + list);
                t++;
            } catch (Exception e) {
            }


               writer.close();


        }


    }

}


//        try {
//            File file = new File("saed.bin");
//            ObjectOutputStream fileOutputStream = new ObjectOutputStream(new FileOutputStream(file));
//            fileOutputStream.writeObject(list);
//            fileOutputStream.close();
//        } catch (Exception e) {
//            System.err.println("wrong!!");
//        }


//   File file = new File("saed.bin");
//        BufferedWriter writer = new BufferedWriter(new FileWriter("saed.bin"));
//        for (int i = 0; i < list.size(); i++) {
//            for (int j = 0; j < list.get(i).size(); j++)
//                writer.write(String.valueOf(list.get(i).get(j)));
//        }
//        writer.close();


//        Unite s= new Solder(new int[]{0,0},new Player(0,"saed"));
//        Unite ss= new Tank(new int[]{4,4},new Player(1,"saed"));
//        System.out.println(ss.attackResult.checkRange(ss));
//

//        DoDGameManager S = new DoDGameManager();
//        S.gameStart();
//        System.out.println(list.size());
//        for (int i = 0; i < list.size(); i++) {
//            for (int j = 0; j < list.get(i).size(); j++) {
//                if (list.get(i).get(j).owner.teamID == 1) {
//                    System.out.println(list.get(i).get(j));
//                }
//            }
//        }
//        System.out.println(list);
//DiscretionConsolePrint discretionConsolePrint= new DiscretionConsolePrint();
//discretionConsolePrint.printGame();


//
//
//        File file = new File("saed.txt");
//        BufferedWriter writer= new BufferedWriter(new FileWriter("saed.txt"));
//        for (int i = 0; i <list.size() ; i++) {
//            for (int j = 0; j <list.get(i).size() ; j++)
//            writer.write(list.get(i).get(j).toString());
//        }
//        writer.close();
 /*       Unite A = new Solder(new int[]{3, 10},new Player(0,"saed"));
        Unite A9 = new Solder(new int[]{10000009, 10000009},new Player(0,"saed"));
        Unite A1 = new Tank(new int[]{50, 50},new Player(0,"saed"));
        Unite A2 = new Solder(new int[]{18, 10},new Player(0,"saed"));
        Unite A112 = new Solder(new int[]{32, 10},new Player(0,"saed"));
        DiscretionConsolePrint S= new DiscretionConsolePrint();
        S.printGame();
        System.out.println(list);*/


































/*
        Army A = new Solder(new int[]{3, 3});
        Army A1 = new Solder(new int[]{3, 7});
        Army A2 = new Solder(new int[]{1, 2});
        Army A3 = new Solder(new int[]{5, 8});
        Army T = new Tank(new int[]{18, 5});
        Army T1 = new Tank(new int[]{11, 4});
        Army T2 = new Tank(new int[]{23, 15});
        Army T3 = new Tank(new int[]{23, 5});
        System.out.println(list);
        T2.attack();
        T2.attack();
        T2.attack();
        System.out.println(list);
*/
/*
         Unite A = new Solder(new int[]{3, 10});
        Unite A1 = new Tank(new int[]{50, 10});
        Unite A2 = new Solder(new int[]{18, 10});
        Unite A112 = new Solder(new int[]{32, 10});
        Unite A26 = new Solder(new int[]{28, 10});
        Unite A12 = new Solder(new int[]{19, 3});
        Unite A22 = new Solder(new int[]{3, 3});
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                list.get(i).get(j).moveDown(i, j);
                list.get(i).get(j).moveLift(i, j);
                list.get(i).get(j).moveLift(i, j);
                list.get(i).get(j).moveLift(i, j);
                list.get(i).get(j).moveLift(i, j);
            }
        }
        System.out.println("\n"+list);
        A26.unitProperty.health-=1;
        A.attack();
       System.out.println(A.targetUnite+"\t"+A.attackResult.target(A.targetUnite));
        System.out.println(list);*/














































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


//        Random random = new Random();
//        for (int i = 0; i <50 ; i++) {
//            int x=random.nextInt((20-10)+1)+10;
//            System.out.print(x+"  ");
//        }