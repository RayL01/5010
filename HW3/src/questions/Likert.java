package questions;


/**
 * Likert: can be answered on a fixed, 5-point Likert scale (Strongly Agree, Agree, Neither Agree nor Disagree, Disagree, Strongly Disagree). This type of question can be created by passing the text of the question.
 * Since this question asks an opinion, there is no "correct" answer. An answer can be entered as one of the option numbers, numbered from 1 in the above order. Any valid option number is a "correct" answer.
 */
public class Likert implements Question{
  /**
   * the text of the question
   */
  private String text;
  private final int order = 4;

  public Likert(String question){
    text = question;
  }
  @Override
  public String getText() {
    return this.text;
  }

  @Override
  public String answer(String s) {

    int answer = Integer.parseInt(s);
    if(answer >=1 && answer <= 5){
      return "Correct";
    }else{
      return "Incorrect";
    }
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

  @Override
  public String toString() {
    return "Likert{" +
            "text='" + text + '\'' +
           "}";
  }
}
