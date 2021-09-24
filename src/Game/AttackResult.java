package Game;

import java.io.Serializable;
import java.util.ArrayList;

public class AttackResult implements Grid, Serializable {

    public Object target(Unite unite) {
        ArrayList<Object> SS =checkRange(unite);

        return  unite.attackStrategy.PrioritizeUnitToAttack(SS, unite);
    }

    public ArrayList<Object> checkRange(Unite unite) {

        ArrayList<Object> rangeList = new ArrayList<>();
        int xRange = unite.unitPosition.x - unite.unitProperty.rang;
        int limeXRange = unite.unitPosition.x + unite.unitProperty.siz + unite.unitProperty.rang;
        int yRange = unite.unitPosition.y - unite.unitProperty.rang;
        int limeYRange = unite.unitPosition.y + unite.unitProperty.siz + unite.unitProperty.rang;
//تفحص الجسور للمدافعين
//        if (unite.owner.teamID == 1) {
//            for (int i = 0; i < valleyList.size(); i++) {
//
//                if (valleyList.get(i).listBridge.get(0).xBridge <= xRange
//                        && valleyList.get(i).listBridge.get(0).xBridge + valleyList.get(i).listBridge.get(0).sizBridgeX > xRange
//                        || valleyList.get(i).listBridge.get(0).xBridge > xRange
//                        && valleyList.get(i).listBridge.get(0).xBridge <= limeXRange
//                ) {
//                    if (valleyList.get(i).listBridge.get(0).yBridge <= yRange
//                            && valleyList.get(i).listBridge.get(0).yBridge + valleyList.get(i).listBridge.get(0).sizBridgeY > yRange
//                            || valleyList.get(i).listBridge.get(0).yBridge > yRange
//                            && valleyList.get(i).listBridge.get(0).yBridge <= limeYRange) {
//                        rangeList.add(valleyList.get(i).listBridge.get(0));
//                    }
//                }
//            }
//        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get(0).unitPosition.x > limeXRange) {
                return rangeList;
            }
            if (list.get(i).get(0).unitPosition.x <= xRange && (list.get(i).get(0).unitPosition.x + list.get(i).get(0).unitProperty.siz) > xRange ||
                    list.get(i).get(0).unitPosition.x > xRange && list.get(i).get(0).unitPosition.x <= limeXRange) {
                for (int j = 0; j < list.get(i).size(); j++) {
                    if (list.get(i).get(0).unitPosition.y > limeYRange)
                        break;
                    if (list.get(i).get(j) != unite && unite.owner.teamID != list.get(i).get(j).owner.teamID
                            && unite.typesCanAttack.contains(list.get(i).get(j).unitProperty.type))/*شرط العنصر لايفحص نفسه وفحص إذا العنصر المفحوص نستطيع الهجوم عليه*/
                        if (list.get(i).get(j).unitPosition.y <= yRange && (list.get(i).get(j).unitPosition.y + list.get(i).get(j).unitProperty.siz) > yRange ||
                                list.get(i).get(j).unitPosition.y > yRange && list.get(i).get(j).unitPosition.y <= limeYRange) {
                            if (list.get(i).get(j).unitProperty.health > 0) {       /*شرط الموت قابل للألغاء */
                                rangeList.add(list.get(i).get(j));
                            }

                        }
                }
            }
        }
        return rangeList;
    }
}
