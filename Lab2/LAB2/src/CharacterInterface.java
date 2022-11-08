import java.util.ArrayList;

public interface CharacterInterface extends Comparable<Character>{
    //TODO:空缺的装备决定方式
//    void setHeadGear(HeadGear newHeadGear);
//
//    void setHandGear(HandGear newHandGear);
//
//    void setFootwear(Footwear newFootwear);
    void setGear(Gear newGear);
    ArrayList<Gear> getHeadGearList();
    ArrayList<Gear> getHandGearList();
    ArrayList<Gear> getFootWearList();

    int getAttackPoint();
    int getDefensePoint();
    String getName();
//    void assignNewGear(ArrayList<Gear> gearList);

}
