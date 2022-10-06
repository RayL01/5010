import java.util.ArrayList;

/**
 * Flightless birds live on the ground and have no (or undeveloped) wings.
 * They include the emus, kiwis, and moas.
 * Some (but not all) of these birds are extinct.
 */
public class FlightLessBirds extends AbstractBirds {

    public FlightLessBirds(String name, BIRDTYPE type, ArrayList<String> chara, boolean extinct, ArrayList<FOODS> food) {
        super(name, type, chara, extinct, 0, food);
        super.characteristic.add("live on ground");
        if (type != BIRDTYPE.EMUS && type != BIRDTYPE.KIWIS && type != BIRDTYPE.MOAS) {
            throw new IllegalArgumentException("This type of bird is not Flightless Birds");

        }
    }

    @Override
    public CLASSIFICATION getBirdsCategory() {
        return CLASSIFICATION.FLIGHTLESS_BIRDS;
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




