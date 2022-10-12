package transmission;



import java.util.Arrays;

public class AutomaticTransmission implements Transmission{
  int gear; //current gear of the car
  int speed; //current speed of the car
  int speedThreshold[]; // store the speed thresholds for the 6 possible gears

  public AutomaticTransmission(int threshold1, int threshold2, int threshold3, int threshold4, int threshold5){
    if(threshold1 <= 0 || threshold2 <= 0 || threshold3 <= 0 || threshold4 <= 0 || threshold5 <= 0){
      throw new IllegalArgumentException("Speed threshold should be larger than 0");
    }
    speedThreshold = new int[5];
    speedThreshold[0] = threshold1;
    speedThreshold[1] = threshold2;
    speedThreshold[2] = threshold3;
    speedThreshold[3] = threshold4;
    speedThreshold[4] = threshold5;
  }

  /**
   * calculate the gear of the car according to the current speed
   */
  public void calculateCurrentGear(){
    if(speed < speedThreshold[0]){
      setGear(0);
    }else if(speed < speedThreshold[1]){
      setGear(1);
    }else if(speed < speedThreshold[2]){
      setGear(2);
    }else if(speed < speedThreshold[3]){
      setGear(3);
    }else if(speed < speedThreshold[4]){
      setGear(4);
    }else{
      setGear(5);
    }
  }
  public int getGear() {
    return gear;
  }
  private void setGear(int gear){
    this.gear = gear;
  }
  public int getSpeed() {
    return speed;
  }
  public void setSpeed(int speed){
    this.speed = speed;
  }
  @Override
  public Transmission increaseSpeed() {
    speed += 2;
    calculateCurrentGear();
    return this;
  }

  @Override
  public Transmission decreaseSpeed() {
    speed -= 2;
    if(speed < 0){
      throw new IllegalStateException("Speed can't be less than 0");
    }
    calculateCurrentGear();
    return this;
  }

  @Override
  public String toString() {
    return "Transmission   " +
            "(speed = " + getSpeed() +
            ", gear = " + getGear() +
            "\n";
  }


}