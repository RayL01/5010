import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BirdsOfPrey extends AbstractBirds {

  public BirdsOfPrey(String birdName, Birdtype birdType, boolean extinct, int numWings, ArrayList<Feed> preferredFood){
    super(birdName, birdType,  extinct, numWings, preferredFood);
    characteristics = new ArrayList<>();
    characteristics.add("Sharp, Hooked Beak with Visible Nostrils.");

    if(birdType != Birdtype.HAWKS && birdType != Birdtype.EAGLES && birdType != Birdtype.OSPREY){
      throw new IllegalArgumentException("Birds of prey include Hawks, Eagles, and Osprey");
    }
  }

  @Override
  public Classification getBirdsClass() {
    return Classification.BIRDS_OF_PREY;
  }

  @Override
  public String toString(){
    return super.toString()+" Waterbird: No \n";
  }
}
