import java.util.ArrayList;

public abstract class AbstractWaterBirds extends AbstractBirds {

    protected ArrayList<WATER> bodyOfWater;
    public AbstractWaterBirds(String name, BIRDTYPE type, ArrayList<String> chara, boolean extinct, int wingNum, ArrayList<FOODS> food, ArrayList<WATER> waters) {
        super(name, type, chara, extinct, wingNum, food);
        bodyOfWater = waters;
    }

    @Override
    public abstract CLASSIFICATION getBirdsCategory();

    public ArrayList<WATER> getWaterLiveBy(){
        return this.bodyOfWater;
    }
}
