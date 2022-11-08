public class Footwear extends AbstractGear{

    public Footwear(String Adjective, String noun, int attackValue, int defenseValue) {
        super(Adjective, noun, attackValue, defenseValue);
    }


    @Override
    public GEAR_TYPE getType() {
        return GEAR_TYPE.FOOTWEAR;
    }



    @Override
    protected Gear combineInternal(String adj, String noun, int attack, int defense) {
        //System.out.println(adj + " " + noun);
        return new Footwear(adj, noun, attack, defense);
    }

    @Override
    public String toString() {
        return  "Type: " + this.getType() + " "+
                "name='" + name + '\'' +
                ", attackStrength=" + attackStrength +
                ", defenseStrength=" + defenseStrength;
    }
}
