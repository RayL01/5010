package questions;

public interface Question extends Comparable{

  /**
   * get the text for the question
   * @return
   */
  String getText();

  /**
   * takes the provided answer and determines whether it is correct or not
   * @param s
   * @return
   */
  String answer(String s);
  int getOrder();


}
