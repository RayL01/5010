import java.util.ArrayList;

public interface Conservatory {

    // assign a new bird in conservatory
    void addBirds(Bird bird);

    void printFoodQuantityList();
    // have a guest look up which aviary a bird is in
    LOCATION getAviaryOfBird(Bird bird);

    // print the sign for any given aviary that gives a description
    // of the birds it houses and any interesting information that it may have about that animal
    void printSignOfAviary(Aviary aviary);

    //print a map that lists all the aviaries by location and the birds they house
    void printMap();
    // print an index that lists all birds in alphabetical order and their location
    void printBirdIndex();

    ArrayList<Aviary> getAviaryList();
}
