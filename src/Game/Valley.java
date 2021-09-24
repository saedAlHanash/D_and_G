package Game;

import java.io.Serializable;
import java.util.ArrayList;

public class Valley implements Grid, Serializable {
    public  int sizX;
    public  int sizY;
    public String type;
    public  int x;
    public  int y;
   public ArrayList<Bridge> listBridge;

    public Valley(int sizX, int sizY, String type, int x, int y,int nuBridge) {
        this.sizX = sizX;
        this.sizY = sizY;
        this.type = type;
        this.x = x;
        this.y = y;
        int temp;
        if (sizX>sizY)
            temp=sizX/(nuBridge+1);
        else
            temp=sizY/(nuBridge+1);
        listBridge=new ArrayList<Bridge>();
        for (int i = 0; i <nuBridge ; i++) {
            if (sizX>sizY)
                listBridge.add(new Bridge(x+100,y,25,sizY,1000));
            else
                listBridge.add(new Bridge(x,y+100,sizX,25,1000));
            temp+=temp;
        }
        Grid.valleyList.add(this);
    }


    public void vallyAdd(Valley valley){
        valleyList.add(valley);
    }

    @Override
    public String toString() {
        return "Valley{" +
                "sizX=" + sizX +
                ", sizY=" + sizY +
                ", type='" + type + '\'' +
                ", valleyPosition=" + x+"\t"+y +
                '}';
    }
    public   class Bridge {
        public    int sizBridgeX;
        public   int sizBridgeY;
        public   int xBridge;
        public   int yBridge;
        public   int health;
        public Bridge(int xBridge, int yBridge , int sizBridgeX, int sizBridgeY, int health) {
            this.sizBridgeX = sizBridgeX;
            this.sizBridgeY = sizBridgeY;
            this.xBridge = xBridge;
            this.yBridge = yBridge;
            this.health = health;
        }

        @Override
        public String toString() {
            return "saed{" +
                    "sizSaedX=" + sizBridgeX +
                    ", sizSeadY=" + sizBridgeY +
                    ", xSaed=" + xBridge +
                    ", ySaed=" + yBridge +
                    '}';
        }
    }

}
