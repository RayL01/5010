import java.util.ArrayList;

public class Parrots extends AbstractBirds{
  private int numOfWords;
  private String favoritePhrase;

  public Parrots(String birdName, Birdtype birdType, int numOfWords, String favoritePhrase, boolean extinct, int numWings, ArrayList<Feed> preferredFood) {
    super(birdName, birdType, extinct, numWings, preferredFood);
    characteristics = new ArrayList<>();
    characteristics.add("Short, curved beak and are known for their intelligence and ability to mimic sounds.");

    if ( 0 > numOfWords ||  numOfWords > 100) {
      throw new IllegalArgumentException("Pet parrots can learn a vocabulary  of up to 100 words. ");
    }
    this.numOfWords = numOfWords;
    this.favoritePhrase = favoritePhrase;
    if(birdType != Birdtype.ROSE_RING_PARAKEET && birdType != Birdtype.GRAY_PARROT && birdType != Birdtype.SULFUR_CRESTED_COCKATOO){
      throw new IllegalArgumentException("Parrots include Rose-Ring Parakeet, Gray Parrot, and Sulfur-crested cockatoo.");
    }
  }

  public int getNumberOfWord(){
    return this.numOfWords;
  }

  public String getFavoritePhrase(){
    return this.favoritePhrase;
  }

  @Override
  public Classification getBirdsClass() {
    return Classification.PARROTS;
  }

  @Override
  public String toString() {
    return super.toString()+" Waterbird: No \n" +
            " Number of Words: " + this.numOfWords + "\n" +
            " Favorite Phrase: " + this.favoritePhrase + "\n";
  }
}
