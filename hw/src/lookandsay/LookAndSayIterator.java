package lookandsay;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2022/11/18/14:12
 * @Description:
 */

import java.math.BigInteger;

/**
 * @author novo
 * @since 2021/11/11
 */
public class LookAndSayIterator implements RIterator<BigInteger> {

  BigInteger curr;

  BigInteger endValue;

  // a starting seed and an end value
  public LookAndSayIterator(BigInteger startingSeed, BigInteger endValue) {
    if (startingSeed.compareTo(BigInteger.ZERO) <= 0
            || startingSeed.compareTo(endValue) >= 0
            || startingSeed.toString().contains("0")) {
      throw new IllegalArgumentException("argument is invalid");
    }
    curr = startingSeed;
    this.endValue = endValue;
  }

  // takes a starting seed as its only argument
  public LookAndSayIterator(BigInteger startingSeed) {
    endValue = new BigInteger("9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
    if (startingSeed.compareTo(BigInteger.ZERO) <= 0
            || startingSeed.compareTo(endValue) >= 0
            || startingSeed.toString().contains("0")) {
      throw new IllegalArgumentException("argument is invalid");
    }
    curr = startingSeed;
  }

  // no arguments
  public LookAndSayIterator() {
    curr = new BigInteger("1");
    endValue = new BigInteger("9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
  }

  @Override
  public BigInteger prev() {
    if (!hasPrevious()) {
      return curr;
    }
    BigInteger previous = curr;
    curr = getPrev();
    return previous;
  }

  // 2112131211
  private BigInteger getPrev() {
    String s = curr.toString();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i += 2) {
      int count = s.charAt(i) - '0';
      int number = s.charAt(i + 1) - '0';
      while (count-- != 0) {
        sb.append(number);
      }
    }
    return new BigInteger(sb.toString());
  }

  @Override
  public boolean hasPrevious() {
    return curr.toString().length() % 2 == 0;
  }

  @Override
  public boolean hasNext() {
    return curr.compareTo(endValue) < 0;
  }

  private BigInteger getNext() {
    String s = curr.toString();
    StringBuilder sb = new StringBuilder();
    int count = 0;
    // 112321
    // 1234
    for (int i = 0; i < s.length(); i++) {
      if (i == 0 || s.charAt(i) == s.charAt(i - 1)) {
        count++;
      } else {
        sb.append(count).append(s.charAt(i - 1));
        count = 1;
      }
    }
    sb.append(count).append(s.charAt(s.length() - 1));
    return new BigInteger(sb.toString());
  }

  @Override
  public BigInteger next() {
    if (!hasNext()) {
      return curr;
    }
    BigInteger previous = curr;
    curr = getNext();
    return previous;
  }
}
