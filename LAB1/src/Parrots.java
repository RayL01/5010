import java.util.ArrayList;
import java.util.List;

public class Parrots extends AbstractBirds{

    private int vocabulary;
    private String favoriteSaying;

    /**
    public void setVocabulary(int vocabulary) {
        this.vocabulary = vocabulary;
    }
     **/

    public Parrots(String name, BIRDTYPE type, String favoriteSaying, int vocabulary, ArrayList<String> chara, boolean extinct, int wingNum, ArrayList<FOODS> food) {

        super(name, type, chara, extinct, wingNum, food);

        if (vocabulary > 100 || vocabulary < 0) {
            throw new IllegalArgumentException("Parrots can only learn 0 - 100 numbers' Vocabulary.");
        }
        this.vocabulary = vocabulary;
        this.favoriteSaying = favoriteSaying;
        super.characteristic.addAll(List.of(new String[]{"short, curved beak", "intelligence and ability to mimic sounds"}));
        if (type != BIRDTYPE.ROSERINGPARAKEET && type != BIRDTYPE.GRAYPARROT && type != BIRDTYPE.SULFURCRESTEDCOCKATOO) {
            throw new IllegalArgumentException("This type of bird is not Parrot");

        }
    }

    @Override
    public CLASSIFICATION getBirdsCategory() {
        return CLASSIFICATION.PARROTS;
    }

    @Override
    public String toString() {
        return "Name: " + super.name + " Classification: " +
            this.getBirdsCategory() + " Type: " + super.getType() + "\n" + " Extinction Status: " +
            super.extinct + " Number of Wings: " + super.wingNumber + "\n" +
            " Characteristics: " + super.characteristic + "\n" +
            " Food it eats: " + super.getPreferFood() +
            "vocabulary=" + vocabulary +
            ", favoriteSaying='" + favoriteSaying + '\'' +
            '}';
    }

    public int getNumberOfWord(){
        return this.vocabulary;
    }

    public String getFavoriteSaying(){
        return this.favoriteSaying;
    }


}
