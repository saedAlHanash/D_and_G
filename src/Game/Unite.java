package Game;

import Game.AllUnites.BlackEagle;
import Game.AllUnites.MainBais;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public abstract class Unite implements Comparable<Unite>, Grid, AttackStrategy, UnitDestroy, Serializable {
    public static  int Id=1;
    public UnitProperty unitProperty = new UnitProperty();
    public CheckAndSet checkAndSet = new CheckAndSet();
    public UnitPosition unitPosition = new UnitPosition();
    AttackStrategy attackStrategy;
    AttackResult attackResult = new AttackResult();
    public Player owner;
    Object targetUnite;
    public String typesCanAttack;
    public  Movement movement;
    public  String nameType;


    // constrictor for create elements
    public Unite( int ID,int x,int y,String type, int health, float armor, int attack, int rang, float attackFrequency, int siz, int speed, String typesCanAttack
            , AttackStrategy attackStrategy, Player owner) {

        this.unitProperty.ID=ID;
        this.unitProperty.type = type;
        this.unitProperty.speedMain = speed;
        this.unitProperty.speed= speed;
        this.unitProperty.health = health;
        this.unitProperty.attack = attack;
        this.unitProperty.attackFrequency = attackFrequency;
        this.unitProperty.siz = siz;
        this.unitProperty.rang = rang;
        this.attackStrategy = attackStrategy;
        this.owner = owner;
        this.typesCanAttack = typesCanAttack;
        this.unitProperty.reLode = this.unitProperty.attackFrequency;
        this.unitProperty.armor = armor;
//        Random random = new Random();
//        while (!unitPosition.checkAvailable(this)) {
//            unitPosition.x = random.nextInt(owner.squareX + 100) + owner.squareX;
//            unitPosition.y = random.nextInt(owner.squareY + 100) +owner.squareY;
//        }
        unitPosition.x=x;
        unitPosition.y=y;
        if (this instanceof MainBais)
            movement=null;
        else if (owner.teamID==0)
            movement=new AttackerMovement();
        else
            movement=new DefenderMovement(this.unitPosition.x,this.unitPosition.y,DoDGameManager.mainBase.unitPosition.x,DoDGameManager.mainBase.unitPosition.y);

        if (unitProperty.speed==0)
            unitProperty.reLodeSpeed=0;
        else
            unitProperty.reLodeSpeed=1000/unitProperty.speed;
        unitProperty.visit=false;
    }

    private void acceptDamage(int damage) {
        this.unitProperty.health -= damage;
    }

    @Override
    public int compareTo(Unite unite) {
        return this.unitPosition.y - unite.unitPosition.y;
    }

    public String PrintTargetUnite()
    {
        if(targetUnite!=null)
         return "it attack : <<"+((Unite)targetUnite).unitProperty.ID+">>";
        return "";
    }
    @Override
    public String toString() {
        return this.unitPosition+" <"+this.unitProperty.ID+"> "+this.nameType+"  helth :" + this.unitProperty.health+"  "+
                PrintTargetUnite() +"   "+ unitProperty.reLodeSpeed
                ;
    }

    @Override
    public Object PrioritizeUnitToAttack(ArrayList<Object> units, Unite d) {
        return null;
    }

    public void attack() {
        if (this.unitProperty.reLode < this.unitProperty.attackFrequency)
        {

            if (this.unitProperty.health <= 0) {
                if (this.owner.teamID == 0) {
                    DoDGameManager.remainingAttackerUnits -= 1;
                }
                destroyUnite(this);
            }
            return;
        }


        targetUnite = attackResult.target(this);
        if (targetUnite == null){
            if (this.unitProperty.health <= 0) {
                if (this.owner.teamID == 0) {
                    DoDGameManager.remainingAttackerUnits -= 1;
                }
                destroyUnite(this);
            }
            return;
        }
        if (targetUnite instanceof Unite) {
            ((Unite) targetUnite).acceptDamage(this.unitProperty.attack);
            if (this instanceof BlackEagle)
                this.unitProperty.reLode =-1;
            else
                this.unitProperty.reLode = 0;

            if (this.unitProperty.health <= 0) {
                if (this.owner.teamID == 0) {
                    DoDGameManager.remainingAttackerUnits -= 1;
                }
                destroyUnite(this);
            }
        }
        else {
            ((Valley)targetUnite).listBridge.get(0).health-=this.unitProperty.attack;
            if(((Valley)targetUnite).listBridge.get(0).health==0)
            {
                ((Valley)targetUnite).listBridge.clear();
            }
        }
    }

    @Override
    public void destroyUnite(Unite uniteToDestroy) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                if (list.get(i).get(j) == uniteToDestroy) {
                    if (list.get(i).size() > 1) {
                        list.get(i).remove(j);
                        return;
                    } else
                        list.remove(i);
                    return;
                }
            }
        }
    }

    public class CheckAndSet implements Serializable {
        //اضافة عنصر
        public void add(Unite unite) {
            boolean test = true;
            if (list.isEmpty()) {
                list.add(new ArrayList<>());
                list.get(0).add(unite);
            } else {
                if (unitPosition.checkAvailable(unite)) {
                    for (int i = 0; i < list.size(); i++) {
                        if (!(list.get(i).isEmpty()))
                            if (list.get(i).get(0).unitPosition.x == unite.unitPosition.x) {
                                list.get(i).add(unite);
                                Collections.sort(list.get(i));
                                return;
                            } else if (list.get(i).get(0).unitPosition.x > unite.unitPosition.x) {
                                list.add(i, new ArrayList<>());
                                list.get(i).add(unite);
                                return;
                            }
                    }
                    list.add(new ArrayList<>());
                    list.get(list.size() - 1).add(unite);
                }
            }
        }
    }
}





























