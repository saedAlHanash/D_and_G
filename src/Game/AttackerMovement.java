package Game;

import Game.AllUnites.BlackEagle;

public class AttackerMovement extends Movement implements Grid {
    public AttackerMovement() {
        super();
    }

    public String move(Unite unite, int i, int j) {
        unite.unitProperty.speed=unite.unitProperty.speedMain;

        if (unite == DoDGameManager.mainBase)
            return "continue";
        if (unite.unitProperty.speed == 0)
            return "continue";
        int oldY = unite.unitPosition.y, oldX = unite.unitPosition.x;
        double Length = Math.sqrt(Math.pow(unite.unitPosition.y - DoDGameManager.mainBase.unitPosition.y, 2) + Math.pow(unite.unitPosition.x - DoDGameManager.mainBase.unitPosition.x, 2));
        if (Length<=unite.unitProperty.rang && !(unite instanceof BlackEagle))
            return "continue" ;
        double t = 1 / Length;
        float x1 = unite.unitPosition.x, y1 = unite.unitPosition.y;
        float xt = (float) ((DoDGameManager.mainBase.unitPosition.x - x1) * t);
        float yt = (float) ((DoDGameManager.mainBase.unitPosition.y - y1) * t);
        xt = x1 + xt;
        yt = y1 + yt;
        //  System.out.println("x="+ Math.round(xt) +"   y="+ Math.round(yt) );
        unite.unitPosition.x = Math.round(xt);
        unite.unitPosition.y = Math.round(yt);
        int temp = jihad(unite.unitPosition.x, oldX, unite.unitPosition.y, oldY);

        if (unite instanceof BlackEagle) {
            if (unite.unitProperty.reLode == unite.unitProperty.attackFrequency) {
                return sort(unite, i, j, temp);

            } else {
                Length = Math.sqrt(Math.pow(unite.unitPosition.y - ((BlackEagle) unite).startY, 2) + Math.pow(unite.unitPosition.x - ((BlackEagle) unite).startX, 2));
                t = 1 / Length;
                x1 = oldX;
                y1 = oldY;
                xt = (float) ((((BlackEagle) unite).startX - x1) * t);
                yt = (float) ((((BlackEagle) unite).startY - y1) * t);
                xt = x1 + xt;
                yt = y1 + yt;
                unite.unitPosition.x = Math.round(xt);
                unite.unitPosition.y = Math.round(yt);

                temp = jihad(unite.unitPosition.x, oldX, unite.unitPosition.y, oldY);
                if (Math.abs(unite.unitPosition.x- ((BlackEagle) unite).startX)<=3 && Math.abs(unite.unitPosition.y- ((BlackEagle) unite).startY)<=3)
                    unite.unitProperty.reLode = 0;
                return sort(unite, i, j, temp);
            }
        }
        Object object = unite.unitPosition.check1(unite);
        //   System.out.println((Unite)object);
        if (object instanceof Valley) {
            int nearest=1000000000,ii = -1;
            for (int k = 0; k <((Valley) object).listBridge.size(); k++){
                Length = Math.sqrt(Math.pow(unite.unitPosition.y - ((Valley) object).listBridge.get(k).yBridge, 2) + Math.pow(unite.unitPosition.x - ((Valley) object).listBridge.get(k).xBridge, 2));
                if (Length<nearest){
                    nearest=(int)Length;
                    ii=k;
                }
            }

            if (ii!=-1&&((Valley)object).sizX>((Valley)object).sizY){
                if (((Valley)object).listBridge.get(ii).xBridge < unite.unitPosition.x
                && ((Valley)object).listBridge.get(ii).xBridge+25 > unite.unitPosition.x
                && ((Valley)object).listBridge.get(ii).xBridge < unite.unitPosition.x+unite.unitProperty.siz
                && ((Valley)object).listBridge.get(ii).xBridge+25 > unite.unitPosition.x+unite.unitProperty.siz){

                    if (unite.unitPosition.y> DoDGameManager.mainBase.unitPosition.y){
                        unite.unitPosition.x=oldX;
                        unite.unitPosition.y=oldY-1;
                        return sort(unite,i,j,1);
                    }
                    else {
                        unite.unitPosition.x=oldX;
                        unite.unitPosition.y=oldY+1;
                        return sort(unite,i,j,5);
                    }
                }
            }
            else if(ii!=-1&&((Valley)object).sizX<((Valley)object).sizY) {
                if (((Valley)object).listBridge.get(ii).yBridge < unite.unitPosition.y
                        && ((Valley)object).listBridge.get(ii).yBridge+25 > unite.unitPosition.y
                        && ((Valley)object).listBridge.get(ii).yBridge < unite.unitPosition.y+unite.unitProperty.siz
                        && ((Valley)object).listBridge.get(ii).yBridge+25 > unite.unitPosition.y+unite.unitProperty.siz){
                    if (unite.unitPosition.x> DoDGameManager.mainBase.unitPosition.x){
                        unite.unitPosition.x=oldX-1;
                        unite.unitPosition.y=oldY;
                        return sort(unite,i,j,3);
                    }
                    else {
                        unite.unitPosition.x=oldX+1;
                        unite.unitPosition.y=oldY;
                        return sort(unite,i,j,7);
                    }
                }
            }


             if(((Valley)object).type=="River"){
                 if (ii==-1){
                     unite.unitProperty.speed=unite.unitProperty.speed/2;
                     return sort(unite,i,j,temp);
                 }
                 int time,tall;
                if (((Valley)object).sizX>((Valley)object).sizY) {
                    time = (((Valley) object).sizY + Math.abs(unite.unitPosition.x - ((Valley) object).listBridge.get(ii).xBridge)) * 1000 / unite.unitProperty.speed;
                    tall=((Valley)object).sizX;
                }else {
                    time = (((Valley) object).sizX + Math.abs(unite.unitPosition.y - ((Valley) object).listBridge.get(ii).yBridge)) * 1000 / unite.unitProperty.speed;
                    tall=((Valley)object).sizY;
                }
                if (time >= (tall*2*1000/unite.unitProperty.speed)){
                    unite.unitProperty.speed=unite.unitProperty.speed/2;
                    return sort(unite,i,j,temp);
                }
             }

            if (((Valley)object).sizX>((Valley)object).sizY){
                if (((Valley)object).listBridge.get(ii).xBridge > unite.unitPosition.x){
                    unite.unitPosition.x=oldX+1;
                    unite.unitPosition.y=oldY;
                    return sort(unite,i,j,7);
                }
                else {
                    unite.unitPosition.x=oldX-1;
                    unite.unitPosition.y=oldY;
                    return sort(unite,i,j,4);
                }
            }
            else {
                if (((Valley)object).listBridge.get(ii).yBridge > unite.unitPosition.y){
                    unite.unitPosition.x=oldX;
                    unite.unitPosition.y=oldY+1;
                    return sort(unite,i,j,1);
                }
                else {
                    unite.unitPosition.x=oldX;
                    unite.unitPosition.y=oldY-1;
                    return sort(unite,i,j,5);
                }

            }
        }




        else if (object instanceof Unite) {
            String s = alkadi(temp, unite.unitPosition.x, unite.unitPosition.y, (Unite) object);
            if (s.equals("vertically")) {
                double length1 = DoDGameManager.mainBase.unitPosition.y - (unite.unitPosition.y - 1);
                double length2 = DoDGameManager.mainBase.unitPosition.y - (unite.unitPosition.y + 1);
                if (length1 < length2 && (previousMove == -1 || previousMove == 1)) {
                    unite.unitPosition.x = oldX;
                    unite.unitPosition.y = oldY - 1;
                    if (unite.unitPosition.check1(unite) != null) {
                        unite.unitPosition.x = oldX;
                        unite.unitPosition.y = oldY + 1;
                        if (unite.unitPosition.check1(unite) != null ) {
                            unite.unitPosition.x = oldX;
                            unite.unitPosition.y = oldY;
                            return "continue";
                        } else {
                            previousMove = 5;
                            return sort(unite, i, j, 5);
                        }
                    } else {
                        previousMove = 1;
                        return sort(unite, i, j, 1);
                    }
                } else {
                    unite.unitPosition.x = oldX;
                    unite.unitPosition.y = oldY + 1;
                    if (unite.unitPosition.check1(unite) != null) {
                        unite.unitPosition.x = oldX;
                        unite.unitPosition.y = oldY - 1;
                        if (unite.unitPosition.check1(unite) != null) {
                            unite.unitPosition.x = oldX;
                            unite.unitPosition.y = oldY;
                            return "continue";
                        } else {
                            previousMove = 1;
                            return sort(unite, i, j, 1);
                        }
                    } else {
                        previousMove = 5;
                        return sort(unite, i, j, 5);
                    }
                }
            } else {
                double length1 = DoDGameManager.mainBase.unitPosition.x - (unite.unitPosition.x - 1);
                double length2 = DoDGameManager.mainBase.unitPosition.x - (unite.unitPosition.x + 1);
                if (length1 < length2 && (previousMove == -1 || previousMove == 3)) {
                    unite.unitPosition.x = oldX - 1;
                    unite.unitPosition.y = oldY;
                    if (unite.unitPosition.check1(unite) != null) {
                        unite.unitPosition.x = oldX + 1;
                        unite.unitPosition.y = oldY;
                        if (unite.unitPosition.check1(unite) != null) {
                            unite.unitPosition.x = oldX;
                            unite.unitPosition.y = oldY;
                            return "continue";
                        } else {
                            previousMove = 7;
                            return sort(unite, i, j, 7);
                        }
                    } else {
                        previousMove = 3;
                        return sort(unite, i, j, 3);
                    }
                } else {
                    unite.unitPosition.x = oldX + 1;
                    unite.unitPosition.y = oldY;
                    if (unite.unitPosition.check1(unite) != null) {
                        unite.unitPosition.x = oldX - 1;
                        unite.unitPosition.y = oldY;
                        if (unite.unitPosition.check1(unite) != null) {
                            unite.unitPosition.x = oldX;
                            unite.unitPosition.y = oldY;
                            return "continue";
                        } else {
                            previousMove = 3;
                            return sort(unite, i, j, 3);
                        }
                    } else {
                        previousMove = 7;
                        return sort(unite, i, j, 7);
                    }
                }
            }
        } else {
            previousMove = -1;
            return sort(unite, i, j, temp);
        }
        //return "continue";
    }
}
