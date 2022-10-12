package transmission;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AutomaticTransmissionTest {
  private Transmission transmission;
  @Before
  public void setup(){
    transmission = new AutomaticTransmission(2, 10, 20, 40, 50);
  }
  @Test
  public void testIncreaseSpeed(){
    System.out.println(transmission);
    for (int i = 0; i < 30; i++) {

      Transmission transmission1 = transmission.increaseSpeed();
      System.out.println(transmission1);
    }
  }
  @Test
  public void testDecreaseSpeed(){
    /**
     * In order to decrease speed, you have to increase speed first
     */
    System.out.println("Engine started, now speeding");
    System.out.println(transmission);
    for (int i = 0; i < 30; i++) {

      Transmission transmission1 = transmission.increaseSpeed();
      System.out.println(transmission1);
    }

    System.out.println("Now we start to decrease speed");
    System.out.println(transmission);
    for (int i = 0; i < 30; i++) {

      Transmission transmission1 = transmission.decreaseSpeed();
      System.out.println(transmission1);
    }
  }
  @Test
  public void testIllegalThreshold(){
    try{
      Transmission transmission1 = new AutomaticTransmission(-2, 0, 20, 40, 50);
    }catch(IllegalArgumentException e){
      e.printStackTrace();
    }
  }
  @Test
  public void  testIllegalSpeed(){
    try{
      Transmission transmission2 = transmission.decreaseSpeed();
    }catch(IllegalStateException e){
      e.printStackTrace();
    }
  }
}