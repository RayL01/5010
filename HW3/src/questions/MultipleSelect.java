package questions;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * offers several options, but there are multiple correct answers.
 * This type of question can be created by passing the text of the question, the correct answer and the options.
 * A question may have at least 3 options, but no more than 8.
 * (Tom's note: theoretically, you have two choices for the constructor: it takes a list of options, or an army of overloading constructors with the only difference being the number of arguments they take.
 * It turns out the test cases expects the latter.) Both the correct answer and the user's answer are entered as the option numbers in a string. For example, "1", "1 3", "4 1", etc. Option numbers start at 1. An answer is correct if and only if it contains all the correct options and none of the incorrect ones.
 */
public class MultipleSelect implements Question{
  private String text;
  private Set<Integer> answer;
  private String option1;
  private String option2;
  private String option3;
  private String option4;
  private String option5;
  private String option6;
  private String option7;
  private String option8;
  public final int order = 3;


  public MultipleSelect(String text, String answer, String option1, String option2, String option3) {
    this.text = text;
    this.answer = new HashSet<>();
    String[] tmp = answer.split(" ");
    for (int i = 0; i < tmp.length; i++) {
      this.answer.add(Integer.parseInt(tmp[i]));//Initialize the answer set
    }
    this.option1 = option1;
    this.option2 = option2;
    this.option3 = option3;

    //examine whether the answers are right
    Iterator<Integer> iterator;
    while ((iterator = this.answer.iterator()).hasNext()) {
      int ans = iterator.next();
      if (ans < 1 || ans > 3) {
        throw new IllegalArgumentException("The answer should be between 1 and 3");
      }
    }
  }


  public MultipleSelect(String text, String answer, String option1, String option2, String option3, String option4) {
    this.text = text;
    this.answer = new HashSet<>();
    String[] tmp = answer.split(" ");
    for (int i = 0; i < tmp.length; i++) {
      this.answer.add(Integer.parseInt(tmp[i]));//Initialize the answer set
    }
    this.option1 = option1;
    this.option2 = option2;
    this.option3 = option3;
    this.option4 = option4;

    //examine whether the answers are right
    Iterator<Integer> iterator;
    while ((iterator = this.answer.iterator()).hasNext()) {
      int ans = iterator.next();
      if (ans < 1 || ans > 3) {
        throw new IllegalArgumentException("The answer should be between 1 and 3");
      }
    }
  }
  public MultipleSelect(String text, String answer, String option1, String option2, String option3, String option4, String option5) {
    this.text = text;
    this.answer = new HashSet<>();
    String[] tmp = answer.split(" ");
    for (int i = 0; i < tmp.length; i++) {
      this.answer.add(Integer.parseInt(tmp[i]));//Initialize the answer set
    }
    this.option1 = option1;
    this.option2 = option2;
    this.option3 = option3;
    this.option4 = option4;
    this.option5 = option5;

    //examine whether the answers are right
    Iterator<Integer> iterator;
    while ((iterator = this.answer.iterator()).hasNext()) {
      int ans = iterator.next();
      if (ans < 1 || ans > 3) {
        throw new IllegalArgumentException("The answer should be between 1 and 3");
      }
    }
  }
  public MultipleSelect(String text, String answer, String option1, String option2, String option3, String option4, String option5, String option6) {
    this.text = text;
    this.answer = new HashSet<>();
    String[] tmp = answer.split(" ");
    for (int i = 0; i < tmp.length; i++) {
      this.answer.add(Integer.parseInt(tmp[i]));//Initialize the answer set
    }
    this.option1 = option1;
    this.option2 = option2;
    this.option3 = option3;
    this.option4 = option4;
    this.option5 = option5;
    this.option6 = option6;

    //examine whether the answers are right
    Iterator<Integer> iterator;
    while ((iterator = this.answer.iterator()).hasNext()) {
      int ans = iterator.next();
      if (ans < 1 || ans > 3) {
        throw new IllegalArgumentException("The answer should be between 1 and 3");
      }
    }
  }
  public MultipleSelect(String text, String answer, String option1, String option2, String option3, String option4, String option5, String option6, String option7) {
    this.text = text;
    this.answer = new HashSet<>();
    String[] tmp = answer.split(" ");
    for (int i = 0; i < tmp.length; i++) {
      this.answer.add(Integer.parseInt(tmp[i]));//Initialize the answer set
    }
    this.option1 = option1;
    this.option2 = option2;
    this.option3 = option3;
    this.option4 = option4;
    this.option5 = option5;
    this.option6 = option6;
    this.option7 = option7;

    //examine whether the answers are right
    Iterator<Integer> iterator;
    while ((iterator = this.answer.iterator()).hasNext()) {
      int ans = iterator.next();
      if (ans < 1 || ans > 3) {
        throw new IllegalArgumentException("The answer should be between 1 and 3");
      }
    }
  }
  public MultipleSelect(String text, String answer, String option1, String option2, String option3, String option4, String option5, String option6, String option7, String option8) {
    this.text = text;
    this.answer = new HashSet<>();
    String[] tmp = answer.split(" ");
    for (int i = 0; i < tmp.length; i++) {
      this.answer.add(Integer.parseInt(tmp[i]));//Initialize the answer set
    }
    this.option1 = option1;
    this.option2 = option2;
    this.option3 = option3;
    this.option4 = option4;
    this.option5 = option5;
    this.option6 = option6;
    this.option7 = option7;
    this.option8 = option8;

    //examine whether the answers are right
    Iterator<Integer> iterator;
    while ((iterator = this.answer.iterator()).hasNext()) {
      int ans = iterator.next();
      if (ans < 1 || ans > 3) {
        throw new IllegalArgumentException("The answer should be between 1 and 3");
      }
    }
  }
  @Override
  public String getText() {
    return this.text;
  }

  @Override
  public String answer(String s) {
    String[] tmp = s.split(" ");
    for (int i = 0; i < tmp.length; i++) {
      if(!this.answer.contains(Integer.parseInt(tmp[i]))){
        return "Incorrect";
      }

    }
    return "Correct";
  }
  public int getOrder(){
    return this.order;
  }

  @Override
  public int compareTo(Object o) {
    if(o instanceof Question){
      Question question = (Question) o;
      return Integer.compare(this.getOrder(),question.getOrder());
    }
    throw new IllegalStateException("the type of the list should be Question");
  }
}
