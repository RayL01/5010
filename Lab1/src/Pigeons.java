import java.util.ArrayList;

public class Pigeons extends AbstractBirds{

  public Pigeons(String birdName, Birdtype birdType, boolean extinct, int numWings, ArrayList<Feed> preferredFood) {
    super(birdName, birdType, extinct, numWings, preferredFood);
    characteristics = new ArrayList<>();
    characteristics.add("Pigeons feeding their young 'bird milk' very similar to the milk of mammals ");

    if(birdType != Birdtype.PIGEONS && birdType != Birdtype.DOVES && birdType != Birdtype.EXTINCT_PIGEONS){
      throw new IllegalArgumentException("The bird type has to either pigeons, doves, or extincted pigeons");
    }
  }

  @Override
  public Classification getBirdsClass() {
    return Classification.PIGEONS;
  }

  @Override
  public String toString() {
    return super.toString()+" Waterbird: No \n";
  }
}
