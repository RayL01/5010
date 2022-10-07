import java.util.ArrayList;

public class Shorebirds extends AbstractWaterBirds{



  public Shorebirds(String birdName, Birdtype birdType, boolean extinct, int numWings, ArrayList<Feed> preferredFood, ArrayList<BodyOfWater> bodyOfWaterArrayList) {
    super(birdName, birdType, extinct, numWings, preferredFood, bodyOfWaterArrayList);
    characteristics = new ArrayList<>();
    characteristics.add("Shorebirds live near water sources including wetlands, freshwater and saltwater shorelands, or ocean.");

    for(BodyOfWater water: bodyOfWaterArrayList){
      if (water != BodyOfWater.WETLANDS && water != BodyOfWater.OCEAN &&
              water != BodyOfWater.FRESHWATER_SHORELANDS && water != BodyOfWater.SALTWATER_SHORELANDS){
        throw new IllegalArgumentException("Shorebirds be in either wetlands, freshwater and saltwater shorelands, or ocean");
      }
    }

    if(birdType != Birdtype.GREAT_AUK && birdType != Birdtype.HORNED_PUFFIN && birdType != Birdtype.AFRICAN_JACANA){
      throw new IllegalArgumentException("Shorebirds include Great Auk, Horned puffin, and African Jacana.");
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
