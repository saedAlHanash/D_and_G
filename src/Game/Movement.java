package Game;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Movement implements Grid {
    int previousMove;
    int stopMove;


    public Movement() {
        previousMove = -1;
        stopMove = 1;
    }

    public String move(Unite unite, int i, int j) {
        return "";
    }


    public String sort(Unite unite, int i, int j, int temp) {
        if (temp == 1 || temp == 5) {
            Collections.sort(list.get(i));
            unite.unitProperty.reLodeSpeed = 10;
            return "current list";
        } else if (temp >= 2 && temp <= 4) {
            if (list.get(i).size() == 1) {
                if (i == 0) {
                    unite.unitProperty.reLodeSpeed = 10;
                    return "continue";
                }
                if (list.get(i - 1).get(0).unitPosition.x < unite.unitPosition.x) {
                    unite.unitProperty.reLodeSpeed = 10;
                    return "continue";
                }
                if (list.get(i - 1).get(0).unitPosition.x == unite.unitPosition.x) {
                    list.get(i - 1).add(unite);
                    Collections.sort(list.get(i-1));
                    list.remove(i);
                    unite.unitProperty.reLodeSpeed = 10;
                    return "add lift list priv";
                }
            } else {
                if (i == 0) {
                    list.add(0, new ArrayList<Unite>());
                    list.get(0).add(unite);
                    list.get(1).remove(j);
                    unite.unitProperty.reLodeSpeed = 10;

                    return "add lift new list";
                }
                if (list.get(i - 1).get(0).unitPosition.x < unite.unitPosition.x) {
                    list.add(i, new ArrayList<Unite>());
                    list.get(i).add(unite);
                    list.get(i + 1).remove(j);
                    unite.unitProperty.reLodeSpeed = 10;
                    return "add lift new list";
                }
                if (list.get(i - 1).get(0).unitPosition.x == unite.unitPosition.x) {
                    list.get(i - 1).add(unite);
                    Collections.sort(list.get(i-1));
                    list.get(i).remove(j);
                    unite.unitProperty.reLodeSpeed = 10;
                    return "add lift list priv";
                }
            }
        } else {
            if (list.get(i).size() == 1) {
                if (i == list.size() - 1) {
                    unite.unitProperty.reLodeSpeed = 10;
                    unite.unitProperty.visit = true;
                    return "continue";
                }
                if (list.get(i + 1).get(0).unitPosition.x > unite.unitPosition.x) {
                    unite.unitProperty.reLodeSpeed = 10;
                    return "continue";
                }
                if (list.get(i + 1).get(0).unitPosition.x == unite.unitPosition.x) {
                    list.get(i + 1).add(unite);
                    Collections.sort(list.get(i+1));
                    list.remove(i);
                    unite.unitProperty.reLodeSpeed = 10;
                    unite.unitProperty.visit = true;
                    return "add right list priv";
                }
            } else {
                if (i == list.size() - 1) {
                    list.add(new ArrayList<Unite>());
                    list.get(list.size()).add(unite);
                    list.get(list.size() - 1).remove(j);
                    unite.unitProperty.reLodeSpeed = 10;
                    unite.unitProperty.visit = true;
                    return "add right new list";
                }
                if (list.get(i + 1).get(0).unitPosition.x > unite.unitPosition.x) {
                    list.add(i + 1, new ArrayList<Unite>());
                    list.get(i + 1).add(unite);
                    list.get(i).remove(j);
                    unite.unitProperty.reLodeSpeed = 10;
                    unite.unitProperty.visit = true;
                    return "add right new list";
                }
                if (list.get(i + 1).get(0).unitPosition.x == unite.unitPosition.x) {
                    list.get(i + 1).add(unite);
                    Collections.sort(list.get(i + 1));
                    list.get(i).remove(j);
                    unite.unitProperty.reLodeSpeed = 10;
                    unite.unitProperty.visit = true;
                    return "add right list priv";
                }
            }
        }
        return "";
    }


    public String alkadi(int temp, int x, int y, Unite unite) {
        if (temp == 1 || temp == 5)
            return "horizontal";
        else if (temp == 3 || temp == 7)
            return "vertically";
        else if (Math.abs(x-unite.unitPosition.x)> Math.abs(y- unite.unitPosition.y ))
            return "vertically";
        else
            return "horizontal";
    }

    public int jihad(int x, int oldx, int y, int oldy) {
        if (x > oldx && y < oldy)
            return 0;
        else if (x == oldx && y < oldy)
            return 1;
        else if (x < oldx && y < oldy)
            return 2;
        else if (x < oldx && y == oldy)
            return 3;
        else if (x < oldx && y > oldy)
            return 4;
        else if (x == oldx && y > oldy)
            return 5;
        else if (x > oldx && y > oldy)
            return 6;
        else if (x > oldx && y == oldy)
            return 7;
        return 0;
    }
}