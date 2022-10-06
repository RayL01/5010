import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
// TODO: interface
public class Conservatories implements Conservatory {

    // location to aviary
    private HashMap<LOCATION, Aviary> locToAviary;
    // aviary to location
    //private HashMap<Integer, Aviary> aviaryToLoc

    // map the food type and its required quantities
    private HashMap<FOODS, Integer> foodQuantities;

    private final int capacity = 20;
    //private ArrayList<Aviary> aviaryList;
    // map the bird
    private HashMap<Bird, Aviary> birdDictionary;

    private ArrayList<Aviary> aviaryList;
    private LOCATION[] locationList;



    public Conservatories() {
        locToAviary = new HashMap<>();
        foodQuantities = new HashMap<>();
        birdDictionary = new HashMap<>();
        // initialize the food quantities map
        locationList = LOCATION.values();
        aviaryList = new ArrayList<>();

        for(FOODS foods : FOODS.values()){
            foodQuantities.put(foods, 0);
        }
    }

    // assign a new bird to the Conservatory, simultaneously update the food quantities
    // map the bird and aviary
    @Override
    public void addBirds(Bird bird){

        // if it's already extinct, we cannot add to the aviary
        if (bird.getExtinct()) {
            return;
        }

        for (LOCATION position: locToAviary.keySet()){
            Aviary currAviary = locToAviary.get(position);
            if (currAviary.getSize() < 5){
                if (bird.getBirdsCategory() == CLASSIFICATION.BIRDS_OF_PREY){
                    if (currAviary.getAviaryType() == AVIARYTYPE.BIRDS_OF_PREY) {
                        currAviary.putNewBird(bird);
                        birdDictionary.put(bird, currAviary);
                    }

                } else if (bird.getBirdsCategory() == CLASSIFICATION.FLIGHTLESS_BIRDS){
                    if (currAviary.getAviaryType() == AVIARYTYPE.FLIGHTLESS_BIRDS) {
                        currAviary.putNewBird(bird);
                        birdDictionary.put(bird, currAviary);
                    }


                } else if (bird.getBirdsCategory() == CLASSIFICATION.WATERFOWL){
                    if (currAviary.getAviaryType() == AVIARYTYPE.WATERFOWL) {
                        currAviary.putNewBird(bird);
                        birdDictionary.put(bird, currAviary);
                    }

                }else{
                    if (currAviary.getAviaryType() == AVIARYTYPE.OTHER) {
                        currAviary.putNewBird(bird);
                        birdDictionary.put(bird, currAviary);
                    }
                }
            }
        }

        // if it cannot be inserted in existing aviaries create a new aviary
        if (!birdDictionary.containsKey(bird)) {
            if (locToAviary.size() == this.capacity){
                throw new IllegalStateException("Cannot create a new aviary for this bird, cause the conservatory is full");
            }

            Aviary newAviary = new Aviaries(locationList[locToAviary.size()]);
            if (bird.getBirdsCategory() == CLASSIFICATION.FLIGHTLESS_BIRDS){
                newAviary.setAviaryType(AVIARYTYPE.FLIGHTLESS_BIRDS);

            } else if (bird.getBirdsCategory() == CLASSIFICATION.BIRDS_OF_PREY) {
                newAviary.setAviaryType(AVIARYTYPE.BIRDS_OF_PREY);
            }else if(bird.getBirdsCategory() == CLASSIFICATION.WATERFOWL){
                newAviary.setAviaryType(AVIARYTYPE.WATERFOWL);
            }else{
                newAviary.setAviaryType(AVIARYTYPE.OTHER);
            }
            newAviary.putNewBird(bird);
            birdDictionary.put(bird, newAviary);
            aviaryList.add(newAviary);
            locToAviary.put(locationList[locToAviary.size()], newAviary);

            // update the food at the end
            for ( FOODS food: bird.getPreferFood()){
                foodQuantities.put(food, foodQuantities.get(food) + 1);
            }



        }
    }

    // print all the required foods and their quantity
    @Override
    public void printFoodQuantityList(){

        System.out.println("FOODS" + " " + "Quantity");
        for(FOODS foods: foodQuantities.keySet()){
            System.out.println(foods + ":" + foodQuantities.get(foods));
        }
    }


    // get the aviary of the inputted bird
    @Override
    public LOCATION getAviaryOfBird(Bird bird){
        return birdDictionary.get(bird).getLocation();
    }


    // print the sign of this aviary that contains all the birds and their interesting info
    @Override
    public void printSignOfAviary(Aviary aviary){
        System.out.println(aviary);
    }

    // print all the aviary and its corresponding location, and the birds in aviary
    @Override
    public void printMap(){
        for (int i = 0; i < 20; i++) {
            LOCATION currLocation = locationList[i];
            if (locToAviary.containsKey(currLocation)){
                System.out.println(locToAviary.get(currLocation));
            }
        }
    }

    // get the birds in alphabetical according to their name
    @Override
    public void printBirdIndex(){
        Bird[] birdsArray = birdDictionary.keySet().toArray(new Bird[0]);

        Arrays.sort(birdsArray, new BirdNameComparator());

        for (Bird bird: birdsArray) {
            System.out.println(bird.getName() + " : " + birdDictionary.get(bird).getLocation());
        }
    }
    //get the list of all the aviary
    @Override
    public ArrayList<Aviary> getAviaryList() {
        return aviaryList;
    }

}
