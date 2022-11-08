import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Character implements CharacterInterface{

    private int attackPoint;
    private int defensePoint;
    private final String name;
    private final ArrayList<Gear> headGear;

    private final static int HEAD_CAP = 1;

    private final static int HAND_CAP = 2;

    private final static int FOOT_CAP = 2;


    private final ArrayList<Gear> handGear;
    private final ArrayList<Gear> footGear;


    public CharacterImpl(int attackPoint, int defensePoint, String name) {
        if (attackPoint < 0) throw new IllegalArgumentException("Attack point cannot be negative.");
        if (defensePoint < 0) throw new IllegalArgumentException("Defense point cannot be negative.");
        this.attackPoint = attackPoint;
        this.defensePoint = defensePoint;
        this.name = name;

        headGear = new ArrayList<Gear>(HEAD_CAP);
        handGear = new ArrayList<Gear>(HAND_CAP);
        footGear = new ArrayList<Gear>(FOOT_CAP);
    }



//    @Override
//    public void setGear(Gear newGear) {
//        if (newGear.getType() == GEAR_TYPE.HEAD_GEAR){
//            defensePoint += newGear.getDefenseStrength();
//            if (headGear.size() == 1){
//                Gear tmpGear = this.headGear.get(0);
//                tmpGear.combine(newGear);
//            }
//            else {
//                headGear.add(newGear);
//            }
//        } else if (newGear.getType() == GEAR_TYPE.HAND_GEAR) {
//            attackPoint += newGear.getAttackStrength();
//            if (handGear.size() == 2){
//                Random random = new Random();
//                int randIndex = random.nextInt(2);
//                Gear tmpGear = this.handGear.get(randIndex);
//                tmpGear.combine(newGear);
//            }
//            else {
//                handGear.add(newGear);
//            }
//
//
//        }else {
//            attackPoint += newGear.getAttackStrength();
//            defensePoint += newGear.getDefenseStrength();
//            if (footGear.size() == 2){
//                Random random = new Random();
//                int randIndex = random.nextInt(2);
//                Gear tmpGear = this.footGear.get(randIndex);
//                tmpGear.combine(newGear);
//            }
//            else {
//                footGear.add(newGear);
//            }
//        }
//    }
    @Override
    public void setGear(Gear newGear) {
        if (newGear.getType() == GEAR_TYPE.HEAD_GEAR) {
            defensePoint += newGear.getDefenseStrength();
            if (headGear.size() == CharacterImpl.HEAD_CAP) {
                Gear tmpGear = this.headGear.get(0);
                Gear gear = tmpGear.combine(newGear);
                this.headGear.set(0, gear);
            } else {
                headGear.add(newGear);
            }
        } else if (newGear.getType() == GEAR_TYPE.HAND_GEAR) {
            attackPoint += newGear.getAttackStrength();
            if (handGear.size() == CharacterImpl.HAND_CAP) {
                Random random = new Random();
                int randIndex = random.nextInt(2);
                Gear tmpGear = this.handGear.get(randIndex);
                Gear gear = tmpGear.combine(newGear);
                this.handGear.set(randIndex, gear);

            } else {
                handGear.add(newGear);
            }


        } else {
            attackPoint += newGear.getAttackStrength();
            defensePoint += newGear.getDefenseStrength();
            if (footGear.size() == CharacterImpl.FOOT_CAP) {
                Random random = new Random();
                int randIndex = random.nextInt(2);
                Gear tmpGear = this.footGear.get(randIndex);
                Gear gear = tmpGear.combine(newGear);
                this.footGear.set(randIndex, gear);
            } else {
                footGear.add(newGear);
            }
        }
    }





    @Override
    public ArrayList<Gear> getHeadGearList() {
        return headGear;
    }

    @Override
    public ArrayList<Gear> getHandGearList() {
        return handGear;
    }

    @Override
    public ArrayList<Gear> getFootWearList() {
        return footGear;
    }

    @Override
    public int getAttackPoint() {
        return attackPoint;
    }

    @Override
    public int getDefensePoint() {
        return defensePoint;
    }

    @Override
    public String getName() {
        return name;
    }


    @Override
    public int compareTo(Character o) {
        int thisRes = o.getAttackPoint() - defensePoint;
        int otherRes = attackPoint - o.getDefensePoint();
        if (thisRes < otherRes){
            //System.out.println(name + " win!");
            return 1;
        } else if (thisRes > otherRes) {
            //System.out.println(o.getName() + " win!");
            return -1;
        }else{
            //System.out.println("There is a tie.");
            return 0;
        }
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                "attackPoint=" + attackPoint +
                ", defensePoint=" + defensePoint +
                ", headGear=" + headGear +
                ", handGear=" + handGear +
                ", footGear=" + footGear;
    }
}
