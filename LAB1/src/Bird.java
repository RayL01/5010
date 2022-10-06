import java.util.ArrayList;
// This Bird interface represents the attributes a bird must have
// Birds are comprable
public interface Bird{

    // Get the type of the bird
    BIRDTYPE getType();
    String getName();
    // Get defining characteristic
    ArrayList<String> getCharacteristic();
    // Get defining extinct
    boolean getExtinct();
    // Get the number of wings
    int getWingNum();
    // 2-4 items bird prefer to eat
    ArrayList<FOODS> getPreferFood();
    CLASSIFICATION getBirdsCategory();
}
