package transmission;

public interface Transmission {
  /**
   * A method called increaseSpeed which returns a Transmission object with speed increased by 2 and the appropriate gear.
   * @return
   */
  Transmission increaseSpeed();

  /**
   * A method called decreaseSpeed which returns a Transmission object with speed decreased by 2 and the appropriate gear. This method should throw an IllegalStateException if the speed becomes invalid.
   * @return
   */
  Transmission decreaseSpeed();

}