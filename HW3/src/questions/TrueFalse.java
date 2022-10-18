package questions;

import org.testng.annotations.Test;

/**
 * True/False: can be answered in one of two ways: true or false.
 * This type of question can be created by passing the text of the question and the correct answer.
 * The only valid answer to this type of question is a "True" or "False".
 */
public class TrueFalse implements Question {

  private String text;
  private boolean answer;

  private final int order = 1;

  public TrueFalse(String text, String answer) {
    this.text = text;
    if (!answer.equals("True") && !answer.equals("False")) {
      throw new IllegalArgumentException("The only valid answer to this type of question is a \"True\" or \"False\".");
    }
    this.answer = Boolean.parseBoolean(answer);
  }

  @Override
  public String getText() {
    return this.text;
  }

  @Override
  public String answer(String s) {
    boolean ans = Boolean.parseBoolean(s);
    if (ans == this.answer) {
      return "Correct";
    }
    return "Incorrect";

  }

  @Override
  public int getOrder() {
    return this.order;
  }

  @Override
  public int compareTo(Object o) {
    if(o instanceof Question){
      Question question = (Question) o;
      return Integer.compare(this.getOrder(), question.getOrder());
    }
    throw new IllegalStateException("the type of the list should be Question");
  }
}

