import java.util.ArrayList;

public class Owls extends AbstractBirds{

  public Owls(String birdName, Birdtype birdType, boolean extinct, int numWings, ArrayList<Feed> preferredFood) {
    super(birdName, birdType, extinct, numWings, preferredFood);
    characteristics = new ArrayList<>();
    characteristics.add("Owls are distinguished by the facial disks that frame the eyes and bill. ");

    if(birdType != Birdtype.OWLS){
      throw new IllegalArgumentException("The bird type has to be Owls");
    }
  }

  @Override
  public Classification getBirdsClass() {
    return Classification.OWLS;
  }

  @Override
  public String toString() {
    return super.toString()+" Waterbird: No \n";
  }
}
