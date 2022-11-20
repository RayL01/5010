package lookandsay;

import org.junit.Test;

import java.math.BigInteger;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2022/11/17/21:57
 * @Description:
 Define a new RIterator interface that extends Iterator and adds two methods: T prev() and boolean hasPrevious().
  Their meanings are self-explanatory. Then define a class LookAndSayIterator that implements RIterator.
  This iterator will return the numbers as BigInteger objects.
 *  */

public class LookAndSayIterator implements RIterator<BigInteger> {
  BigInteger cur;
  BigInteger end;
  BigInteger seed;


  @Override
  public BigInteger prev() {
    /**
     * 2112131211
     *
     * 112321
     */
    BigInteger pre = cur;
    String s = cur.toString();
    StringBuilder res = new StringBuilder();
    int i = 0, j = 1;
    for (; j < s.length(); ) {
      int count = s.charAt(i) - 48;
      while (count-- != 0) {
        res.append(s.charAt(j));
      }
      i += 2;
      j += 2;
    }
    if(res.length() == 0){
      cur = new BigInteger("0");
      return pre;
    }
    cur = new BigInteger(res.toString());
    return pre;
  }

  /**
   * It must offer a constructor that takes two arguments: a starting cur and an end value of type BigInteger.
   * The cur is the number at which the sequence must begin. The iterator should not produce a number greater than the end value.
   * If the cur is not positive, or is not less than the end, or has any zeroes in it, the constructor should throw an IllegalArgumentException.
   *
   * @param cur
   * @param end
   */
  public LookAndSayIterator(BigInteger cur, BigInteger end) {

    String s = cur.toString();
    if (s.contains("0")) {
      throw new IllegalArgumentException("The cur should be positive, or larger than the end, or has no zeroes in it");
    }

    if (cur.compareTo(BigInteger.ZERO) <= 0 || cur.compareTo(end) >= 0) {
      throw new IllegalArgumentException("The cur should be positive, or larger than the end, or has no zeroes in it");


    }
    this.seed = cur;
    this.cur = this.seed;
    this.end = end;

  }

  public LookAndSayIterator() {
    this.seed = new BigInteger("1");

    this.cur = this.seed;
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < 100; i++) {
      stringBuilder.append(9);
    }
    this.end = new BigInteger(stringBuilder.toString());
  }

  public LookAndSayIterator(BigInteger cur) {
    this.seed = cur;
    this.cur = this.seed;
    String s = cur.toString();
    if (s.contains("0")) {
      throw new IllegalArgumentException("The cur should be positive, or larger than the end, or has no zeroes in it");
    }
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < 100; i++) {
      stringBuilder.append(9);
    }
    this.end = new BigInteger(stringBuilder.toString());
    if (cur.compareTo(BigInteger.ZERO) <= 0 || cur.compareTo(end) >= 0) {
      throw new IllegalArgumentException("The cur should be positive, or larger than the end, or has no zeroes in it");
    }
  }

  @Override
  public boolean hasPrevious() {
    return cur.compareTo(seed) >= 0;
  }

  @Override
  public boolean hasNext() {
    return cur.compareTo(end) < 0;
  }


  @Override
  public BigInteger next() {
    // 112321
    // 2112131211
    //We start off with the string version of the cur
    BigInteger pre = cur;
    String s = cur.toString();
    StringBuilder res = new StringBuilder();
    //1113122112132113
    for (int i = 0; i < s.length(); i++) {
      int count = 1;
      if (i != s.length() - 1) {
        while (i != s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
          i++;
          count++;
        }
      }
        char c = s.charAt(i);
        res.append(count).append(c);
    }
    cur = new BigInteger(res.toString());
    return pre;
    }
}



