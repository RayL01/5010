import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DriverTest {
  private Conservatories conservatoryOne;

  private Conservatories conservatoryTwo;

  private Conservatories conservatoryEmpire;


  private Pigeons pigeon1;
  private FlightLess flightLess;
  private Pigeons pigeon2;
  private Pigeons pigeon3;

  // test birds
  private BirdsOfPrey eagle;
  private FlightLess moas;
  private Owls owl;
  private Parrots parrot;
  private Pigeons pigeon;
  private Shorebirds hornedPuffin;
  private Waterfowl goose;



  @Before
  public void setUpEnvironment() throws Exception {
    conservatoryOne = new Conservatories();
    conservatoryTwo = new Conservatories();
    conservatoryEmpire = new Conservatories();

    ArrayList<Feed> foods = new ArrayList<>();
    foods.add(Feed.FISH);
    foods.add(Feed.BERRIES);

//        pigeon1 = new Pigeons("d", Birdtype.EXTINCT_PIGEONS, false, 2, foods);

    // Test IllegalArgumentException on extinction
    pigeon1 = new Pigeons("Real Pigeon", Birdtype.PIGEONS, false, 2, foods);
    flightLess = new FlightLess("KiwisKK",Birdtype.KIWIS, false, 0, foods);
    pigeon2 = new Pigeons("Pigeon Alive", Birdtype.PIGEONS, false, 2, foods);
    pigeon3 = new Pigeons("The Only Dove", Birdtype.DOVES, false, 2, foods);

    // Test extinction

    conservatoryOne.addBird(pigeon1);
    conservatoryOne.addBird(flightLess);
    conservatoryOne.addBird(pigeon2);
    conservatoryOne.addBird(pigeon3);


    ArrayList<Feed> foodEagle = new ArrayList<>();
    foodEagle.add(Feed.FISH);
    foodEagle.add(Feed.BIRDS);
    foodEagle.add(Feed.EGGS);
    foodEagle.add(Feed.INSECTS);

    ArrayList<Feed> foodMoas = new ArrayList<>();
    foodMoas.add(Feed.EGGS);
    foodMoas.add(Feed.BIRDS);
    foodMoas.add(Feed.INSECTS);

    ArrayList<Feed> foodOwl = new ArrayList<>();
    foodOwl.add(Feed.LARVAE);
    foodOwl.add(Feed.VEGETATION);
    foodOwl.add(Feed.INSECTS);

    ArrayList<Feed> foodParrot = new ArrayList<>();
    foodParrot.add(Feed.AQUATIC_INVERTEBRATES);
    foodParrot.add(Feed.VEGETATION);
    foodParrot.add(Feed.LARVAE);
    foodParrot.add(Feed.BUDS);

    ArrayList<Feed> foodPigeon = new ArrayList<>();
    foodPigeon.add(Feed.LARVAE);
    foodPigeon.add(Feed.VEGETATION);
    foodPigeon.add(Feed.SMALL_MAMMALS);
    foodPigeon.add(Feed.INSECTS);

    ArrayList<Feed> foodShoreBird = new ArrayList<>();
    foodShoreBird.add(Feed.SEEDS);
    foodShoreBird.add(Feed.VEGETATION);
    foodShoreBird.add(Feed.INSECTS);

    ArrayList<Feed> foodGoose = new ArrayList<>();
    foodGoose.add(Feed.NUTS);
    foodGoose.add(Feed.SEEDS);
    foodGoose.add(Feed.FRUIT);


    eagle = new BirdsOfPrey("American Eagle", Birdtype.EAGLES,false, 2, foodEagle);
    moas = new FlightLess("China Moas",Birdtype.MOAS,false, 2, foodMoas);
    owl = new Owls("Owlllllllls", Birdtype.OWLS, false, 2, foodOwl);
    parrot = new Parrots("Im Rose One", Birdtype.ROSE_RING_PARAKEET, 10,"Hello",false, 2, foodParrot);
    parrot = new Parrots("Im Rose Two", Birdtype.ROSE_RING_PARAKEET, 10,"World",false, 2, foodParrot);

    pigeon = new Pigeons("Pigeon the killer", Birdtype.PIGEONS, false,2, foodPigeon);
    hornedPuffin = new Shorebirds("Auk the Hulk",Birdtype.GREAT_AUK, false,2, foodShoreBird,new ArrayList<BodyOfWater>(
            List.of(new BodyOfWater[]{BodyOfWater.WETLANDS})));
    goose = new Waterfowl("Goosebumps",Birdtype.GEESE, false,2, foodGoose,new ArrayList<BodyOfWater>(
            List.of(new BodyOfWater[]{BodyOfWater.SALT})));


    conservatoryOne.addBird(eagle);
    conservatoryOne.addBird(moas);
    conservatoryOne.addBird(owl);
    conservatoryOne.addBird(parrot);
    conservatoryOne.addBird(pigeon);
    conservatoryOne.addBird(hornedPuffin);
    conservatoryOne.addBird(goose);
  }




  @Test
  public void getFoodQuantity() {
    conservatoryOne.calculateFood();
  }

  @Test
  public void testGetAviaryOfBird(){
    System.out.println("Test whether the bird is in the correct location: \n");

    System.out.println("Eagle location verified");
    Assert.assertEquals(Location.L3, conservatoryOne.getAviary(eagle));
    System.out.println("Moas location verified");
    Assert.assertEquals(Location.L2, conservatoryOne.getAviary(moas));
    System.out.println("Owl location verified");
    Assert.assertEquals(Location.L1, conservatoryOne.getAviary(owl));
    System.out.println("Parrot location verified");
    Assert.assertEquals(Location.L1, conservatoryOne.getAviary(parrot));
    System.out.println("Pigeon location verified");
    Assert.assertEquals(Location.L2, conservatoryOne.getAviary(pigeon));
    System.out.println("Horned Puffin location verified");
    Assert.assertEquals(Location.L2, conservatoryOne.getAviary(hornedPuffin));
    System.out.println("Goose location verified");
    Assert.assertEquals(Location.L4, conservatoryOne.getAviary(goose));

    System.out.println("\n(Wrong location provided)");
    System.out.println("Horned Puffin location failed");
    Assert.assertEquals(Location.L5, conservatoryOne.getAviary(hornedPuffin));

  }

  @Test
  public void printSignOfAviary() {
    ArrayList<Aviary> aviaryListOne = conservatoryOne.getAviaryList();
    System.out.println("ConservetoryOne:");
    for (Aviary aviary: aviaryListOne) {
      conservatoryOne.printSign(aviary);
    }

  }
  @Test
  public void printMapOne() {
    System.out.println("-----------------------------------------------------");
    System.out.println("----------------- Conservatory  One -----------------");
    conservatoryOne.printMap();
    System.out.println("-----------------------------------------------------");
  }
  public void printMapEmpire() {
    System.out.println("-----------------------------------------------------");
    System.out.println("-----------------Conservatory Empire-----------------");
    conservatoryEmpire.printMap();
    System.out.println("-----------------------------------------------------");
  }

  @Test
  public void printBirdIndex() {
    conservatoryOne.printIndex();
  }
  @Test
  public void addExtinctBird() {
    // Test IllegalArgumentException
    ArrayList<Feed> foods = new ArrayList<>();
    foods.add(Feed.SMALL_MAMMALS);
    foods.add(Feed.FISH);

    Birds extinctBird = new Pigeons("Pigeon the killer",Birdtype.EXTINCT_PIGEONS, true,2, foods);

    System.out.println("Test: Trying to add extincted pigeon into the conservatory");
    conservatoryTwo.addBird(extinctBird);

  }//
  @Test
  public void addHundredBirds(){
    String birdName = "";
    System.out.println("-----------------------------------------------------");
    System.out.println("Added 100 birds to the Birds Empire.");
    for(Integer i = 0; i < 100; i++){
      ArrayList<Feed> foods = new ArrayList<>();
      foods.add(Feed.SMALL_MAMMALS);
      foods.add(Feed.FISH);
      birdName = "The Birds Empire " + i;
      Birds tempBird = new Pigeons(birdName, Birdtype.PIGEONS, false,2, foods);
      conservatoryEmpire.addBird(tempBird);
    }
    printMapEmpire();
  }

  @Test
  public void checkNumOfWings(){
    ArrayList<Feed> foods = new ArrayList<>();
    foods.add(Feed.SMALL_MAMMALS);
    foods.add(Feed.FISH);

    Birds manyWingsBird = new Pigeons("Pigeon the killer",Birdtype.EXTINCT_PIGEONS, true,100, foods);

    conservatoryTwo.addBird(manyWingsBird);
  }

  @Test
  public void outOfFoodRangeTest(){
    ArrayList<Feed> foods = new ArrayList<>();
    foods.add(Feed.SMALL_MAMMALS);
    foods.add(Feed.FISH);
    foods.add(Feed.BIRDS);
    foods.add(Feed.INSECTS);
    foods.add(Feed.VEGETATION);
    foods.add(Feed.AQUATIC_INVERTEBRATES);

    Birds fatOwl = new Pigeons("Fat Boy Owl",Birdtype.OWLS, false,2, foods);

    conservatoryTwo.addBird(fatOwl);
    Assert.assertEquals(new ArrayList<Aviary>(), conservatoryTwo.getAviaryList());
  }

  @Test
  public void validaWaterBirdsTest(){
    ArrayList<Feed> foods = new ArrayList<>();
    foods.add(Feed.SMALL_MAMMALS);
    foods.add(Feed.FISH);
    foods.add(Feed.BIRDS);


    Birds fakeWaterFowl = new Waterfowl("I Cant Swim Bird", Birdtype.GRAY_PARROT, false,2, foods, new ArrayList<BodyOfWater>(
            List.of(new BodyOfWater[]{BodyOfWater.WETLANDS})));

    conservatoryTwo.addBird(fakeWaterFowl);
    Assert.assertEquals(new ArrayList<Aviary>(), conservatoryTwo.getAviaryList());
  }

  @Test
  public void testTypeRoseRingParakeet(){
    for(Aviary aviary: conservatoryOne.getAviaryList()){
      for(Birds birds: aviary.getBirdArray()){
        if(birds instanceof Parrots){
          System.out.println("Type Check:  ROSE_RING_PARAKEET Rose Ring Parakeet is in the Conservatory \n" +
                  "but given bird (Gray Parrot) is not in the Conservatory");
          System.out.println("Status: Failed");
          Assert.assertEquals(birds.getBirdType(), Birdtype.GRAY_PARROT);
        }
      }
    }
  }
  @Test
  public void testTypeGreatAuk(){
    for(Aviary aviary: conservatoryOne.getAviaryList()){
      for(Birds birds: aviary.getBirdArray()){
        if(birds instanceof Shorebirds){
          System.out.println("Type Check:  Great Auk is in the Conservatory \n" +
                  "but given bird (African Jacana) is not in the Conservatory");
          System.out.println("Status: Failed");
          Assert.assertEquals(birds.getBirdType(), Birdtype.AFRICAN_JACANA);
        }
      }
    }
  }
  @Test
  public void testClassificationParrots(){
    ArrayList<Feed> foodParrot = new ArrayList<>(Arrays.asList(Feed.BERRIES,Feed.BIRDS));
    Birds birds = new Parrots("Little bird", Birdtype.ROSE_RING_PARAKEET, 2,"I love you", false, 2, foodParrot);
    System.out.println("Type Check Test if the given bird type is a Parrot");
    System.out.println("Status: Succeeded");
    Assert.assertEquals(Classification.PARROTS, birds.getBirdsClass());
  }

}