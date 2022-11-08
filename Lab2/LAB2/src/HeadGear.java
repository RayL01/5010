public class HeadGear extends AbstractGear{
    public HeadGear(String Adjective, String noun, int defenseValue) {
        super(Adjective, noun, 0, defenseValue);
    }
    @Override
    public GEAR_TYPE getType() {
        return GEAR_TYPE.HEAD_GEAR;
    }


    @Override
    protected Gear combineInternal(String adj, String noun, int attack, int defense) {
        //System.out.println(adj + " " + noun);
        return new HeadGear(adj, noun, defense);
    }

    @Override
    public String toString() {
        return "Type: " + this.getType() + " "+
                "name='" + name + '\'' +
                ", attackStrength=" + attackStrength +
                ", defenseStrength=" + defenseStrength;
    }


}
