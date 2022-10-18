package questions;

/**
 * Multiple choice: offers several options, only one of which is correct.
 * This type of question can be created by passing the text of the question,
 * the correct answer and the options. A question may have at least 3 options, but no more than 8.
 * An answer can be entered as one of the option numbers in a string.
 * For example, "1", "3", etc. Option numbers start at 1.
 */
public class MultipleChoice implements Question{
  private String text;
  private int answer;
  private String option1;
  private String option2;
  private String option3;
  private String option4;
  private String option5;
  private String option6;
  private String option7;
  private String option8;
  private final int order = 2;
  public MultipleChoice(String text, String answer, String option1, String option2, String option3){
    this.text = text;

    this.option1 = option1;
    this.option2 = option2;
    this.option3 = option3;
    //Examine whether the answer is within the options
    this.answer = Integer.parseInt(answer);
    if(this.answer<3 || this.answer >8){
      throw new IllegalArgumentException("The answer should be between 3 and 8");
    }
  }
  public MultipleChoice(String text, String answer, String option1, String option2, String option3, String option4){
    this.text = text;

    this.option1 = option1;
    this.option2 = option2;
    this.option3 = option3;
    this.option4 = option4;
    //Examine whether the answer is within the options
    this.answer = Integer.parseInt(answer);
    if(this.answer<3 || this.answer >8){
      throw new IllegalArgumentException("The answer should be between 3 and 8");
    }
  }
  public MultipleChoice(String text, String answer, String option1, String option2, String option3, String option4, String option5){
    this.text = text;

    this.option1 = option1;
    this.option2 = option2;
    this.option3 = option3;
    this.option4 = option4;
    this.option5 = option5;
    //Examine whether the answer is within the options
    this.answer = Integer.parseInt(answer);
    if(this.answer<3 || this.answer >8){
      throw new IllegalArgumentException("The answer should be between 3 and 8");
    }
  }
  public MultipleChoice(String text, String answer, String option1, String option2, String option3, String option4, String option5, String option6){
    this.text = text;

    this.option1 = option1;
    this.option2 = option2;
    this.option3 = option3;
    this.option4 = option4;
    this.option5 = option5;
    this.option6 = option6;
    //Examine whether the answer is within the options
    this.answer = Integer.parseInt(answer);
    if(this.answer<3 || this.answer >8){
      throw new IllegalArgumentException("The answer should be between 3 and 8");
    }
  }
  public MultipleChoice(String text, String answer, String option1, String option2, String option3, String option4, String option5, String option6, String option7){
    this.text = text;

    this.option1 = option1;
    this.option2 = option2;
    this.option3 = option3;
    this.option4 = option4;
    this.option5 = option5;
    this.option6 = option6;
    this.option7 = option7;
    //Examine whether the answer is within the options
    this.answer = Integer.parseInt(answer);
    if(this.answer<3 || this.answer >8){
      throw new IllegalArgumentException("The answer should be between 3 and 8");
    }
  }
  public MultipleChoice(String text, String answer, String option1, String option2, String option3, String option4, String option5, String option6, String option7, String option8){
    this.text = text;

    this.option1 = option1;
    this.option2 = option2;
    this.option3 = option3;
    this.option4 = option4;
    this.option5 = option5;
    this.option6 = option6;
    this.option7 = option7;
    this.option8 = option8;
    //Examine whether the answer is within the options
    this.answer = Integer.parseInt(answer);
    if(this.answer<3 || this.answer >8){
      throw new IllegalArgumentException("The answer should be between 3 and 8");
    }
  }

  @Override
  public String getText() {
    return this.text;
  }

  @Override
  public String answer(String s) {
    if(Integer.parseInt(s) == this.answer){
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

