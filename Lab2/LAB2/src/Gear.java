public interface Gear extends Comparable<Gear> {
    GearType getGearType();
    String getGearName();
    String getGearAdjective();
    String getGearNoun();
    Gear combineGear(Gear g);
    int getGearAttackStrength();
    int getGearDefenseStrength();
}
