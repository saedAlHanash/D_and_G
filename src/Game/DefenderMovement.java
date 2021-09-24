package Game;

public class DefenderMovement extends Movement {
    int startPointX;
    int startPointY;
    int endPointX;
    int endPointY;
    char handMovement;

    public DefenderMovement(int startPointX, int startPointY, int endPointX, int endPointY) {
        this.startPointX = startPointX;
        this.startPointY = startPointY;
        this.endPointX = endPointX;
        this.endPointY = endPointY;
        handMovement = 'e';

    }

    public String move(Unite unite, int i, int j) {

        if (unite == DoDGameManager.mainBase)
            return "continue";
        if (unite.unitProperty.speed == 0)
            return "continue";
        if (unite.unitPosition.x==startPointX && unite.unitPosition.y==startPointY)
            handMovement='e';
//        if (Math.abs(unite.unitPosition.x-endPointX)<=60 && Math.abs(unite.unitPosition.y-endPointY)<=60)
//            handMovement='s';

        int x, y;
        if (handMovement == 'e') {
            x = endPointX;
            y = endPointY;
        } else {
            x = startPointX;
            y = startPointY;
        }
        int oldY = unite.unitPosition.y, oldX = unite.unitPosition.x;
        double Length = Math.sqrt(Math.pow(unite.unitPosition.y - y, 2) + Math.pow(unite.unitPosition.x - x, 2));
        double t = 1 / Length;
        float x1 = unite.unitPosition.x, y1 = unite.unitPosition.y;
        float xt = (float) ((x - x1) * t);
        float yt = (float) ((y - y1) * t);
        xt = x1 + xt;
        yt = y1 + yt;
        unite.unitPosition.x = Math.round(xt);
        unite.unitPosition.y = Math.round(yt);
        int temp = jihad(unite.unitPosition.x, oldX, unite.unitPosition.y, oldY);
        Unite unite1 = (Unite) unite.unitPosition.check1(unite);
        if(unite1==DoDGameManager.mainBase){
            handMovement='s';
            unite.unitPosition.x = oldX;
            unite.unitPosition.y = oldY;
            return "continue";
        }

        double length1, length2;
        if (unite1 == null) {
            previousMove = -1;
            return sort(unite, i, j, temp);
        } else {
            if (startPointX>=unite1.unitPosition.x && startPointX<=unite1.unitPosition.x+unite1.unitProperty.siz
            && startPointY>=unite1.unitPosition.y && startPointX<=unite1.unitPosition.y+unite1.unitProperty.siz)
                handMovement='e';
            if (endPointX>=unite1.unitPosition.x && endPointX<=unite1.unitPosition.x+unite1.unitProperty.siz
                    && endPointY>=unite1.unitPosition.y && endPointY<=unite1.unitPosition.y+unite1.unitProperty.siz)
                handMovement='e';
            String s = alkadi(temp, oldX, oldY, unite1);
            if (s.equals("vertically")) {
                 length1 = Math.abs(y - (unite.unitPosition.y - 1));
                 length2 = Math.abs(y - (unite.unitPosition.y + 1));
                if (length1 < length2 && (previousMove == -1 || previousMove == 1)) {
                    unite.unitPosition.x = oldX;
                    unite.unitPosition.y = oldY - 1;
                    if (unite.unitPosition.check1(unite) != null) {
                        unite.unitPosition.x = oldX;
                        unite.unitPosition.y = oldY + 1;
                        if (unite.unitPosition.check1(unite) != null) {
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
                 length1 = DoDGameManager.mainBase.unitPosition.x - (unite.unitPosition.x - 1);
                 length2 = DoDGameManager.mainBase.unitPosition.x - (unite.unitPosition.x + 1);
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
        }


    }
    }

