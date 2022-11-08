package bignumber;

import org.junit.Test;

import java.math.BigInteger;
import java.util.Random;

import static org.junit.Assert.*;

public class BigNumberImplTest {
  /** Testing. */
  @Test(timeout = 3000)
  public void testNumberCreationByShiftingAndAdding() {
    Random r = new Random(200);
    for (int trial = 0; trial < 50; trial++) {
      BigNumber number = new BigNumberImpl();
      StringBuilder expected = new StringBuilder();
      for (int i = 0; i < 500; i++) {
        int digit = Math.abs(r.nextInt()) % 10;
        if ((i == 0) && (digit == 0)) {
          digit = Math.abs(r.nextInt()) % 9 + 1;
        }
        if ((expected.toString().length() != 0) || (digit != 0)) {
          expected.append(digit);
        }
        number.shiftLeft(1);
        number.addDigit(digit);
      }
      assertEquals(expected.toString(), number.toString());
    }
  }

  /** Testing. */
  @Test(timeout = 3000)
  public void testAddNumbers() {
    Random r = new Random(200);
    BigNumber num1;
    BigNumber num2;
    BigNumber result;

    BigInteger n1;
    BigInteger n2;
    BigInteger expectedResult;

    for (int trial = 0; trial < 20; trial++) {

      StringBuilder expected = new StringBuilder();
      int l = r.nextInt(500);
      for (int i = 0; i < l; i++) {
        int digit = Math.abs(r.nextInt()) % 10;
        if ((i == 0) && (digit == 0)) {
          digit = Math.abs(r.nextInt()) % 9 + 1;
        }
        if ((expected.toString().length() != 0) || (digit != 0)) {
          expected.append(digit);
        }

        // assertEquals(expected.toString(),number.toString());
      }
      num1 = new BigNumberImpl(expected.toString());
      if (expected.toString().length() > 0) {
        n1 = new BigInteger(expected.toString());
      } else {
        n1 = new BigInteger("0");
      }
      expected = new StringBuilder();
      l = r.nextInt(5000);
      for (int i = 0; i < l; i++) {
        int digit = Math.abs(r.nextInt()) % 10;
        if ((i == 0) && (digit == 0)) {
          digit = Math.abs(r.nextInt()) % 9 + 1;
        }
        if ((expected.toString().length() != 0) || (digit != 0)) {
          expected.append(digit);
        }

        // assertEquals(expected.toString(),number.toString());
      }
      num2 = new BigNumberImpl(expected.toString());
      if (expected.toString().length() > 0) {
        n2 = new BigInteger(expected.toString());
      } else {
        n2 = new BigInteger("0");
      }

      result = num1.add(num2);
      expectedResult = n1.add(n2);

      assertEquals(
              "Adding the numbers " + n1.toString() + " and " + n2.toString()
                      + " did not produce the correct result",
              expectedResult.toString(), result.toString());

      assertEquals("Adding 0 to a number does not produce the number itself",
              num1.add(new BigNumberImpl("0")).toString(), num1.toString());

    }

    // trying the case where there is an overflow carry
    StringBuilder string = new StringBuilder();
    for (int i = 0; i < 100; i++) {
      string.append("9");
    }
    num1 = new BigNumberImpl(string.toString());
    num2 = new BigNumberImpl(string.toString());
    result = num1.add(num2);

    n1 = new BigInteger(string.toString());
    n2 = new BigInteger(string.toString());
    expectedResult = n1.add(n2);

    assertEquals("Adding the numbers " + n1.toString() + " and " + n2.toString()
            + " did not produce the correct result", expectedResult.toString(), result.toString());
  }
  @Test
  public void test1(){
    int s = 2;
    s += false ? 1 : 0;
    System.out.println(s);


  }
}