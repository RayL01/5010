import java.util.ArrayList;

public abstract class AbstractBirds implements Birds{
  protected String birdName;

  protected Birdtype birdType;

  protected ArrayList<String> characteristics;

  protected boolean extinct;

  protected int numWings;

  protected ArrayList<Feed> preferredFood;



  public AbstractBirds(String birdName, Birdtype birdType, boolean extinct, int numWings, ArrayList<Feed> preferredFood){
    if (preferredFood.size() < 2 || preferredFood.size() > 4){
      throw new IllegalArgumentException("Birds' preferred food should in range of 2 to 4 items.");
    }

    if (numWings < 0){
      throw new IllegalArgumentException("Number of wings cannot be smaller than 0.");
    } else if (numWings > 6) {
      throw new IllegalArgumentException("Birds don't have that many wings.");
    }

    this.birdName = birdName;
    this.birdType = birdType;
    this.extinct = extinct;
    this.numWings = numWings;
    this.preferredFood = preferredFood;

  }

  public String getBirdName() {
    return birdName;
  }

  public Birdtype getBirdType() {
    return birdType;
  }

  public ArrayList<String> getCharacteristics() {
    return characteristics;
  }

  public boolean isExtinct() {
    return extinct;
  }

  public int getNumWings() {
    return numWings;
  }

  public ArrayList<Feed> getPreferredFood() {
    return preferredFood;
  }

  public abstract Classification getBirdsClass();

  public void setBirdName(String birdName) {
    this.birdName = birdName;
  }

  public void setBirdType(Birdtype birdType) {
    this.birdType = birdType;
  }

  public void setCharacteristics(ArrayList<String> characteristics) {
    this.characteristics = characteristics;
  }

  public void setExtinct(boolean extinct) {
    this.extinct = extinct;
  }

  public void setNumWings(int numWings) {
    this.numWings = numWings;
  }

  public void setPreferredFood(ArrayList<Feed> preferredFood) {
    this.preferredFood = preferredFood;
  }

  @Override
  public String toString() {
    String desc;
    String extinct;
    if (isExtinct()){
      extinct = "Yes ";
    } else {
      extinct = "No ";
    }
    desc = " Bird Name:" + this.birdName + "\n" +
            " Bird Type: " + this.birdType + "\n" +
            " Characteristics: " + this.characteristics + "\n" +
            " Extinction: " + extinct + "\n" +
            " Number of Wings: " + "\n" +
            " Preferred Food: " + this.preferredFood + "\n";

    return desc;
  }
}
