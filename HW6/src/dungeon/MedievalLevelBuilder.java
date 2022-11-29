package dungeon;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2022/11/28/20:45
 * @Description:
 */
public class MedievalLevelBuilder {
  private Level level;
  private int numOfRooms;
  private int numOfMonsters;
  private int numOfTreasures;
  public MedievalLevelBuilder(int levelNumber, int numOfRooms, int numOfMonsters, int numOfTreasures) {
    if (levelNumber < 0 || numOfRooms < 0 || numOfMonsters < 0 || numOfTreasures < 0) {
      throw new IllegalArgumentException("Illegal argument");
    }
    level = new Level(levelNumber);
    this.numOfRooms = numOfRooms;
    this.numOfMonsters = numOfMonsters;
    this.numOfTreasures = numOfTreasures;
  }
  public void addRoom(String description) {
    if (numOfRooms == 0) {
      throw new IllegalStateException("Insufficient number of rooms");
    }
    numOfRooms--;
    level.addRoom(description);
  }
  public void addGoblins(int roomNumber, int numOfGoblins) {
    if(numOfMonsters < numOfGoblins){
      throw new IllegalArgumentException("the number of Goblins should not be larger than the number of monsters");
    }
    if(roomNumber >= level.getRoomSize()){//2 2
      throw new IllegalArgumentException("target room has not yet been created");
    }
    Monster monster = new Monster("goblin",
            "mischievous and very unpleasant, vengeful, and greedy creature whose primary purpose is to cause trouble to humankind",
            7);
    while(numOfGoblins-- != 0){
      level.addMonster(roomNumber, monster);
      numOfMonsters--;
    }
  }
  public void addOrc(int roomNumber) {
    if (numOfMonsters == 0) {
      throw new IllegalStateException("No more monsters can be added");
    }
    if(roomNumber >= level.getRoomSize()){//2 2
      throw new IllegalArgumentException("target room has not yet been created");
    }
    Monster monster = new Monster("orc",
            "brutish, aggressive, malevolent being serving evil",
            20);

    level.addMonster(roomNumber, monster);
    numOfMonsters--;
  }
  public void addOgre(int roomNumber) {
    if (numOfMonsters == 0) {
      throw new IllegalStateException("No more monsters can be added");
    }
    if(roomNumber >= level.getRoomSize()){//2 2
      throw new IllegalArgumentException("target room has not yet been created");
    }
    Monster monster = new Monster("ogre",
            "large, hideous man-like being that likes to eat humans for lunch",
            50);
    level.addMonster(roomNumber, monster);
    numOfMonsters--;
  }
  public void addHuman(int roomNumber, String name, String description, int hitpoints) {
    if (numOfMonsters == 0) {
      throw new IllegalStateException("No more monsters can be added");
    }
    if(roomNumber >= level.getRoomSize()){//2 2
      throw new IllegalArgumentException("target room has not yet been created");
    }
    numOfMonsters--;
    level.addMonster(roomNumber, new Monster(name,
            description,
            hitpoints));
  }
  public void addPotion(int roomNumber) {
    if (numOfTreasures == 0) {
      throw new IllegalStateException("reach target number of treasures");
    }
    if(roomNumber >= level.getRoomSize()){//2 2
      throw new IllegalArgumentException("target room has not yet been created");
    }
    numOfTreasures--;
    level.addTreasure(roomNumber, new Treasure("a healing potion", 1));
  }
  public void addGold(int roomNumber, int goldCount) {
    if (numOfTreasures == 0) {
      throw new IllegalStateException("reach target number of treasures");
    }
    if(roomNumber >= level.getRoomSize()){//2 2
      throw new IllegalArgumentException("target room has not yet been created");
    }
    numOfTreasures--;
    level.addTreasure(roomNumber, new Treasure("pieces of gold", goldCount));
  }

  public void addWeapon(int roomNumber, String description) {
    if (numOfTreasures == 0) {
      throw new IllegalStateException("reach target number of treasures");
    }
    if(roomNumber >= level.getRoomSize()){//2 2
      throw new IllegalArgumentException("target room has not yet been created");
    }
    numOfTreasures--;
    level.addTreasure(roomNumber, new Treasure(description, 10));
  }

  public void addSpecial(int roomNumber, String description, int value) {
    if (numOfTreasures == 0) {
      throw new IllegalStateException("reach target number of treasures");
    }
    if(roomNumber >= level.getRoomSize()){//2 2
      throw new IllegalArgumentException("target room has not yet been created");
    }
    numOfTreasures--;
    level.addTreasure(roomNumber, new Treasure(description, value));
  }
  public Level build() {
    if (level == null || numOfTreasures != 0 || numOfMonsters != 0 || numOfRooms != 0) {
      throw new IllegalStateException("This level has not been initialized yet");
    }
    return level;
  }
}