/*        public ArrayList<Unite> checkRange(Unite unite) {
            ArrayList<Unite> rangeList = new ArrayList<>();
            int xRange = unite.unitPosition.x - unite.unitProperty.rang;
            int limeXRange = unite.unitPosition.x + unite.unitProperty.siz + unite.unitProperty.rang;
            int yRange = unite.unitPosition.y - unite.unitProperty.rang;
            int limeYRange = unite.unitPosition.y + unite.unitProperty.siz + unite.unitProperty.rang;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).get(0).unitPosition.x > limeXRange) {
                    return rangeList;
                }
                if (list.get(i).get(0).unitPosition.x <= xRange && (list.get(i).get(0).unitPosition.x + list.get(i).get(0).unitProperty.siz) > xRange ||
                        list.get(i).get(0).unitPosition.x > xRange && list.get(i).get(0).unitPosition.x <= limeXRange) {
                    for (int j = 0; j < list.get(i).size(); j++) {
                        if (list.get(i).get(0).unitPosition.y > limeYRange)
                            break;
                        if (list.get(i).get(j) != unite)
                            if (list.get(i).get(j).unitPosition.y <= yRange && (list.get(i).get(j).unitPosition.y + list.get(i).get(j).unitProperty.siz) > yRange ||
                                    list.get(i).get(j).unitPosition.y > yRange && list.get(i).get(j).unitPosition.y <= limeYRange) {
                                if (list.get(i).get(j).unitProperty.health > 0)
                                    rangeList.add(list.get(i).get(j));
                            }
                    }
                }
            }
            return rangeList;
        }*/
