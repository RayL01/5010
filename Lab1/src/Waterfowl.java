import java.util.ArrayList;

public class Waterfowl extends AbstractWaterBirds{


  public Waterfowl(String birdName, Birdtype birdType, boolean extinct, int numWings, ArrayList<Feed> preferredFood, ArrayList<BodyOfWater> bodyOfWaterArrayList) {
    super(birdName, birdType, extinct, numWings, preferredFood, bodyOfWaterArrayList);
    characteristics = new ArrayList<>();
    characteristics.add("Waterfowls live near water sources.");

    for(BodyOfWater water: bodyOfWaterArrayList){
      if (water != BodyOfWater.FRESH && water != BodyOfWater.SALT){
        throw new IllegalArgumentException("Waterfowls be in either fresh or salt water sources");
      }
    }

    if(birdType != Birdtype.DUCKS && birdType != Birdtype.SWANS && birdType != Birdtype.GEESE){
      throw new IllegalArgumentException("Waterfowls include ducks, swans, and geese.");
    }
  }

  @Override
  public Classification getBirdsClass() {
    return Classification.SHOREBIRDS;
  }

  @Override
  public String toString() {
    return super.toString();
  }
}
