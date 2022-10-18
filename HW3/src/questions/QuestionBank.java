package questions;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class QuestionBank {
  private List<Question> questionnaire;
  public QuestionBank(List questionnaire){
    this.questionnaire = questionnaire;
    Collections.sort(questionnaire);
  }
  public Question pullupQuestion(){
    return questionnaire.get(0);
  }
  public void print(){
    System.out.println(questionnaire);
  }
}
