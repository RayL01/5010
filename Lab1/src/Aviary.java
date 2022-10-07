import java.util.ArrayList;

public interface Aviary {
  int getSize();//return the current size of the aviary
  void addBird(Birds bird);
  Location getLocation();//return the location of the aviary
  Birds getBird();//return the first bird in the aviary
  String getListofBirdByName();//get the bird list by their name

  /*
  return the bird arraylist in the aviary, used for test cases
   */
  ArrayList<Birds> getBirdArray();




}
