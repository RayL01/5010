public class HandGear extends AbstractGear {
    public HandGear(String Adjective, String noun, int attackValue) {
        super(Adjective, noun, attackValue, 0);
    }
    @Override
    public GEAR_TYPE getType() {
        return GEAR_TYPE.HAND_GEAR;
    }

    @Override
    protected Gear combineInternal(String adj, String noun, int attack, int defense) {
        //System.out.println(adj + " " + noun);
        return new HandGear(adj, noun, attack);
    }


    @Override
    public String toString() {
        return "Type: " + this.getType() + " "+
                "name='" + name + '\'' +
                ", attackStrength=" + attackStrength +
                ", defenseStrength=" + defenseStrength;
    }
}
