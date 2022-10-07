import java.util.ArrayList;

public class FlightLess extends AbstractBirds {

  public FlightLess(String birdName, Birdtype birdType, boolean extinct, int numWings, ArrayList<Feed> preferredFood) {
    super(birdName, birdType, extinct, numWings, preferredFood);
    characteristics = new ArrayList<>();
    characteristics.add("Flightless Birds live on the ground and have no (or undeveloped) wings.");

    if(birdType != Birdtype.EMUS && birdType != Birdtype.KIWIS && birdType != Birdtype.MOAS){
      throw new IllegalArgumentException("Flightless birds include emus, kiwis, and moas.");
    }
  }

  @Override
  public Classification getBirdsClass() {
    return Classification.FLIGHTLESS;
  }

  @Override
  public String toString() {
    return super.toString()+" Waterbird: No \n";
  }
}




