package questions;

import org.junit.Before;
import org.junit.Test;

import java.net.CacheRequest;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class QuestionBankTest {
  QuestionBank questionBank;
  Question f;
  Question h;
  Question a;
  Question c;
  Question e;
  Question b;
  Question g;
  Question d;
  List<Question> questionList;
  @Before
  public void setup(){
    questionList = new ArrayList<>();
    f = new MultipleSelect("Which of these are included in the Bill " + "of Rights?",
            "1 4", "Freedom of speech", "Freedom to not pay taxes",
            "Freedom to travel anywhere in the world",
            "Right against unreasonable searches and seizures");
    questionList.add(f);
    h = new Likert("Assignment 2 was an easy assignment.");
    questionList.add(h);
    a = new TrueFalse(
            "Did you test to verify that increasing the speed " + "beyond the limit does not work?",
            "True");
    questionList.add(a);
    c = new MultipleChoice(
            "Which one of these options accurately describes your experience in Assignment 2?", // text
            "1", // correct // answer
            "I wrote all my tests before my implementation", // option 1
            "I wrote some but not all tests before my implementation",
            // option 2
            "I tested a little, coded a little, and so on", // option 3
            "I wrote most of my implementation before I wrote tests");
    questionList.add(c);
    e = new MultipleSelect("What is one hour equal to? ", "1 3", // correct answer
            "60 minutes", "60 seconds", "3600 seconds", "half a day");
    questionList.add(e);
    b = new TrueFalse("Did you test for the constructor throwing an "
            + "exception if the speed intervals for gears " + "did not overlap?", "True");
    questionList.add(b);
    g = new Likert("I think PDP is a waste of time.");
    questionList.add(g);
    d = new MultipleChoice("How flexible is your design to adding an extra gear?", // text

            "1", // correct option
            "Very flexible: very less or no code changes required", // option 1
            "Somewhat flexible: some code changes required", // option 2
            "Extensive code changes required");
    questionList.add(d);
    questionBank = new QuestionBank(questionList);

  }
  @Test
  public void testPrint(){
    questionList.get(0);
  }
}