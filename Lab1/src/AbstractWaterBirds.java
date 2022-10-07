import java.util.ArrayList;

public abstract class AbstractWaterBirds extends AbstractBirds {
  ArrayList<BodyOfWater> bodyOfWaterArrayList;

  public AbstractWaterBirds(String birdName, Birdtype birdType, boolean extinct, int numWings, ArrayList<Feed> preferredFood, ArrayList<BodyOfWater> waterArrayList) {
    super(birdName, birdType, extinct, numWings, preferredFood);
    bodyOfWaterArrayList = waterArrayList;
  }

  @Override
  public String toString() {
    return super.toString() + " Waterbird: Yes" + "\n" + " Body of water: " + bodyOfWaterArrayList;

  }
}

