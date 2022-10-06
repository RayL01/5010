import java.util.ArrayList;
//　TODO: 把所有 class的　tostring给写了
public abstract class AbstractBirds implements Bird {

    protected ArrayList<String> characteristic;
    protected final boolean extinct;
    protected final int wingNumber;
    protected ArrayList<FOODS> preferredFood;

    protected BIRDTYPE type;

    protected String name;

    public AbstractBirds(String name, BIRDTYPE type, ArrayList<String> chara, boolean extinct, int wingNum, ArrayList<FOODS> food){
        if (wingNum < 0){
            throw new IllegalArgumentException("The wingNum should larger than 0");
        }

        if (food.size() > 4 || food.size() < 2 ){
            throw new IllegalArgumentException("The number of food they prefer to eat should be 2 - 4");
        }
        this.name = name;
        this.preferredFood = new ArrayList<>(food);
        this.characteristic = new ArrayList<>(chara);
        this.extinct = extinct;
        this.wingNumber = wingNum;
        this.type = type;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public BIRDTYPE getType(){
        return this.type;
    }

    @Override
    public ArrayList<String> getCharacteristic() {
        return this.characteristic;
    }

    @Override
    public boolean getExtinct() {
        return this.extinct;
    }

    @Override
    public int getWingNum() {
        return this.wingNumber;
    }
    @Override
    public ArrayList<FOODS> getPreferFood() {
        return this.preferredFood;
    }

    @Override
    public abstract CLASSIFICATION getBirdsCategory();

}
