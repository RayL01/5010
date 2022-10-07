import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Conservatories implements Conservatory{
  //map location to corresponding aviaries
  //private HashMap<Location, Aviary> Location_Aviary;

  //map the food to its quantity
  private HashMap<Feed, Integer> Food_Quantity;


  //Store the list of aviaries in the conservatory
  private ArrayList<Aviary> aviaryArrayList;

  //Store the info of Bird to its aviaries
  private HashMap<Birds, Aviary> Bird_Aviary;


  public Conservatories(){
    //Location_Aviary = new HashMap<>();
    Food_Quantity = new HashMap<>();
    aviaryArrayList = new ArrayList<>();
    Bird_Aviary = new HashMap<>();

    for (Feed food: Feed.values()){
      Food_Quantity.put(food, 0);//initialize the Food quantity
    }
    for(Location location: Location.values()){//start from the enum Location, initialize the 20 aviaries
      Aviary aviary = new Aviaries(location);
      aviaryArrayList.add(aviary);//initialize with enum in the Location;
      // Location_Aviary.put(location, aviary);//initialize the Location-Aviary map;

    }
  }

  @Override
  public void addBird(Birds birds) {
    if (birds.isExtinct()) {//this bird is already extinct, so we can not assign it to our conservatory.
      throw new IllegalArgumentException("The Bird is a history already, forget it!");
    }
    //Before adding a new bird, check the type of the bird, and make sure
    // Flightless birds, birds of prey, and waterfowl should not be mixed with other bird types.

    int flag = 0;//used for testing whether we have found out an aviary for this bird
    //if after the for loop, it's still zero, then there are no aviary for this bird and vice versa

    for (Aviary aviary : aviaryArrayList) {
      if (aviary.getSize() == 0) {//it's empty, so we can directly put the bird in
        aviary.addBird(birds);
        Bird_Aviary.put(birds, aviary);//put the aviary and the bird into the map
        flag = 1;
        break;
      } else if(aviary.getSize() < 5){//the aviary is not full
        //not empty, and we need to check if the bird in the aviary is BirdsOfPrey
        if (birds instanceof BirdsOfPrey) {// the bird is BirdsOfPrey, and it should group with birdsOfprey
          //First traverse the list, if the birdlist in the aviary is empty, then we
          //can direct add the bird, if not empty, then we should check the bird in the
          // birdlist and make sure they are BirdsOfPrey
          if (aviary.getBird() instanceof BirdsOfPrey) {
            aviary.addBird(birds);
            Bird_Aviary.put(birds, aviary);//put the aviary and the bird into the map
            flag = 1;
            break;
          }
        } else if (birds instanceof FlightLess) {
          if (aviary.getBird() instanceof FlightLess) {
            aviary.addBird(birds);
            Bird_Aviary.put(birds, aviary);//put the aviary and the bird into the map
            flag = 1;
            break;
          }
        } else if (birds instanceof Waterfowl) {
          if (aviary.getBird()instanceof Waterfowl) {
            aviary.addBird(birds);
            Bird_Aviary.put(birds, aviary);//put the aviary and the bird into the map
            flag = 1;
            break;
          }
        } else {
          aviary.addBird(birds);
          Bird_Aviary.put(birds, aviary);//put the aviary and the bird into the map
          flag = 1;
          break;
        }
      }
    }
    if (flag == 0) {
      //flag ==0 means the bird is not assigned to any aviaries
      throw new IllegalArgumentException("No aviary is available for this bird");
    }

    for(Feed feed: birds.getPreferredFood()){
      Food_Quantity.put(feed, Food_Quantity.get(feed) + 1);//Since we add a new bird, increase the quantity of its favorite food
    }
  }


  @Override
  public void calculateFood() {
    System.out.println("Quantity of Food \t Food(Quantity)");
    for (Feed feed: Food_Quantity.keySet()){
      System.out.println(feed + "(" + Food_Quantity.get(feed) + ")");
    }

  }

  @Override
  public Location getAviary(Birds birds) {
    return Bird_Aviary.get(birds).getLocation();
  }

  @Override
  public void printSign(Aviary aviary) {
    System.out.println(aviary);
  }

  @Override
  public void printMap() {
    for (Aviary aviary: aviaryArrayList){
      System.out.println(aviary.getLocation() + "\t Aviary \n" +
              "Birds in the House:\n" +  aviary.getListofBirdByName() + "\n");
    }
  }

  @Override
  public void printIndex() {
    Object[] objects = Bird_Aviary.keySet().toArray();
    Arrays.sort(objects, new Comparator() {
      @Override
      public int compare(Object o1, Object o2) {
        if(o1 instanceof Birds && o2 instanceof Birds){
          Birds b1 = (Birds) o1;
          Birds b2 = (Birds) o2;
          return b1.getBirdName().compareTo(b2.getBirdName());
        }
        throw new RuntimeException("Class exception");
      }
    });

    for(Object object:objects){
      Birds birds = (Birds) object;
      System.out.println("Bird Name: " + birds.getBirdName()+ "\n" + "Location of the bird: " + Bird_Aviary.get(birds).getLocation() + "\n");
    }



  }
  @Override
  public ArrayList<Aviary> getAviaryList() {
    return aviaryArrayList;
  }
}
