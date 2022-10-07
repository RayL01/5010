import java.util.ArrayList;

public interface Conservatory {
  //assign a new bird to an aviary in the conservatory
  void addBird(Birds birds);

  //Calculate what food needs to be kept and in what quantities
  void calculateFood();

  //Have a guest look up which aviary a bird is in
  Location getAviary(Birds birds);

  //Print a sign for any given aviary that gives a description of the birds it houses,
  // and any interesting information that it may have about that animal.
  void printSign(Aviary aviary);


  //Print a “map” that lists all the aviaries by location and the birds they house
  void printMap();

  //Print an index that lists all birds in the conservatory in alphabetical order
  // and their location
  void printIndex();


  ArrayList<Aviary> getAviaryList();
}