/*        // تابع يفحص المجال ويرد Set<>
        public Set<Unite> checkRange1(Unite unite) {
            Set<Unite> rangeList = new HashSet<>();
            int xRange = unite.unitPosition.x - unite.unitProperty.rang;
            int limeXRange = unite.unitPosition.x + unite.unitProperty.siz + unite.unitProperty.rang;
            int yRange = unite.unitPosition.y - unite.unitProperty.rang;
            int limeYRange = unite.unitPosition.y + unite.unitProperty.siz + unite.unitProperty.rang;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).get(0).unitPosition.x > limeXRange) {
                    return rangeList;
                }
                if (list.get(i).get(0).unitPosition.x <= xRange && (list.get(i).get(0).unitPosition.x + list.get(i).get(0).unitProperty.siz) > xRange ||
                        list.get(i).get(0).unitPosition.x > xRange && list.get(i).get(0).unitPosition.x <= limeXRange) {
                    for (int j = 0; j < list.get(i).size(); j++) {
                        if (list.get(i).get(0).unitPosition.y > limeYRange)
                            break;
                        if (list.get(i).get(j) != unite)
                            if (list.get(i).get(j).unitPosition.y <= yRange && (list.get(i).get(j).unitPosition.y + list.get(i).get(j).unitProperty.siz) > yRange ||
                                    list.get(i).get(j).unitPosition.y > yRange && list.get(i).get(j).unitPosition.y <= limeYRange) {
                                if (list.get(i).get(j).unitProperty.health > 0)
                                    rangeList.add(list.get(i).get(j));
                            }
                    }
                }
            }
            return rangeList;
        }*/




/*// تابع (تجريبي ) يرد Arraylist يفحص المجال
        public ArrayList<Unite> checkRange(Unite unite) {
            ArrayList<Unite> rangeList = new ArrayList<>();
            int xRange = unite.unitPosition.x - unite.rang;
            int limeXRange = unite.unitPosition.x + unite.siz + unite.rang;
            int yRange = unite.unitPosition.y - unite.rang;
            int limeYRange = unite.unitPosition.y + unite.siz + unite.rang;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).get(0).unitPosition.x > limeXRange) {
                    return rangeList;
                }
                if (list.get(i).get(0).unitPosition.x <= xRange && (list.get(i).get(0).unitPosition.x + list.get(i).get(0).siz) > xRange ||
                        list.get(i).get(0).unitPosition.x > xRange && list.get(i).get(0).unitPosition.x <= limeXRange) {
                    for (int j = 0; j < list.get(i).size(); j++) {
                        if (list.get(i).get(0).unitPosition.y > limeYRange)
                            break;
                        if (list.get(i).get(j) != unite)
                            if (list.get(i).get(j).unitPosition.y <= yRange && (list.get(i).get(j).unitPosition.y + list.get(i).get(j).siz) > yRange ||
                                    list.get(i).get(j).unitPosition.y > yRange && list.get(i).get(j).unitPosition.y <= limeYRange) {
                                if (list.get(i).get(j).health > 0)
                                    rangeList.add(list.get(i).get(j));
                            }
                    }
                }
            }
            return rangeList;
        }*/






/*    public void attack1() {
        Unite unite, unite1 = null;
        System.out.println(checkAndSet.checkRange(this));
        unite = attackStrategy.PrioritizeUnitToAttack(checkAndSet.checkRange(this));
        if (unite != null)
            unite1 = unite.attackStrategy.PrioritizeUnitToAttack(checkAndSet.checkRange(unite));
        System.out.println(checkAndSet.checkRange(unite));
        if (unite1 == this) {
            this.unitProperty.health -= unite.unitProperty.attack;
        }
        unite.unitProperty.health-=this.unitProperty.attack;
    }*/























/*
    public void attack() {
        int target = 0;
        ArrayList<Unite> saed = new ArrayList<>(checkAndSet.checkRange1(this));
        if (saed.size() >= 1)
            target = random.nextInt(saed.size());
        System.out.println(saed.size());
        System.out.println(target);
        if (!saed.isEmpty()) {
            Set<Unite> targetRange = checkAndSet.checkRange1(saed.get(target));
            int sizTargetRange = targetRange.size();
            targetRange.add(this);
            if (sizTargetRange == targetRange.size()) {
                this.unitProperty.health -= saed.get(target).unitProperty.attack;
            }
            saed.get(target).unitProperty.health -= this.unitProperty.attack;
        }
    }
*/
