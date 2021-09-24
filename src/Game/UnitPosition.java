package Game;

import Game.AllUnites.BlackEagle;

import java.io.Serializable;

public class UnitPosition implements Grid, Serializable {
    public int x=-1, y=-1;

    public boolean checkAvailable(Unite unite) {
        if (x < 0 || y < 0)
            return false;

        if (checkValley(unite)) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).get(0).unitPosition.x > x + unite.unitProperty.siz) {
                    return true;
                }

                for (int j = 0; j < list.get(i).size(); j++) {
                    if (list.get(i).get(j).unitPosition.y > y + unite.unitProperty.siz)
                        continue;
                    if (list.get(i).get(j) != unite)
                        if (list.get(i).get(j).unitPosition.x <= x && (list.get(i).get(j).unitPosition.x + list.get(i).get(j).unitProperty.siz) >= x ||
                                list.get(i).get(j).unitPosition.x <= x+unite.unitProperty.siz && list.get(i).get(j).unitPosition.x+  list.get(i).get(j).unitProperty.siz>= x + unite.unitProperty.siz)
                            if (list.get(i).get(j).unitPosition.y <= y && (list.get(i).get(j).unitPosition.y + list.get(i).get(j).unitProperty.siz) >= y ||
                                    list.get(i).get(j).unitPosition.y <= y+unite.unitProperty.siz && list.get(i).get(j).unitPosition.y+  list.get(i).get(j).unitProperty.siz>= y + unite.unitProperty.siz) {
                                return false;
                            }
                }

            }
            return true;
        }
        else
            return false;
    }

    public boolean checkValley(Unite unite) {
        for (int i = 0; i < valleyList.size(); i++) {
            if (valleyList.get(i).x >= x + unite.unitProperty.siz) {

                return true;
            }
            if (valleyList.get(i).x <= x && (valleyList.get(i).x + valleyList.get(i).sizX) > x
                    || valleyList.get(i).x > x && valleyList.get(i).x <= x + unite.unitProperty.siz) {
                if (valleyList.get(i).y <= y && (valleyList.get(i).y + valleyList.get(i).sizY) > y
                        || valleyList.get(i).y > y && valleyList.get(i).y <= y + unite.unitProperty.siz) {
                    return false;
                }
            }
        }
        return true;
    }
    public  Object check1(Unite unite) {
        if (x < 0 || y < 0)
            return null;
        Object object =checkValley1(unite);
        if (object!=null)
            return object;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get(0).unitPosition.x > x + unite.unitProperty.siz) {
                return null;
            }

            for (int j = 0; j < list.get(i).size(); j++) {
                if (list.get(i).get(j).unitPosition.y > y + unite.unitProperty.siz || list.get(i).get(j) instanceof BlackEagle)
                    continue;
                if (list.get(i).get(j) != unite)
                    if (list.get(i).get(j).unitPosition.x <= x && (list.get(i).get(j).unitPosition.x + list.get(i).get(j).unitProperty.siz) >= x ||
                            list.get(i).get(j).unitPosition.x <= x+unite.unitProperty.siz && list.get(i).get(j).unitPosition.x+  list.get(i).get(j).unitProperty.siz>= x + unite.unitProperty.siz)
                        if (list.get(i).get(j).unitPosition.y <= y && (list.get(i).get(j).unitPosition.y + list.get(i).get(j).unitProperty.siz) >= y ||
                                list.get(i).get(j).unitPosition.y <= y+unite.unitProperty.siz && list.get(i).get(j).unitPosition.y+  list.get(i).get(j).unitProperty.siz>= y + unite.unitProperty.siz) {
                            if (!(list.get(i).get(j) instanceof BlackEagle))
                                return list.get(i).get(j);
                        }
            }

        }
        return null;
    }
    public Object checkValley1(Unite unite) {
        for (int i = 0; i < valleyList.size(); i++) {
            if (valleyList.get(i).x >= x + unite.unitProperty.siz) {

                return null;
            }
            if (valleyList.get(i).x <= x && (valleyList.get(i).x + valleyList.get(i).sizX) > x
                    || valleyList.get(i).x > x && valleyList.get(i).x <= x + unite.unitProperty.siz) {
                if (valleyList.get(i).y <= y && (valleyList.get(i).y + valleyList.get(i).sizY) > y
                        || valleyList.get(i).y > y && valleyList.get(i).y <= y + unite.unitProperty.siz) {

                    return valleyList.get(i);
                }
            }
        }
        return null;
    }
    @Override
    public String toString() {
        return
                '{' + "x=" + x +
                        ", y=" + y + '}'
                ;
    }


}










































/*
            if (x > list.get(i).get(0).unitPosition.x) {//التحقق من مع x المجاورين السابقين
                    if (x <= ((list.get(i).get(0).unitPosition.x) + list.get(i).get(0).siz)) {// شرط التقاطع مع x
                    for (int j = 0; j < list.get(i).size(); j++) {
        if (y > list.get(i).get(j).unitPosition.y) {//التحقق من y المجاورين السابقين
        if (y < ((list.get(i).get(j).unitPosition.y) + list.get(i).get(j).siz))// شرط التقاطع مع y
        return false;
        } else {
        if (y + army.siz > list.get(i).get(j).unitPosition.y)
        return false;
        }
        }
        }
        } else {
        if (x + army.siz >= list.get(i).get(0).unitPosition.x) {
        for (int j = 0; j <list.get(i).size() ; j++) {
        if (y > list.get(i).get(j).unitPosition.y){
        if (y < ((list.get(i).get(j).unitPosition.y) + list.get(i).get(j).siz))// شرط التقاطع مع y
        return false;
        }else {
        if (y + army.siz > list.get(i).get(j).unitPosition.y)
        return false;
        }
        }
        }

        }*/
