import java.util.ArrayList;

public class Aviaries implements Aviary {
  private ArrayList<Birds> ListOfBirds;

  private Location aviaryLocation;




  public Aviaries(Location aviaryLocation) {
    ListOfBirds = new ArrayList<>();
    this.aviaryLocation = aviaryLocation;//only initialize the location of aviary with the constructor
  }

  @Override
  public ArrayList<Birds> getBirdArray() {
    return ListOfBirds;
  }

  @Override
  public String getListofBirdByName() {
    String s = "";
    if (ListOfBirds.size() == 0){
      s += "No birds in the house";
    } else {
      for(Birds birds: ListOfBirds){
        s += birds.getBirdName() + " | ";
      }
    }
    return s;
  }

  public Birds getBird(){//return the first bird in the Birdlist
    return ListOfBirds.get(0);
  }


  @Override
  public int getSize() {//return the number of birds in the current aviary
    return ListOfBirds.size();
  }

  @Override
  public void addBird(Birds bird) {//add a new bird to the aviary
    ListOfBirds.add(bird);
  }

  @Override
  public Location getLocation() {
    return this.aviaryLocation;
  }



  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Aviary: ").append(getLocation()).append("\n");
    for(Birds birds: this.ListOfBirds){
      stringBuilder.append(birds).append("\n");
    }
    return stringBuilder.toString();
  }
}




