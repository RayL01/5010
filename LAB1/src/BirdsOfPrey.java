import java.util.ArrayList;

public class BirdsOfPrey extends AbstractBirds {

    public BirdsOfPrey(String name, BIRDTYPE type, ArrayList<String> chara, boolean extinct, int wingNum, ArrayList<FOODS> food) {
        super(name, type, chara, extinct, wingNum, food);
        super.characteristic.add("sharp, hooked beaks with visible nostrils");
        if (type != BIRDTYPE.HAWKS && type != BIRDTYPE.EAGLES && type != BIRDTYPE.OSPREY) {
            throw new IllegalArgumentException("This type of bird is not BirdsOfPrey");
        }
    }

    @Override
    public CLASSIFICATION getBirdsCategory() {
        return CLASSIFICATION.BIRDS_OF_PREY;
    }
    @Override
    public String toString() {
        return "Name: " + super.name + " Classification: " +
            this.getBirdsCategory() + " Type: " + super.getType() + "\n" + " Extinction Status: " +
            super.extinct + " Number of Wings: " + super.wingNumber + "\n" +
            " Characteristics: " + super.characteristic + "\n" +
            " Food it eats: " + super.getPreferFood();
    }
}
