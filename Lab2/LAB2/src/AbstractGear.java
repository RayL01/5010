public abstract class AbstractGear implements Gear{

    protected String gearName;
    protected String gearAdjective;
    protected String gearNoun;
    protected final int attackStrength;
    protected final int defenseStrength;
    public AbstractGear(String Adjective, String noun, int attackValue, int defenseValue) {
        if (Adjective.split(",").length != 1 || noun.split(",").length != 1) throw new IllegalArgumentException("There should be only one adjective and only one noun");
        if (attackValue < 0 || defenseValue < 0 ) throw new IllegalArgumentException("attackStrength or defense Strength should not < 0");
        this.gearAdjective = Adjective;
        this.gearNoun = noun;
        this.gearName = gearAdjective + ", "+ gearNoun;
        this.defenseStrength = defenseValue;
        this.attackStrength = attackValue;
    }
    @Override
    public abstract GearType getGearType();

    @Override
    public String getGearAdjective() {
        return this.gearAdjective;
    }

    @Override
    public String getGearNoun() {
        return this.gearNoun;
    }

    @Override
    public String getGearName() {
        return this.gearName;
    }

    protected abstract Gear combineInternal(String adj, String noun, int attack, int defense);

    @Override
    public Gear combineGear(Gear g) {
        // System.out.println(this.getName())
        //System.out.println(g.getName());
        // System.out.println(this.getType() + "" + g.getType());
        if (this.getType() != g.getType()) throw new IllegalArgumentException("While combining the gear type should be the same");
        // combine the name first then combine the attributes
        String newNoun = this.gearAdjective + " " + this.gearNoun;

        String newAdj = g.getAdjective();

        //System.out.println(newAdj + " " + newNoun);
        int newAttack = this.attackStrength + g.getAttackStrength();
        int newDefense = this.defenseStrength + g.getDefenseStrength();
        return combineInternal(newAdj, newNoun, newAttack, newDefense);
    }

    @Override
    public int getGearAttackStrength() {
        return this.attackStrength;
    }

    @Override
    public int getGearDefenseStrength() {
        return this.defenseStrength;
    }

    @Override
    public int compareTo(Gear o) {
        if (this.getGearAttackStrength() < o.getGearDefenseStrength()){
            return -1;
        } else if(this.getGearAttackStrength() > o.getGearDefenseStrength()){
            return 1;
        } else{
            return Integer.compare(this.getDefenseStrength(), o.getDefenseStrength());
        }
    }
}
